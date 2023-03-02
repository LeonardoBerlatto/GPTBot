import os

commmit_text = os.environ.get('COMMIT_TEXT', '')

commit_parts = commmit_text.split('\n\n')

commit_title = commit_parts[0]

commit_body_lines = commit_parts[1].split('\n')


release_notes_file = open('release_notes.txt', 'w')

release_notes_file.write(commit_title)
for line in commit_body_lines:
    release_notes_file.write('* '.concat(line))
