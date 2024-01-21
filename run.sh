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

    # Set the folder to exclude
    EXCLUDED_FOLDERS=("hyperbank-config-provider" "tools" "target")

    # Get the list of maven modules to run
    MAVEN_MODULES=("hyperbank-config-provider" $(ls -l | grep '^d' | awk '{print $9}' | grep -vE "$(IFS="|"; echo "${(j:|:)EXCLUDED_FOLDERS}")"))

    CURRENT_DIRECTORY=$(pwd)

    echo -e "Current directory: ${CURRENT_DIRECTORY}"

    # Path to the YAML file application-env_local
    CONFIG_ENV_LOCAL="$CURRENT_DIRECTORY/hyperbank-config-provider/cloud_config/application-env_local.yaml"

    echo -e "Config env_local file path: ${CONFIG_ENV_LOCAL}"
}

retrievePort() {
    local module="$1"

    # Use yq to extract the value based on the key
    port=$(yq eval ".env.services-server-port.$module" "$CONFIG_ENV_LOCAL")
}

#-------------------------------------------------------(MAIN SCRIPT LOGIC)-------------------------------------------------------

readInput

for module in "${MAVEN_MODULES[@]}"; do
    echo -e "$BLUE Running ${module} docker image! $COLOR_OFF"
    
    retrievePort $module

    docker pull ${module}
    docker run -d -p ${port}:${port} --name ${module} ${module}:${PROJECT_VERSION} 

    # Check if the docker command was executed correctly
    if [ $? -eq 0 ]; then
        echo -e "$GREEN $module started on port ${port}! $COLOR_OFF"
    else
        echo -e "$RED Error running $module !!! $COLOR_OFF"
    fi

    printHorizontalLine
done
