# emapps_ios
Repository for Automation Test Script [QA] belong to Mitrais Bootcamp Scrum Team4 

!!!!   Notes   !!!

1. Always update iOSEmapps.ipa file with latest one under root directory

2. Build and package your tests for AWS Device farm :
- caps.setCapability("app", app.getAbsolutePath()); --> disable this line in BaseClass.java file --> // caps.setCapability("app", app.getAbsolutePath());
- $ mvn clean package -DskipTests=true
