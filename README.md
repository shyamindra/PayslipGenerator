# PayslipGenerator
Generates a payslip - takes a csv file with details as input

#Instructions
1. Down the project as a maven project 
2. run mvn package
3. Execute the project using the following command java -jar target\MyobChallenge-0.0.1-SNAPSHOT.jar input.csv output.csv

or

1. Download the entire repo
2. Execute the jar in the target folder using the command java -jar target\MyobChallenge-0.0.1-SNAPSHOT.jar input.csv output.csv

#Usage
java -jar [jar file] [input file] [output file]
eg. java -jar target\MyobChallenge-0.0.1-SNAPSHOT.jar input.csv output.csv

#Input format(First name,last name,annual salary, super rate(%), payment start date)
David,Rudd,60050,9%,01 March - 31 March
Ryan,Chen,120000,10%,01 March - 31 March

#Output format(name, pay period, gross income, income tax, net income, super)
David Rudd,01 March – 31 March,5004,922,4082,450
Ryan Chen,01 March – 31 March,10000,2696,7304,1000

#Assumptions
1. The payslip is always generated for the entire month
2. The input file will have all the required fields for all the employees
3. The existing information in the output.csv file is not required, and would always be overwritten everytime the program is run
4. The annual salary is equally divided for each month, irrespective of the number of days in the month, i.e. the employee will get paid equally for both February and March even though the number of days are different. 
5. The values provided in the input file are not erroneous, i.e. all the values would be entered and should be correct values.
