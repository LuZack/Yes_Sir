
def setup():
    import os
    file_name = '.custom_bash_commands.sh'
    path_name = os.path.join(os.path.expanduser('~'),file_name)
    dir_path = os.path.dirname(os.path.realpath(__file__))
    if not os.path.isfile(path_name):
        with open(path_name, 'w') as shell_file:
            shell_file.write('#!/bin/bash')
            shell_file.write('function hey() {')
            shell_file.write('java -cp '+dir_path+'/target/yes_sir-1.0-SNAPSHOT.jar luzack.app.Main')
            shell_file.write('}')
    else :
        with open(path_name, 'a') as shell_file:
            shell_file.write('function hey() {')
            shell_file.write('java -cp '+dir_path+'/target/yes_sir-1.0-SNAPSHOT.jar luzack.app.Main')
            shell_file.write('}')
    os.system('chmod +x '+path_name)
    os.system('source '+path_name)


if __name__ == '__main__':
    setup()