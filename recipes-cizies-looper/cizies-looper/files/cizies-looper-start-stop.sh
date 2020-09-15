case "$1" in
    start)
        echo "Starting cizies-led-driver"
        /usr/bin/cizies-led-driver
        sleep 2
        echo "Starting cizies-looper"
        /usr/bin/cizies-looper
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
