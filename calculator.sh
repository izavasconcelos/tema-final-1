#!/bin/sh

echo "init shell calculator"
if [ $1 = "run-app" ]; then
  wget https://repo1.maven.org/maven2/org/eclipse/jetty/jetty-distribution/9.4.32.v20200930/jetty-distribution-9.4.32.v20200930.tar.gz
  tar -vzxf jetty-distribution-9.4.32.v20200930.tar.gz
  echo "install jetty OK"
  ./gradlew war
  cp ./build/libs/calculator.war ./jetty-distribution-9.4.32.v20200930/webapps
  echo "copy war"
  cd jetty-distribution-9.4.32.v20200930
  java -jar start.jar
  echo "jetty started"
fi