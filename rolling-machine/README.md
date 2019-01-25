# API layer (built with low level tools)
Part of backend. API layer between front end and back end.

Try using tools with lower layers.

## build and run with docker
example: 
``` 
docker build -t rolling-machine .
docker run -d -p 8080:8080 rolling-machine
```  

## build and run on host
Check dependencies:
 * curl and an open network
 * jdk11 (not sure whether other version works)

Then run dependencies.sh and build.sh to build and run deploy.sh and start.sh to start.
 
## Challenges
service model: Use tomcat(servlet) + nginx rather than spring MVC.

tasks: Do not use gradle, maven or ant. Write scripts to run tasks like building, testing and deployment.

## tools
JSONObject: temporary tool for serializing the delivering message. Maybe use grpc or write a new one later.

## Just For Learning
This project will be abandoned if I feel these tools are too difficult to use.