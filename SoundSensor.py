firebase = firebase.FirebaseApplication('https://iot-6f673-default-rtdb.firebaseio.com/',None)//to paste firebse link to store the data
servo = Servo(25)
try:
    while True:
        g=firebase.get('gentleSwing','')
        s= firebase.get('strongSwing','')
        if g=="1":
            print("Gentle")
            while True:
                for angle in numpy.arange(-1,1,0.1):
                    servo.value = angle
                    sleep(0.1)
                for angle in numpy.arange(1,-1,-0.1):
                    servo.value = angle
                    sleep(0.1)
                g=firebase.get('gentleSwing','')
                if g=="0":
                    break          
                if s=="1":
            print("Strong")
            while True:
                for angle in numpy.arange(-1,1,0.1):
                    servo.value = angle
                    sleep(0.01)
                for angle in numpy.arange(1,-1,-0.1):
                    servo.value = angle
                    sleep(0.01)
                s=firebase.get('strongSwing','')
                if s=="0":
                    break
except KeyboardInterrupt:
        print("Program stopped")
 
        
