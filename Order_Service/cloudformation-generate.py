import json
import os
from copy import deepcopy
from ruamel.yaml import YAML

###################################################################################

def load_yaml(file):
    with open(file, 'r') as stream:
        return yaml.load(stream)

def load_erp_yaml(file, erp_integration_config):
    with open(file, 'r') as stream:
        content = stream.read()
        for k, v in erp_integration_config.items():
            content = content.replace(k, v)
        return yaml.load(content)

def merge_yaml(a, b, path = None):
    if path is None: path = []
    for key in b:
        if key in a:
            if isinstance(a[key], dict) and isinstance(b[key], dict):
                merge_yaml(a[key], b[key], path + [str(key)])
            else:
                a[key] = b[key]
        else:
            a[key] = b[key]
    return a

def deep_remove_properties(object, properties):
    if isinstance(object, dict):

        for property in properties:
            if property in object and isinstance(object[property], str):
                del object[property]

        for k,v in object.items():
            deep_remove_properties(v, properties)

###################################################################################

yaml = YAML()
yaml.width = 4096
yaml.preserve_quotes = True

api_model = load_yaml('api-contract.yml')
api_model_overrides = load_yaml('api-contract-overrides.yml')
api_model = merge_yaml(api_model, api_model_overrides)

api_schema = deepcopy(api_model['components']['schemas'])
api_schema = {'components': {'schemas': api_schema}}
deep_remove_properties(api_schema, ['description', 'example'])

cloudformation_model = load_yaml('cloudformation-base.yml')

# Combine OpenAPI definition with main Cloudformation stack
cloudformation_model['Resources']['RestApi']['Properties']['Body'] = api_model

# Generate output files
os.makedirs('target', exist_ok = True)

with open('target/cloudformation.yml', 'w') as output_file:
    yaml.dump(cloudformation_model, output_file)
    
with open('target/api-contract.yml', 'w') as output_file:
    yaml.dump(api_model, output_file)

with open('target/api-schema.json', 'w') as output_file:
    output_file.write(json.dumps(api_schema, sort_keys = True, indent = 2, separators = (',', ': ')))    
