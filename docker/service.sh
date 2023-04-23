#!/bin/bash

set -xeuf -o pipefail

ROOT="$( readlink -f "$( dirname "${BASH_SOURCE[0]}" )" )"
DOCKER_FILE="${ROOT}/docker-compose.yaml"

export PSQL_DATA_DIR="${ROOT}/data"

if [[ $1 == "up" ]]; then
    docker-compose --file "$DOCKER_FILE" up --detach
fi

if [[ $1 == "down" ]]; then
    docker-compose --file "$DOCKER_FILE" down
fi