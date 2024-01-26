#!/bin/zsh

# Regular Colors
GREEN='\033[0;92m'
BLUE='\033[1;94m'
RED='\033[0;31m'
YELLOW='\033[0;33m'
COLOR_OFF='\033[0m'

# Check if the config-provider Docker container is up and running
counter=1
while ! curl -s http://localhost:${PORT}/actuator/health | jq -e '.status' | grep -q 'UP'; do
    echo -e "$counter - Waiting for ${CONFIG_PROVIDER} to be healthy..."
    ((counter++))
    sleep 1

    # Abort if counter reaches 30
    if [ "$counter" -eq 30 ]; then
        echo -e "${RED}Aborting. ${CONFIG_PROVIDER} did not become healthy within the expected time. $COLOR_OFF"
        exit 1
    fi
done

echo -e "${GREEN}${CONFIG_PROVIDER} is up and running on port ${PORT}! $COLOR_OFF"
