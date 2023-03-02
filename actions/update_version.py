import os

new_version = os.environ.get('VERSION')

with open('gradle.properties') as file:
    lines = file.readlines()
lines[0] = 'version=' + new_version

with open('gradle.properties', 'w') as out_file:
    for line in lines:
        out_file.write(line)

