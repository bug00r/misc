@echo off

set argC=0
for %%x in (%*) do Set /A argC+=1

if %argC%==1 (
	SET groupid="de.bug0r"
	SET artifactid=%1
)

if %argC%==2 (
	SET groupid=%1
	SET artifactid=%2
)

if %argC%==0 (
	SET groupid="de.bug0r"
	SET artifactid="my-app"
)

_mvn -B archetype:generate -DgroupId="%groupid%" -DartifactId="%artifactid%" -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false