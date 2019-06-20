# Pull base image
From tomcat:8-jre8

# Maintainer
MAINTAINER "Damien Metzler <dmetzler@gmail.com">

# Copy to images tomcat path
ADD target/hazelcast-web-status-*.war /usr/local/tomcat/webapps/status.war