#Set maven version
FROM maven:3.8.5-openjdk-17 as build

#Set work folder
WORKDIR /app

#Copy all project to the conteiner
COPY . .

#Buil the app
RUN mvn clean package -DskipTests

#Define jdk version
FROM openjdk:17

#Set work folder
WORKDIR /app

#Copy app file
COPY --from=build ./app/target/*.jar ./app.jar

ARG RABBITMQ_SERVER=rabbitmq-microservice
ARG EUREKA_SERVER=eureka-server

#Run the app
ENTRYPOINT java -jar -Dspring.profiles.active=docker app.jar

