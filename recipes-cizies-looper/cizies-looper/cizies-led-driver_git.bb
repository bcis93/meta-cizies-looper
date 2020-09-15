# See http://git.yoctoproject.org/cgit.cgi/poky/tree/meta/files/common-licenses
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PV = "1.0+git${SRCPV}"

SRC_URI = "git://git@github.com/bcis93/cizies-audio-looper.git;protocol=ssh"
SRCREV = "a9dc3de515eb9bb53e7adfec050b8efae6a4952b"
S = "${WORKDIR}/git/tlc59711"

FILES_${PN} += "${bindir}/led_driver"

TARGET_LDFLAGS += "-lbcm2835"

do_configure () {
	:
}

do_compile () {
	oe_runmake
}

do_install () {
	install -d ${D}${bindir}
	install -m 0755 ${S}/led_driver ${D}${bindir}/cizies-led-driver
}
