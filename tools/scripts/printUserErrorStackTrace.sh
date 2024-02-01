#!/bin/zsh

mongo_config() {
    mongo_host="localhost"
    mongo_port="27017"
    mongo_db="HyperBankMongoDB"
    mongo_collection="UserError"
    username="paulmarcelinbejan"
    password="HyperBankPassword"
}

# Check if the correct number of arguments is provided
if [ "$#" -ne 2 ]; then
    echo "Usage: $0 _id true|false"
    exit 1
fi

id=$1
log_to_file=${2:l}

echo ${log_to_file}

mongo_config

# Query MongoDB
user_error_json=$(mongosh --host $mongo_host --port $mongo_port --authenticationDatabase admin -u $username -p $password $mongo_db --quiet --eval "db.$mongo_collection.find({_id: '$id'}).pretty()")

# Print on console or log on file the user_error_json
if $log_to_file; then
    log_file="UserError_${id}.log"
    echo "$user_error_json" >"$log_file"
    echo "UserError for _id '$id' logged to file: $log_file"
else
    echo "UserError for _id '$id':"
    echo "$user_error_json"
fi
