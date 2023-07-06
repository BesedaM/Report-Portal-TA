# fetch basic image
FROM maven:3.3.9-jdk-8

# application placed into /app
WORKDIR /app

# selectively add the POM file and
# install dependencies
COPY pom.xml .
COPY src src
# rest of the project
RUN mvn clean install -DskipTests

# execute
CMD ["mvn", "test"]