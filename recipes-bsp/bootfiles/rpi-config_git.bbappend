do_deploy_append() {
    echo "# Enable Fe-Pi Audio" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt
    echo "dtoverlay=fe-pi-audio" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt
}

