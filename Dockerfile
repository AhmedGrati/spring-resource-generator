FROM adoptopenjdk/openjdk11:alpine-jre
CMD ["mvn","clean package -DskipTests"]
ADD  target/*.jar app.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","app.jar"]