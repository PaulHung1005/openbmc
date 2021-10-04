SUMMARY = "GLOME Login Client"
DESCRIPTION = "GLOME login is first application of the GLOME protocol. It is used to authorize serial console access to Linux machines"
PR = "r1"
PV = "0.1+git${SRCPV}"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

inherit meson pkgconfig

DEPENDS += " \
    openssl \
    glib-2.0 \
    "

S = "${WORKDIR}/git"
SRC_URI = "git://github.com/google/glome.git"
SRCREV = "b7084b5c60682a0b4f4ae3f2ec6048e65212c377"

FILES_${PN} += "${libdir}/security"

PACKAGECONFIG ??= ""
PACKAGECONFIG[glome-cli] = "-Dglome-cli=true,-Dglome-cli=false"
PACKAGECONFIG[pam-glome] = "-Dpam-glome=true,-Dpam-glome=false,libpam"

EXTRA_OEMESON = "-Dtests=disabled"
