<h1 align="center">Full Stack Automation Project </h1>
<h3 align="center">Project Sneak Peek</h3>



![Demo](https://github.com/VitalyDukshtein/Full-Stack-Automation-Project/blob/master/Demo.gif)

## **Full Stack Automation Final Project**

### **_This project was created to demonstrate my knowledge and skills in developing Automation Infrastructures for Testing._**
***
### _About_
The project demonstrates a robust automation infrastructure that can be implemented on various applications. 
It is built in a hierarchy order of modules. The modules contain a number of classes with methods.
There are main/common/actions/page_object modules.
In this way, the tests can be created in a simple way with a minimum number of lines of code.
**Big advantage of the infrastructure is that it can be easily maintained!**

### _Project Overview_

The project is an example of infrastructure for automation testing of different kinds of applications:
* Web-based application
* Mobile application
* Web API
* Electron application
* Desktop application

### **_Infrastructure project includes using of:_**
* Page Object Design Pattern
* Project Layers(Extensions/Work Flows/Test Cases...)
* Support of Different Clients/Browsers
* Failure Mechanism
* Common Functionality
* External Files Support
* Reporting System (including screenshots)
* Visual Testing
* DB support
* CI support  

***

### _List of applications used in this project:_
* Myfitnesspal Exercise Webpage - Web-based Application
* Myfitnesspal - Mobile Application
* Students API - Web API
* Todo List - Electron Application
* Windows Calculator - Desktop Application

### _Tools & Frameworks used in the project:_
* Selenium - Web Framework
* TestNG - Testing Framework
* Appium - For mobile testing
* Listeners - Interface used to generate logs and customize the TestNG reports
* MySQL Free Online DB - Used for log-in to Myfitnesspal web page
* [Jenkins](https://www.jenkins.io/)- For tests execution
* REST Assured - For API testing
* Maven - Plugins Installation
* [Allure](http://allure.qatools.ru/) Reports - Reporting system
* [Sikuli](http://www.sikulix.com/) - Visual testing on Myfitnesspal web page
* [Monte Screen Recorder](https://github.com/sbtqa/monte-media/blob/master/src/main/ru/sbtqa/monte/screenrecorder/ScreenRecorder.java) - For failed tests recording

### Tests Execution:
> Each of the applications has a few tests for proof of concept.
> 
These tests can be developed in a simple way, due to robust infrastructure.
[[Sanity Tests]](https://github.com/VitalyDukshtein/Full-Stack-Automation-Project/tree/master/src/test/java/sanity)

### _Configutration:_
The configuration file wasn't attached to the project, since it includes sensitive data, Such as passwords and keys. 

![DataConfig](https://github.com/VitalyDukshtein/Full-Stack-Automation-Project/blob/master/config_file.png)

### _Known Issues:_
Since some of the tests are conducted on a live website, some IDs in the page objects may change.
Hence, the project is for DEMO purposes only.
