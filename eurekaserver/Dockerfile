#Define jdk version
FROM openjdk:11

#Set work folder
WORKDIR /app

#Copy app file
COPY ./target/eurekaserver-0.0.1-SNAPSHOT.jar app.jar

#Expose the external port
EXPOSE 8761

#Run the app
ENTRYPOINT java -jar app.jar

