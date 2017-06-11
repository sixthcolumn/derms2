#!/bin/ksh


sudo /usr/local/tomcat7/bin/shutdown.sh
sudo rm -rf /usr/local/tomcat7/logs/* /usr/local/tomcat7/webapps/*
mvn package
sudo cp target/epri-61968-6.war /usr/local/tomcat7/webapps
sudo /usr/local/tomcat7/bin/startup.sh
sleep 3
tail -f /usr/local/tomcat7/logs/catalina.out
