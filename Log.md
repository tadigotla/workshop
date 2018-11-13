### Day1: Introduction to Cloud IDE
> Team was introduced to Cloud IDE and its usage. Cloud workspaces were created for the entire team.
### Day2: Building and executing few Java Samples
> The team was asked to write small programs on the IDE some of which are:
1. Write a program to check if a given number is Prime
1. Write a program to calculate the average of numbers. Read the numbers (and the expected number of inputs) from Standard Input
1. Program to reverse every word in a String. Remember that input should comprise of a String with multiple words which need to be reversed. And you need not reverse the alphabets within a single word.
### Day 3: Maven Project
1. Introduction to Maven and installing maven in the workspace using sdkman
1. A sample maven project and its folder structure
1. Adding project dependencies to a maven project
1. Executing a Java program using maven
1. Role of OS in executing a program. A look into processes and how they run with the help of OS
### Day 4: 
1. What is going on here --> `javac MyProgram.java`, `mvn package` or `java MyProgram`. How a command is propogated to the right program by the OS
1. The role of Environment Variables like `PATH`, `JAVA_HOME` & `CLASSPATH`
1. First look at a Unit Test Case using JUnit
### Day 5:
1. Assignment on building a program to write content to an Excel File using Apache POI api
### Day 6:
1. JDBC Api Sample using in-memory H2 database. 
1. Test case for validating the ExcelReader program.
### Day 7:
1. HTTP Primer, sample program that makes a `GET` request to a web service.
1. Test case development for the WebClient functionality.
1. Groovy Introduction
### Day 8:
1. Continuation of Intro to Groovy. Rewriting few Java samples to groovy. 
1. A look at gradle build file
1. A look at test cases using Spock
### Day 9:
1. The need for Web Application
1. Running serverside code on the Java Platform. Java `Servlet`
1. Creating a Web Application using maven archetypes.
### Day 10:
1. Modifying the HelloWorld servlet to read and return data from Excel as JSON
1. Recap
1. Introducing QueryString and reading input with Request Parameters
1. Can the servlet be tested?
### List of Commands executed so far:
1. `javac MyProgram.java`
2. `java MyProgram`
3. `sdk install maven`
4. `mvn --version`
5. `mvn package`
6. `mvn exec:java -Dexec.mainClass="com.sample.App"`
7. `mvn test`
8. Create web application using maven archetypes
```
mvn archetype:generate -DgroupId=com.sample \
                   -DartifactId=sample-webapp \
                   -Dversion=1.0-SNAPSHOT \
                   -DarchetypeArtifactId=maven-archetype-webapp \
                   -DinteractiveMode=false 
```
9. mvn jetty:run

### References:
1. [Process vs Thread](https://neharustagiblog.wordpress.com/2014/09/26/program-vs-process-vs-thread-vs-task/)
1. [Process vs Thread](https://www.thecrazyprogrammer.com/2018/01/difference-process-thread.html)
1. [Linux for Beginners](https://www.linux.com/learn/complete-beginners-guide-LInux%20)
1. [A Commandline Primer](https://lifehacker.com/5633909/who-needs-a-mouse-learn-to-use-the-command-line-for-almost-anything)
1. [Linux Boot Process](https://opensource.com/article/17/2/linux-boot-and-startup)
1. [Environment Variables](https://www.guru99.com/linux-environment-variables.html)
    1. [JAVA CLASSPATH](http://kevinboone.net/classpath.html)
    1. [PATH vs CLASSPATH](http://www.java67.com/2012/08/what-is-path-and-classpath-in-java-difference.html)
1. [Apache POI API(Java Docs)](https://poi.apache.org/apidocs/org/apache/poi/xssf/usermodel/XSSFWorkbook.html)
1. [A HTTP Programming Primer](http://hc.apache.org/httpcomponents-client-4.5.x/primer.html)
1. [Servlets Intro](https://beginnersbook.com/2013/05/servlet-tutorial/)
