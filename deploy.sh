#!/bin/zsh

# Regular Colors
GREEN='\033[0;92m'
BLUE='\033[1;94m'
RED='\033[0;31m'
YELLOW='\033[0;33m'
COLOR_OFF='\033[0m'

#------------------------------------------------------------------(Common functions)---------------------------------------------------------------------------------------------------------------

printHorizontalLine() {
    echo -e "$YELLOW-------------------------------------------------------------------------------------------------------- $COLOR_OFF"
}

#------------------------------------------------------------------(Deploy functions)---------------------------------------------------------------------------------------------------------------

clear() {
    #Use docker container prune command to clear the disk space used by containers. 
    #This command will remove all stopped containers from the system.
    docker builder prune

    #Use docker buildx prune to remove the Docker build cache.
    #This command will clear the build cache of the default builder.
    #docker buildx prune
}

deploy() {
    MAVEN_MODULE=$1
    PROJECT_VERSION=$2
    DIRECTORY=./$MAVEN_MODULE
    DOCKER_IMAGE=$MAVEN_MODULE:$PROJECT_VERSION

    echo -e "${BLUE}START DEPLOYING $MAVEN_MODULE:$PROJECT_VERSION ... $COLOR_OFF"

    docker build -t "$DOCKER_IMAGE" -t "$MAVEN_MODULE" "$DIRECTORY"

    # Check if the docker command was executed correctly
    if [ $? -eq 0 ]; then
        echo -e "${GREEN}Deploy of $MAVEN_MODULE completed! $COLOR_OFF"
    else
        echo -e "${RED}Error during the deploy of $MAVEN_MODULE !!! $COLOR_OFF"
    fi
    

    printHorizontalLine
}

deployAll() {
    PROJECT_VERSION=$1

    echo -e "${BLUE}START DEPLOYING $GREEN ALL-SERVICES $BLUE ... \n $COLOR_OFF"

    for module in "${MAVEN_MODULES[@]}"; do
        deploy ${module} ${PROJECT_VERSION}
    done
}

#------------------------------------------------------------------(SCRIPT LOGIC)---------------------------------------------------------------------------------------------------------------

PS3="Select the component to deploy: "

# Set the folder to exclude
EXCLUDED_FOLDERS=("hyperbank-config-provider" "tools" "target")

# Get the list of maven modules that can be deployed
MAVEN_MODULES=("hyperbank-config-provider" $(ls -l | grep '^d' | awk '{print $9}' | grep -vE "$(IFS="|"; echo "${(j:|:)EXCLUDED_FOLDERS}")"))

select operation in "${MAVEN_MODULES[@]}" all clear quit

do

    # for operation of MAVEN_MODULES or ALL, ask for PROJECT_VERSION
    if [[ "$(echo "${MAVEN_MODULES[@]}" | fgrep -w "$operation")" || "$operation" == "all" ]]; then
        
        echo -n "Enter a version: " 
        read PROJECT_VERSION

        if [ -z "$PROJECT_VERSION" ]; then
            echo -e  "${RED}Version is missing, try again! $COLOR_OFF";
            exit 1;
        fi

    fi

    if [[ "$operation" == "quit" ]]; then
        echo "Wish you a life without bugs!!!"
        break
    elif [[ "$operation" == "clear" ]]; then
        clear
        break
    elif [[ "$operation" == "all" ]]; then
        deployAll ${PROJECT_VERSION}
        break
    elif [[ "${MAVEN_MODULES[@]}" =~ "${operation}" ]]; then
        deploy ${operation} ${PROJECT_VERSION}
        break
    else
        echo -e "${RED}Ooops!!! - unknown choice $REPLY, try again \n $COLOR_OFF"
    fi

done