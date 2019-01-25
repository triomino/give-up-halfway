if [ $# -eq 0 ]
then
    echo Argument needed: start, or stop
    exit 1
fi

if [ $1 == "start" ] ; then
    docker build -t rolling-machine .
    docker run -d -p 8080:8080 --name test rolling-machine
fi

if [ $1 == "stop" ] ; then
    docker exec test ./bin/catalina.sh stop
    sleep 1
    docker container rm test
fi
