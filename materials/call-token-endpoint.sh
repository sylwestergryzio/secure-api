#!/bin/bash

# HTTP GET
# http://well-known.org:8080/auth/realms/well-known/protocol/openid-connect/auth
# ?response_type=code
# &client_id=well-known-store
# &redirect_uri=http://well-known.org/callback/code/keycloak
# &scope=email profile openid

CODE=$1

source ./local-env.sh

curl --request POST \
  --url 'http://well-known.org:8080/auth/realms/well-known/protocol/openid-connect/token' \
  --header 'content-type: application/x-www-form-urlencoded' \
  --data grant_type=authorization_code \
  --data client_id=$KC_CLIENT_ID \
  --data client_secret=$KC_CLIENT_SECRET \
  --data code=$CODE \
  --data redirect_uri=http://well-known.org/callback/code/keycloak \
 | python -c 'import json,sys;obj=json.load(sys.stdin);print obj["access_token"]' > ACCESS_TOKEN
