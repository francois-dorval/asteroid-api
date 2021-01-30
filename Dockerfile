FROM tomcat:9.0
ARG warName
ENV WAR_NAME $warName

COPY $WAR_NAME /usr/local/tomcat/webapps/ 
EXPOSE 8080
