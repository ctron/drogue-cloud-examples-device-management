FROM registry.access.redhat.com/ubi8/ubi:latest as builder

RUN dnf -y install curl java-11-openjdk-headless rsync

RUN curl -sL https://dlcdn.apache.org/maven/maven-3/3.8.3/binaries/apache-maven-3.8.3-bin.tar.gz -o maven.tar.gz
RUN mkdir maven
RUN cd maven && tar --strip-components=1 -xzf ../maven.tar.gz
RUN ln -s /maven/bin/mvn /usr/local/bin

COPY . /usr/src/

WORKDIR /usr/src

RUN mvn -B package

FROM registry.access.redhat.com/ubi8/ubi-minimal:latest

RUN microdnf -y install java-11-openjdk-headless

RUN mkdir /deployments

COPY --from=builder --chown=1001 /usr/src/target/quarkus-app/lib/ /deployments/lib/
COPY --from=builder --chown=1001 /usr/src/target/quarkus-app/*.jar /deployments/
COPY --from=builder --chown=1001 /usr/src/target/quarkus-app/app/ /deployments/app/
COPY --from=builder --chown=1001 /usr/src/target/quarkus-app/quarkus/ /deployments/quarkus/

ENV JAVA_OPTIONS="-Dquarkus.http.host=0.0.0.0 -Djava.util.logging.manager=org.jboss.logmanager.LogManager"

CMD ["java", "-jar", "/deployments/quarkus-run.jar" ]
