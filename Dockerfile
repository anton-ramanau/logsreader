FROM centos:7

WORKDIR /app

RUN mkdir logs

VOLUME /app/logs

RUN yum install -y java-1.8.0-openjdk

COPY ./target/logsreader-v.1.0.jar ./logsreader-v.1.0.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "logsreader-v.1.0.jar"]