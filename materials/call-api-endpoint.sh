#!/bin/bash

SERVER_ROOT="http://well-known.org"
ENDPOINT=$1
ACCESS_TOKEN=`cat ACCESS_TOKEN` 

URL="$SERVER_ROOT/$ENDPOINT"

echo "Calling $URL"

curl -v --request GET \
  --url $URL \
  --header "authorization: Bearer $ACCESS_TOKEN" \
  --header 'content-type: application/json' | python -m json.tool
