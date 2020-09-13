# See http://git.yoctoproject.org/cgit.cgi/poky/tree/meta/files/common-licenses
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PV = "1.0+git${SRCPV}"

SRC_URI = "git://git@github.com/bcis93/cizies-audio-looper.git;protocol=ssh"
SRCREV = "a9dc3de515eb9bb53e7adfec050b8efae6a4952b"
S = "${WORKDIR}/git"

FILES_${PN} += "${bindir}/looper"
#		${sysconfdir}/init.d"

TARGET_LDFLAGS += "-lrt -lasound -lpthread -lportaudio -lbcm2835"

RDEPENDS_${PN} += " \
	alsa-lib \
	portaudio-v19 \
	cizies-led-driver \
	"

DEPENDS = " \
	bcm2835 \
"

#inherit update-rc.d

#INITSCRIPT_PACKAGES = "${PN}"

#INITSCRIPT_NAME_${PN} = "looper-start-stop"

do_configure () {
	:
}

do_compile () {
	oe_runmake
}

do_install () {
	# TODO: Install your binaries/scripts here.
	# Be sure to install the target directory with install -d first
	# Yocto variables ${D} and ${S} are useful here, which you can read about at 
	# https://www.yoctoproject.org/docs/latest/ref-manual/ref-manual.html#var-D
	# and
	# https://www.yoctoproject.org/docs/latest/ref-manual/ref-manual.html#var-S
	# See example at https://github.com/cu-ecen-5013/ecen5013-yocto/blob/ecen5013-hello-world/meta-ecen5013/recipes-ecen5013/ecen5013-hello-world/ecen5013-hello-world_git.bb
	install -d ${D}${bindir}
#	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${S}/looper ${D}${bindir}/
#	install -m 0755 ${S}/server/looper-start-stop.sh ${D}${sysconfdir}/init.d/looper-start-stop
}
