case "$1" in
    start)
        echo "Starting cizies-led-driver"
        /usr/bin/cizies-led-driver &
        sleep 2
        echo "Starting cizies-looper"
        # TODO: find a better fix than changing permissions here...
        umask 000
        chmod +rw /dev/gpiomem
        su cizies -c /usr/bin/cizies-looper & # run as cizies
        ;;
    stop)
        echo "Stopping cizies-looper"
        # TODO: stop looper
        echo "Stopping cizies-led-driver"
        # TODO: stop led driver
        ;;
    *)
        echo "Usage: $0 {start|stop}"
        exit 1
esac
