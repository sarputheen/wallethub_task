# WalletHub Interview Test Framework

## Tech stack Used
Java, Cucumber, Selenium Webdriver, TestNG, Extent

# Prerequisites 
- Java 8 and above 
- Any IDE 
- Install Maven and set the Environment Variable
- For Cucumber's actual flavour, install a plugin for cucumber in IDE and convert project into cucumber project
- Download and Extract this project to your local or use git clone https://github.com/sarputheen/wallethub_task.git
- Import as a Maven project in any IDE


### To run in Docker
- Install Docker or Docker Desktop (Refer url https://docs.docker.com/engine/install/)
- Open Docker Desktop or Start the Docker Engine
- Open Command and give cd "Project Folder"
- Then enter command docker-compose up -d
    
## Project Setup 
- Driver setup and capabilities : \src\main\java\com.wallethub.driverInit\
- Page Obejcts 					: \src\main\java\com.wallethub.pageObjects\
- Failure Retry					: \src\main\java\com.wallethub.retryCase\
- Web Utilities 				: \src\main\java\com.wallethub.webUtilities\
- Web Configs 					: \src\test\resources\driver\WebConfig
- Test Runner  					: \src\test\java\com.wallethub.testfactory\
- Step Definitions 				: \src\test\java\com.wallethub.stepDefinitions\
- Feature files 				: \src\test\resources\Features\
- Extent Configs				: \src\test\resources\extent-config\
- Extent Properties				: \src\test\resources\

## Pre-Steps
- If you want to update URL, please open config.properties from Web Config and update it.
- In you want to run the project in docker, in config properties change the runmode to remote and if you want to run in local change the runmode to local(By default its in local)

## Steps to run
- Open tesNG.xml file, from "TestNGXML" folder
- Now run as TestNG Suite
or
- go to the project folder using command line and use mvn clean install
or
- Open the pom.xml in the project
- Right Click inside the pom.xml content
- Hover to "Run As" option
- Click on Run Configuration
- Set Goal as "clean install" and click on the "Run" button

## Approach 
Below are the points considered while creating the framework
- Project - Maven Project
- Design pattern - Page object model
- Framework - Cucumber(For Test approach), Selenium Driver(For UI Automation), TestNG(For Test Execution and Retry Failed Cases), Extent(For Report)
- Language - Java

### Below mentioned are the information on how I built the project
- In test/resources we have Feature file has the test cases in gherkin language(BDD) that needs to be executed and associated StepDefinition file is available in test/java which has all the relevant stepdefinitions for the cucumber feature file.
- A testrunner file is available in test/java, which is used to trigger the cases from Feature - StepDefinition file. In TestRunner we have tags that associates which cases to be triggered.
- In PageObject package, we have BasePage that contains all the common functions necessary for doing comman actions like click, getText, send Text...etc and PageObject contains pages that has all the Locators and Actions to be performed. Basically, Stepdefinition file will call the PageObject and PageObject's classes are extended with Base Page, So from StepDefinition we call all the relevant actions.
- There is Utils package which contains class to get the information from Property Files.
- In RetryCase package we have classes that supports Retry the cases on Failure.
- Now we have TestNG folder, that has testNG.xml which will be used to trigger the runner class.
- In property files we have all the configuartions that needs to run the case
- Docker-compose.yaml is available to trigger the images that required to run the scenarios 

### Below mentioned are the information on how Test case are triggered
- If we run the Pom.xml as maven build, it has Surfire plugin which has the XML file location, that triggers the TestNG.xml file and in TestNG.xml we have the location to trigger the Runner file.
- Now runnerfile will have the Feature and Step Def file which triggers the cases.
- If we are using Docker, then in config.properties, we have Seleniumhub url that is associated with images, so our project will connect to the port of Docker and runnthe cases in Docker.

## Note 
I have added retry scenarios on failures. If by chance any case fails while execution, then it will automatically triggers the failed cases. If any case got failed, it will be marked as Skipped in Console as it got retried and passed on second execution.
Also I have used chrome profiling for facebook task. Before starting the test login with chrome once and if you want to change the driver configuration, go to this directory \src\main\java\com.wallethub.driverInit\ and make changes. To know how to set the Chrome profile, Please refer this site https://chromium.googlesource.com/chromium/src/+/HEAD/docs/user_data_dir.md#Environment-Linux

## Next Step of Framework Implementation
- Parallel and crossbrowser testing also can be added in this framework using TestNG
- This can be integrated with cirecle CI/Jenkins/Github actions (CI/CD), Browserstack (Compatability/Cloud execution), TestRail/Jira (Test Management Tool)
