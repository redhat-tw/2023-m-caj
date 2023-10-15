FROM registry.access.redhat.com/ubi8/openjdk-17:latest
ENV APP_HOME=/home/jboss APP_NAME=payment
EXPOSE 8080
WORKDIR ${APP_HOME}
COPY ./target/${APP_NAME}-0.0.1-SNAPSHOT.jar ./app.jar
USER root
RUN chown jboss:root ${APP_HOME} && \
    chmod -R 755 ${APP_HOME}/app.jar
USER jboss
CMD [ "java","-jar","app.jar" ]
