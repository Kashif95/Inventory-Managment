SET here=%~dp0
echo %here%

REM Setting the environmental variable in batch file. These are used in pom.xml file
REM set CHECKSTYLE_CONFIGLOC=D:\SVN\Gutor\BST\checkstyle
set JBOSS_HOME=D:\jboss-5.0.1.GA

REM FOR /F "tokens=1,2* delims=," %%G IN ("%here%Input.txt") DO @echo %%G
REM FOR /F "tokens=1,2* delims=," %%G IN ("deposit,$4500,123.4,12-AUG-09") DO @echo Date paid %%G

REM runs the maven profile without generating checkstyle,findbug,corbetura report.
call mvn clean install -P local


REM change the directory to the corresponding path.
cd D:\jboss-5.0.1.GA\bin

pause
REM call run.bat of the Jboss server to start the server.
run.bat
