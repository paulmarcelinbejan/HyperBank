#!/bin/zsh

# Regular Colors
GREEN='\033[0;92m'
BLUE='\033[1;94m'
RED='\033[0;31m'
YELLOW='\033[0;33m'
COLOR_OFF='\033[0m'

printHorizontalLine() {
    echo -e "$YELLOW-------------------------------------------------------------------------------------------------------- $COLOR_OFF"
}

readInput() {
    echo -n "Enter PROJECT VERSION: "
    read PROJECT_VERSION

    CONFIG_PROVIDER="hyperbank-config-provider"

    # Set the folder to exclude
    EXCLUDED_FOLDERS=(${CONFIG_PROVIDER} "tools" "target")

    # Get the list of maven modules to run
    MAVEN_MODULES=(${CONFIG_PROVIDER} $(ls -l | grep '^d' | awk '{print $9}' | grep -vE "$(IFS="|"; echo "${(j:|:)EXCLUDED_FOLDERS}")"))

    CURRENT_DIRECTORY=$(pwd)

    # Path to the YAML file application-env_docker
    CONFIG_ENV_DOCKER="$CURRENT_DIRECTORY/${CONFIG_PROVIDER}/cloud_config/application-env_docker.yaml"
}

retrievePort() {
    local module="$1"

    # Use yq to extract the port based on the key
    PORT=$(yq eval ".services.$module.port" "$CONFIG_ENV_DOCKER")
}

retrieveDockerNetwork() {
    # Get the current working directory
    SCRIPT_DIRECTORY=$(pwd)

    # Extract the name of the last component of the path (folder name)
    FOLDER_NAME=$(basename "$SCRIPT_DIRECTORY")

    # Convert folder name to lowercase
    PROJECT_NAME=${FOLDER_NAME:l}

    # Specify the desired network name
    DOCKER_NETWORK="${PROJECT_NAME}-network"
}

createDockerNetwork() {
    # Check if the network already exists
    if docker network ls --filter name="$DOCKER_NETWORK" --quiet | grep -q .; then
        echo -e "${YELLOW}Docker Network $DOCKER_NETWORK already exists. $COLOR_OFF"
    else
        # Create the network
        docker network create "$DOCKER_NETWORK"
        echo -e "${GREEN}Docker Network $DOCKER_NETWORK created. $COLOR_OFF"
    fi
}

dockerRun() {
    local module="$1"

    echo -e "${BLUE}Running ${module} docker image! $COLOR_OFF"

    retrievePort $module

    #docker pull ${module}
    docker run -d -p ${PORT}:${PORT} --name ${module} --network ${DOCKER_NETWORK} -e "CONFIG_PROVIDER_HOST=${CONFIG_PROVIDER}" ${module}:${PROJECT_VERSION} 
}

runConfigProvider() {
    dockerRun ${CONFIG_PROVIDER}

    # Check if the config-provider Docker container is up and running
    counter=1
    while ! curl -s http://localhost:${PORT}/actuator/health | jq -e '.status' | grep -q 'UP'; do
        echo -e "$counter - Waiting for ${CONFIG_PROVIDER} to be healthy..."
        ((counter++))
        sleep 1

        # Abort if counter reaches 60
        if [ "$counter" -eq 15 ]; then
            echo -e "${RED}Aborting. ${CONFIG_PROVIDER} did not become healthy within the expected time. $COLOR_OFF"
            exit 1
        fi
    done

    echo -e "${GREEN}${CONFIG_PROVIDER} is up and running on port ${PORT}! $COLOR_OFF"

    printHorizontalLine
}

runOtherModules() {
    for module in "${MAVEN_MODULES[@]:1}"; do
        
        dockerRun ${module}

        # Check if the docker command was executed correctly
        if [ $? -eq 0 ]; then
            echo -e "${GREEN}${module} started on port ${PORT}! $COLOR_OFF"
        else
            echo -e "${RED}Error running ${module} !!! $COLOR_OFF"
        fi

        printHorizontalLine

    done
}

#-------------------------------------------------------(MAIN SCRIPT LOGIC)-------------------------------------------------------

readInput

retrieveDockerNetwork

createDockerNetwork

runConfigProvider

runOtherModules

