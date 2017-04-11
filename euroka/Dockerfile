FROM hub.c.163.com/oliver_lee/springcloud/configserver:base
MAINTAINER limingming
COPY . /home/lzt
ENV JAVA_HOME=/usr/lib/jvm/java-8
ENV JRE_HOME=${JAVA_HOME}/jre
ENV M2_HOME=/opt/maven/apache-maven-3.3.9
ENV CLASSPATH=.:${JAVA_HOME}/lib:${JRE_HOME}/lib
ENV PATH=${JAVA_HOME}/bin:${M2_HOME}/bin:$PATH
RUN /bin/sh -c "cd /home/lzt && mvn clean && mvn compile && mvn package"
EXPOSE 7001
WORKDIR /home/lzt/target
CMD ["java","-jar","euroka-0.0.1-SNAPSHOT.jar"]
