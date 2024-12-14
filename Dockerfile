FROM maven:3.9.9-amazoncorretto-17 AS build

WORKDIR /home/maven/project
COPY . .
RUN mvn clean install

FROM amazoncorretto:17
COPY --from=build /home/maven/project/target/*.jar app.jar

ARG AWS_REGION
ENV AWS_REGION=${AWS_REGION}

CMD ["sh","-c","java -jar -Dspring.profiles.active=docker app.jar"]

