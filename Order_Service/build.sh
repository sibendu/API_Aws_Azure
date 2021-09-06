#!/bin/bash

echo "Installing required Python packages"
pip install ruamel.yaml

echo "Downloading Python packages"
pip install -r requirements.txt -t src

echo "Generating final Cloudformation template"
python cloudformation-generate.py

#HASH=`md5sum target/api-contract.yml | cut -d" " -f 1`
#HASH_ORD_SIM=`md5sum target/api-contract-ord-sim.yml | cut -d" " -f 1`
#TIMESTAMP=`date +%s`
#sed -i -e "s/RestApiDeployment/RestApiDeployment$HASH/g" target/cloudformation.yml
#sed -i -e "s/RestApiOrderSIMDeployment/RestApiOrderSIMDeployment$HASH_ORD_SIM/g" target/cloudformation.yml
#sed -i -e "s/LambdaVersion/LambdaVersion$TIMESTAMP/g" target/cloudformation.yml


