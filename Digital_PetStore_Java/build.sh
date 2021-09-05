#!/bin/bash

echo "Installing required Python packages"
pip install ruamel.yaml

echo "Downloading Python packages"
pip install -r requirements.txt -t src
