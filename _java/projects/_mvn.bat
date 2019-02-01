@echo off

set JAVA_HOME=%~dp0\..\opt\jdk-11.0.1

%~dp0\..\opt\apache-maven-3.5.4\bin\mvn --settings settings.xml %*