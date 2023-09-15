#Set maven version
FROM maven:3.8.5-openjdk-11 as build

#Set work folder
WORKDIR /app

#Copy all project to the conteiner
COPY . .

#Buil the app
RUN mvn clean package -DskipTests

#Define jdk version
FROM openjdk:11

#Set work folder
WORKDIR /app

#Copy app file
COPY --from=build ./app/target/*.jar ./app.jar

#Expose the external port
EXPOSE 8761

#Run the app
ENTRYPOINT java -jar -Dspring.profiles.active=docker app.jar

