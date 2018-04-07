Main Points

- I have used Spring Boot as my framework and its working on top of java maven and tomcat.
- I am using mysql for database.
- All the connections are made using required libraries and by using application.properties file
- Main controller is used to test the databases and provide home page mapping.
- Main Rest Controller is used to map all the rest Service. It is used to provide data to incoming requests which enable us to view
 data from database on web.
- SmsSender is the main script which uses kannel service to call fake sms server. the delivery response is saved in delivery log table.
- Deliverylogs and Msisdns are two models representing database table.
- logRepository abd MSIDrepository provide us whith an interface to make sql queries.
- MainService is used to save, delete or search from repository.
- CsvReader Script reads the provided csv files which consists the phone numbers and saves it into the database.
- HomePage provides different buttons to run the csvreader script, log viewer, msisdns database .

Some Other Points

- System.out.print is used throughout the project to print data on console for testing.
- using port 8081 instead of 8080.
- Most of the classes have comments which will provide a clearer view of what the class does

Systematically:

1. csvreader reads the csv file and saves the value to msisdns table of our database.
2. to view the database we can call localhost:8081/api/data/  which provides us the table data.
3. SmsSender Script reads the value of phone numbers from our database and makes call to fake sms server using localhost:13013 port
4. the response is recieved and is saved into deliveryLogs table of our database.




