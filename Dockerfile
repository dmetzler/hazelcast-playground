# Pull base image
From tomcat:8-jre8

# Maintainer
MAINTAINER "Damien Metzler <dmetzler@gmail.com">

# Copy to images tomcat path
RUN rm -rf /usr/local/tomcat/webapps/ROOT
ADD target/demo.war /usr/local/tomcat/webapps/ROOT.war