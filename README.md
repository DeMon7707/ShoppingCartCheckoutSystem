# ShoppingCartCheckoutSystem

A simple Checkout System for a Shop containing core functionalities as specified below - 

***Step 1: Shopping cart***

● You are building a checkout system for a shop which only sells apples and oranges.   

● Apples cost 60p and oranges cost 25p. 

● Build a checkout system which takes a list of items scanned at the till and outputs the total cost 

● For example: [ Apple, Apple, Orange, Apple ] => £2.05 

● Make reasonable assumptions about the inputs to your solution; for example, many candidates take a list of strings as input 

***Step 2: Simple offers***

● The shop decides to introduce two new offers 
  - buy one, get one free on Apples 
  - 3 for the price of 2 on Oranges 

● Update your checkout functions accordingly  
<hr>
The project is composed using Spring boot, Maven and Java 8.

The project takes advantage of some java 8 features.

The commits are tagged as step1 and step 2 so you can check the changes applied accross both revisions.
<hr>

## Steps to run
First clone this repo using ***git clone REPO_LINK***.

You can run the project in one of the following ways:
### Using IDE
Setup/import this clonned project in STS/Eclipse IDE.<br>
Once the project is built, run it as Spring Boot App

### Using Maven command via Command Line
From the project directory, execute below command to run the project as spring boot app via cmd:<br>
***mvn spring-boot:run***

### As an executable jar
The applicattion can also be packaged into a jar file using mvn package command.<br>
Once packaged, in the target folder, you will see a jar file with name of the application as: shoppingcartcheckoutsystem-0.0.1-SNAPSHOT.jar<br>
Run below command to execute tha jar via cmd: <br>
***java -jar PATH_TO_TARGET_FOLDER/shoppingcartcheckoutsystem-0.0.1-SNAPSHOT.jar***
  
### Running Tests
There is a test suite which touches on some basic tests for the simple functionality requested above.<br>
In order to run the test you can simply run mvn clean install from the command line.<br>
Else, you can also run the application as JUnit Tests via STS/Eclipse IDE.
