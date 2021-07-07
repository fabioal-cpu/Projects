# API Automation
  
INSTALL FRAMEWORK

1. git clone https://github.com/juan-montes-globant/APIAutomationAcademyQC2020.git
2. mvn clean install -DskipTests
3. mvn eclipse:eclipse or mvn idea:idea

Create new branch

3. git checkout -b "name-branch"
4. git add .
5. git commit -m "mensaje"
6. git push origin "name-branch"

Log in to endpoint (mockapi)

7.https://mockapi.io/projects/60e254455a5596001730f35b

8.email: fabio.alarcon@globant.com

9.password: Globantzp10


Steps to run @Test

10.To run test 2: Please go to 'Data' class and modify the variable 'totalNewUsers'. This variable control the total of new user send to the endpoint database

11.To run test 3: Please go to '@DataProvider(name = "user1")' and verify the email variable of this data. If the email is the same as one in the endpoint database, nothing will be sent, otherwise, a new user will be sent

12.To run test 4: Please go to '@DataProvider(name = "user1")'and verify the 'name' and 'lastName' variables of this data. If the variables matches with a endpoint database user,the 'AccountNumber' will be change to the number given in setvariable of the @Test4, otherwise, nothing will be changed