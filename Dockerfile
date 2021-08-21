# our base build image
FROM maven:3.5-jdk-8 as maven

# copy the project files
COPY ./pom.xml ./pom.xml

# build all dependencies
RUN mvn dependency:go-offline -B

# copy your other files
COPY ./src ./src

# build for release
RUN mvn clean package

# our final base image
FROM gcr.io/distroless/java

# set deployment directory
WORKDIR /spring-generator

# copy over the built artifact from the maven image
COPY --from=maven target/spring-resource-generator-1.0-SNAPSHOT.jar ./generator.jav

# set the startup command to run your binary
ENTRYPOINT ["java", "-jar", "/spring-generator/generator.jar","--help"]