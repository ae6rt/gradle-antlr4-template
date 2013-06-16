A Gradle build template for ANTL4 projects.

Inspired by 

http://fenrock.wordpress.com/2012/05/17/gradle-and-antlr-3-x/

Remove the 

	apply from: file('gradle/idea.gradle')

if you are not using IntelliJ.  This is an IDE nice to have that
adds the generated sources to the IDE source roots.

The DOT.g4 grammar and t.dot sample input were taken from Terence
Parr's source code for the book The Definitive ANTLR4 Reference.

