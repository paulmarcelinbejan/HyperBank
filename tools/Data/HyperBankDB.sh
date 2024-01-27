#!/bin/zsh

OPERATIONS=("backup" "restore")

select operation in "${OPERATIONS[@]}" quit; do

    if [[ "$operation" == "quit" ]]; then
        echo "Wish you a life without bugs!!!"
        break
    elif [[ "$operation" == "backup" ]]; then
        echo "Backing up..."
        docker exec -t postgresql-db pg_dump -U paulmarcelinbejan -d HyperBankDB >HyperBankDB-BACKUP.sql
        echo "Backup created"
        break
    elif [[ "$operation" == "restore" ]]; then
        echo "Restoring..."
        docker exec -i postgresql-db psql -U paulmarcelinbejan -d HyperBankDB <HyperBankDB-BACKUP.sql
        echo "Restore completed"
        break
    else
        echo -e "Ooops!!! - unknown choice"
        exit 1
    fi

done
