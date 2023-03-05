import os

commmit_text = os.environ.get('COMMIT_TEXT', '')

commit_parts = commmit_text.split('\n')

version = os.environ.get('VERSION', '')

commit_body_lines = commit_parts[1::]

release_notes_file = open('release_notes.txt', 'w')

release_notes_file.write(f'# Version {version}\n\n')
release_notes_file.write('## Features:\n\n')
for line in commit_body_lines:
    release_notes_file.write(f'* {line}\n')
