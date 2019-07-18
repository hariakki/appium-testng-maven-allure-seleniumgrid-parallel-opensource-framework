# Appium / TestNG / Maven / Allure / Selenium Grid / Run Tests in Parallel

The app under test is called Menelic - https://menelicvisitor.com/ It is a visitor's app used to follow when people have checked in and checked out. It is a really good one and comes with discounted packages for schools and small companies.


Note: If you want to run the tests against a virtual iOS device you need to be on a mac

Compprehensive List of all the tools you will need:
Homebrew
Carthage
Node & NPM
JDK
Xcode
authorize-ios
ios-deploy
ideviceinstaller
ios_webkit_debug_proxy
Appium
Appium Doctor
Maven
IntelliJ
TestNg


Prerequisites:
Java 1.8
Maven 3.6.1
Android Studio (3.4)
XCode (10.2.1)
Appium 1.13.0
Appium-Doctor
Node (12.3.1)
Npm (6.9.0)

Before you run the appium server, run 
$ appium-doctor
and find which dependencies you are missing.

Start appium server
$ appium


The tests are executed from /resources/TestNGExecuteTests.xml

For Android you would need to have the VM set up through Android Studio > AVD Manager and have the same name and OS as the name and OS provided in the android capabilities suite. The VM needs to be running prior to starting the tests.

For iOS you would need to install in your XCode all the required OS versions. There is no need for the VM to be running before the tests.

Start the TestNG tests with
$ mvn clean test
All tests reinstall the app to the VM provided depending on the OS provided. The installation apps are in /resources/app folder

You can create an Allure Report with running after $ mvn clean test => 
$mvn site
The report can be found at /target/site/allure-maven.html and you can open it with any browser
