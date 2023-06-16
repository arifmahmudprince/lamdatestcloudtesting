# lamdatestcloudtesting
This is a simple web login form automation with selenium to run in LamdaTest for experimenting cloud testing.

What does this project bring?

-Simple web login form automation
-Integration for cloud testing in LamdaTest
-Parallel testing in different OS and different browser version
-Test management through TestNG

How do I continue?

-Create your account in LamdaTest, use the free version
-Get access info in LamdaTest, username, acesskey
-Prepare your automation project. I would say to try with a small one at first
-Set your access info in driver capabilities
-Prepare TestNG for your test management

Where can I see automation test result?

-Login to your LamdaTest account
-Find the segment Automation/Build
-In this segment you can see details of your test automation result/report
-You can record & download your test video, see categorized log details like info, error, exception, warning
-You can capture and download screenshot for each steps
-Importantly, you can test your locally hosted web
-Notably, you can set up your own desired capabilities and sample code will be generated in LamdaTest

Prior knowledge-

-You need to have minimal prior knowledge in web/app automation like what is selenium, TestNG, and any programming language

How to run this project?
-Clone this project from github
-You need to have JDK 11 and gradle 8 or over
-From gitbash you need to run the command - gradle clean test
-If the aforementioned command does not work, please run - gradle clean test -D testmanager.xml
-You can also run the testng file manually from any IDE
