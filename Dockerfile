FROM maven:3.9.9-amazoncorretto-17 AS build

WORKDIR /home/maven/project
COPY . .
RUN mvn clean install

FROM amazoncorretto:17
COPY --from=build /home/maven/project/target/*.jar app.jar

ARG AWS_REGION
ENV AWS_REGION=${AWS_REGION}

CMD ["sh","-c","export AWS_ACCESS_KEY_ID=$(cat /run/secrets/aws_access_key) && export AWS_SECRET_ACCESS_KEY=$(cat /run/secrets/aws_secret_key) && java -jar -Dspring.datasource.password=$(cat /run/secrets/db_password) -Dspring.profiles.active=docker app.jar"]

