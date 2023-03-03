import os

branch = os.environ.get('BRANCH_NAME', '')

print(branch.split('/')[1])