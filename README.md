# Baby-Monitoring-System-IOT-
![app(gs)](https://user-images.githubusercontent.com/89723991/152169976-e6f4b01c-0860-4e92-9c4a-9a8f7d4255ae.jpg)
![app(ss)](https://user-images.githubusercontent.com/89723991/152170137-678e3b29-d205-4386-8b3d-3d5a8cc92776.jpg)
![hardware setup (2)](https://user-images.githubusercontent.com/89723991/152170270-0da1165e-a23b-4af6-a083-209b841eba46.jpg)
![hardware setup](https://user-images.githubusercontent.com/89723991/152170358-8e44ffea-d51c-442f-9b2d-13908bb84446.jpg)
![ipro(landscape)](https://user-images.githubusercontent.com/89723991/152170383-bc663aea-eb84-42c8-b841-3b2a35c3a89e.jpg)
![ipro(p)](https://user-images.githubusercontent.com/89723991/152170423-67e6dbab-e811-4836-90e4-f7a0883b6172.jpg)
![notification](https://user-images.githubusercontent.com/89723991/152170440-1cd21e01-766e-424f-a176-fc10800c3acb.jpg)
![Temperature display](https://user-images.githubusercontent.com/89723991/152170454-0eeea3d0-0ed6-49d4-a902-d7c7adeea188.jpg)



    1 	INTRODUCTION 
Since the very beginning of humanity, parents have had the instinct to protect their children from all probable dangers and risks. However, how parents take care of their children has changed dramatically with recent technological breakthroughs. They have benefitted from these breakthroughs and innovations in terms of resolving the safety issues of their babies 
 Monitoring a baby 24/7 is a tough job as well as improbable for parents, especially while working. Hiring a babysitter to take care of the baby is one option and also dropping off the baby at a daycare center is another alternative option to this problem. But these two solutions may not be preferred by parents because they can’t be sure about their baby’s safety and trust their baby to someone else without adequate supervision. In this perspective, a smart baby monitoring system can be an acceptable solution to remove the stress of the parents while taking care of their babies. 
 
    2 	LITERATURE SURVEY  
The baby monitoring system proposed by Soukaina Bangui, Mohammed El Kihal, and Yassine Salih-Alj provides an enhanced noise-canceling system to overcome the external noise to make babies’ rooms more comfortable. Prof. Kranti Dive, Prof. Gitanjali Kulkarni have presented a paper on designing a system for monitoring infants using embedded systems. It consists of a door sensor, LDR-based light sensor, and voice detection module for monitoring infants. An alarm is attached to the system to give an alert. The baby monitoring system presented by Savita P. Patil, Manisha R. Mhetre based on the GSM network can monitor body temperature, moisture, pulse rate, and movement of a baby and deliver the data using the GSM network. 
 
    3 	METHODOLOGY  
Raspberry Pi 3 Model B+ will be the central processing unit working with Arduino Uno for interfacing analog sensors. The Raspberry Pi is a low-cost credit-card-sized microcontroller that can record telemetry data from sensors and update it to the Google firebase database. Raspberry Pi has 4 USB ports as well as it has 40 GPIO pins for interfacing various sensors. Figure 1 shows the working of the proposed baby monitoring system. 
   
An analog condenser microphone (KY-038) is interfaced with Arduino UNO to detect the baby’s crying and send a digital signal about it to the Raspberry Pi. A Pi camera is mounted on the cradle to provide a real-time video stream of the baby and its surroundings.  
The condenser microphone picks up the analog sound signals from the baby’s surroundings and transforms them into electrical signals. The digital pin is set to high and is passed to the GPIO when the frequency exceeds the threshold. If the baby is crying, the GPIO is set as high and a notification is sent. If the baby is sleeping, the GPIO is set low.  
  
In order to monitor the baby’s activities, various sensors are attached to the Cradle.  A DHT11 sensor is passed to the GPIO of Raspberry Pi and is used to monitor the baby’s temperature and also detect the wetness of the bed. The cry detection module analyses the microphone which eventually triggers the swinging mechanism when required.  
The telemetry data collected from the sensors will be stored in Google Firebase and analyzed at regular intervals by an algorithm. An instant notification will be generated and sent to the Android Mobile Application in case any abnormal activity is detected. A Pi Camera is mounted on the cradle for video streaming. The Mobile Application has UI buttons for controlling the swinging mechanism of the cradle (can be turned on, off & control speed), provision for viewing the live stream & controls for playing the toy whenever the baby cries.  
   
    4.    COMPARISION WITH PREVIOUS WORKS 
 An analytical comparison of our proposed system is done with existing systems that have been mentioned earlier in the paper. We can see that Soukaina Brangui, Mohammed El Kihal, and Yassine Salih-Alj have presented a paper regarding a noise-canceling system for controlling and monitoring the baby’s environment. In our proposed system Raspberry Pi 3 Model B+ module a condenser MIC is employed to detect the crying sound of a baby and the obtained data is filtered out to reduce noise. Savita P.Patil, Manisha R worked on a system that monitors the vital parameters of babies and sends the data using GSM technology. They have employed a microcontroller for this purpose which is less effective than a Raspberry Pi. Our system will transfer data to the mobile using a real-time cloud database so that all concerned people can directly see the baby’s situation. 
        Another paper presented a baby monitoring system using a microcontroller mainly to monitor a baby and needed to be attached to the cradle whereas our proposed system is incorporated into the Raspberry Pi board which makes the device simple and can be moved from one place to another place without any hassle. The Raspberry Pi camera can capture high-definition video and also has libraries built in to implement RTSP server for live streaming 
        
    5. CONCLUSION 
The baby monitoring system is a boon for working parents to observe their babies in this busy era. It takes advantage of advances in the field of IoT to reduce the stress in parents. As discussed in the introduction, we aim to develop a smart baby monitoring system that enhances the baby’s security by introducing remote monitoring. Effective use of our proposed system can reduce the anxiety of parents since the safety issue of the baby is resolved in this system. Although this system is implemented, further improvement and modification of the system can be done when deemed necessary.

