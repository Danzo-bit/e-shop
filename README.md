#e-shop ecommerce project

 E-shop is an automated commerce project built with the following: Spring framework, java,mySQL,
 and maven as a build tool
 
##Features
RestAPI that includes the following:
Add products to database
Find products by id
Find all products
Delete products

Spring MVC with thymeleaf template engine for viewing products details

##Installation
Step 1: clone repository
step 2: install dependencies: cd into the root and run the following command:

`mvn install`

Step 3: Setup database: run sql script in the db folder

`src/main/resource/db/setup-db.sql`

Step4: Run the project

`mvn spring-boot-run`