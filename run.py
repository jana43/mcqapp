import os
os.system('./gradlew assembleDebug')
ask  = input("do you want to install the apk y or n")
if ask == "y":
    os.system('adb -d install -r "/home/sjana/mcqapp/app/build/outputs/apk/debug/app-debug.apk"')
else:
    print("apk not installed")