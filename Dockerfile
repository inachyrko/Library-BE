FROM azul/zulu-openjdk:17
RUN mkdir -p /usr/src/app/
WORKDIR /usr/src/app/

ARG JAR_FILE=build/libs/MyLibraryBE-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} /usr/src/app/
ENTRYPOINT ["java", "-jar", "MyLibraryBE-0.0.1-SNAPSHOT.jar"]