FROM amd64/openjdk:17

WORKDIR /app

COPY BooksApp-0.0.1-SNAPSHOT.jar /app

ENTRYPOINT ["java", "-jar", "BooksApp-0.0.1-SNAPSHOT.jar"]

#ARG jar_name=BooksApp-0.0.1-SNAPSHOT.jar
#
#COPY target/$jar_name /usr/local/$jar_name
#
#WORKDIR /usr/local/
##
##RUN ["ls", "."]
##
##RUN ["pwd"]
#
#
#CMD ["java", "-jar", "BooksApp-0.0.1-SNAPSHOT.jar"]