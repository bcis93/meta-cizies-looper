# See http://git.yoctoproject.org/cgit.cgi/poky/tree/meta/files/common-licenses
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PV = "1.0+git${SRCPV}"

SRC_URI = "git://git@github.com/bcis93/cizies-audio-looper.git;protocol=ssh"
SRCREV = "a401c9c638cb1e3ada1480bad2c0f7ee790c2e94"
S = "${WORKDIR}/git"

SRC_URI += " file://cizies-looper-start-stop.sh"

FILES_${PN} += "${bindir} ${sysconfdir}/init.d"

TARGET_LDFLAGS += " -lrt -lasound -pthread -lportaudio -lbcm2835"
TARGET_CFLAGS = "-g -Wall -Werror -O3"
EXTRA_OEMAKE += " CC='${CXX}'"

RDEPENDS_${PN} += " \
	alsa-lib \
	portaudio-v19 \
	cizies-led-driver \
    alsa-utils \
    alsa-tools \
	"

DEPENDS = " \
    portaudio-v19 \
	bcm2835 \
"

inherit update-rc.d
INITSCRIPT_PACKAGES = "${PN}"
INITSCRIPT_NAME_${PN} = "cizies-looper-start-stop.sh"

do_configure () {
	:
}

do_compile () {
	oe_runmake
}

do_install () {
	install -d ${D}${bindir}
	install -m 0755 ${S}/looper ${D}${bindir}/cizies-looper

    install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/cizies-looper-start-stop.sh ${D}${sysconfdir}/init.d
}
