import os

def setup():
    log_writer(0, 'setup started')
    import platform
    
    if 'macOS' in platform.platform():
        log_writer(0, 'macOS detected')
        if not os.path.isfile('data/profile.json'):
            profileWriter()    
    else:
        log_writer(2, 'unsupported OS detected')
        log_writer(2, 'exiting')
    pathSetter('.zprofile')
    
def pathSetter(file_name:str):
    path_name = os.path.join(os.path.expanduser('~'),file_name)
    dir_path = os.path.dirname(os.path.realpath(__file__))
    if not os.path.isfile(path_name):
        with open(path_name, 'w') as shell_file:
            shell_file.write('#!/bin/bash\n')
            shell_file.write('function hey() {\n')
            shell_file.write('java -cp '+dir_path+'/target/yes_sir-1.0-SNAPSHOT.jar luzack.app.Main\n')
            shell_file.write('}')
    else :
        with open(path_name, 'a') as shell_file:
            shell_file.write('\nfunction hey() {\n')
            shell_file.write('java -cp '+dir_path+'/target/yes_sir-1.0-SNAPSHOT.jar luzack.app.Main\n')
            shell_file.write('}\n')
    os.system('chmod +x '+path_name)

    export_path = 'export PATH=$PATH:'+path_name
    with open(os.path.join(os.path.expanduser('~'),'.zprofile'), 'a') as bash_file:
        bash_file.write('\n# adding path for yes_sir\n')
        bash_file.write(export_path)
    os.system('source '+os.path.join(os.path.expanduser('~'),'.zprofile'))
    print(os.system('source '+path_name))
    

def profileWriter():
    import json
    
    gender = input('What is your gender: (m/f)')
    name = input('What is your full name: ')
    address = ''
    finish = 0
    if ' ' in name:
        names = name.split(' ')
        ans = input('Is your first name '+names[0]+'? (y/n): ')
        if ans == 'y' or ans == 'yes':
            first_name = names[0]
            last_name = names[1]
            if gender == 'm' or gender == 'man' or gender == 'male':
                prefix = 'Mr.'
                ans = input('Shall I address you Mr.' + names[1]+'? (y/n): ')
            else:
                prefix = 'Ms.'
                ans = input('Shall I address you Ms.' + names[1]+'? (y/n): ')
        else:
            last_name = input('What is your last name: ')
            if gender == 'm' or gender == 'man' or gender == 'male':
                prefix = 'Mr.'
                ans = input('Shall I address you Mr.' + last_name+'? (y/n): ')
            else:
                prefix = 'Ms.'
                ans = input('Shall I address you Ms.' + last_name+'? (y/n): ')
        if ans == 'y':
            address = prefix + ' ' + last_name
            finish = 1
        else:
            address = input('How shall I address you as: ')
            finish = 1
    if not finish:
        address = input('How shall I address you as: ')
        
    profile = {
        'name': name,
        'address': address,
    }
    
    with open('data/profile.json', 'w') as profile_file:
        json.dump(profile, profile_file)
    
    log_writer(0, 'your profile is successfully written in your local device')
            
    
# 0 for INFO, 1 for WARN, 2 for ERROR
def log_writer(log_code:int, msg:str):
    from datetime import datetime
    message = ''
    if log_code == 0:
        message += ':::INFO:::|'
    elif log_code == 1:
        message += ':::WARN:::|'
    elif log_code == 2:
        message += ':::ERROR:::|'
    message += datetime.now().strftime("%d/%m/%Y %H:%M:%S") + '|' + msg
    print(message)
        
if __name__ == '__main__':
    setup()