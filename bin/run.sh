PORT=$1
docker run -p $PORT:$PORT -e HTTP_PORT=$PORT --rm iriguchi:0.0.1-SNAPSHOT
