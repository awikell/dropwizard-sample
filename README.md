## DropWizard Sample application

This basic RESTful web-service application is built using the DropWizard framework.

To give it a try, clone / download the source code, and run:
```
mvn clean package
java -jar target/dropwizard-sample-0.0.1-SNAPSHOT.jar server
```
and the application is available on http://localhost:8080

###Available resources:

/blog (GET)

/blog/{id} (GET)

/blog (POST)



