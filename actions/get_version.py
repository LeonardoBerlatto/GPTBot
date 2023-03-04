import os

commit_text = os.environ.get('COMMIT_TEXT', '')

print("Commit text"+commit_text)

commit_parts = commit_text.split('\n\n')

commit_title = commit_parts[0]

print("Version "+ commit_title.split(' ')[1])

print(commit_title.split(' ')[1])