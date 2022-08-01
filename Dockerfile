FROM openjdk
WORKDIR rest
ADD auth/target/auth-1.0.jar app.jar
ENTRYPOINT java -jar app.jar
