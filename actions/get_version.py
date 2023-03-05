import os

commit_text = os.environ.get('COMMIT_TEXT', '')

commit_parts = commit_text.split('\n')

commit_title = commit_parts[0]

print(commit_title.split(' ')[1])