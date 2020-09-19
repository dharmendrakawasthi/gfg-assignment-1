# gfg-asignment-1

Q1. Create a spring boot app which interacts with any sql database (mysql/postgress/ oracle) and perform all the below mentioned tasks in it. 

Entity Name that should be used throughout the project : Book

Book.java
{
	long id,
	String name,
	String authorName
	int cost,
	Timestamp (data type you have find from the mapping of sql data types to java data       types)

}

Note : The marking will be task wise, the more tasks you do, the better you score

Task 1 : The app server should not be tomcat, it can be anything else (like jetty, undertow or any other server that can you find) but not tomcat (3 marks)

Task 2 : Run the server on some different port other than 8080 and create one Rest API which will return the port of the server. API endpoint can be anything but the method should be a GET one (5 marks)
Note : Don’t hardcode the port in the controller, read the port from the configuration file

Task 3 : Create GET and POST APIs for getting all the books in the database present and for inserting a book respectively. (Just like I did in the live lecture)
There is an additional thing you need to do in the POST API for inserting, you need to add the insertion timestamp which is basically the time at which the book got inserted in the table
 ( 6 marks [5 marks for POST API and 1 mark for GET API])

Task 4 : Create a PUT API, endpoint can be anything it’s up to you. The functionality should be : Update the name of the author as William for every book whose authorName has Will as the first word (7 marks)

Note : `Will` as the first word means that if authorName has name Will ___

Cases that you need to consider :

Will Martin - Valid case (Need to update)

WillMartin - Invalid case (Don’t update this since Will is not a proper word, it's just a substring in this case)

Will - Valid Case (Need to update this since will is a proper word)

Note : In all the valid cases the final authorName should be William and nothing else, no surname, no space etc.
Remember to only use JPQL in this part, no native query allowed

Task 5 : Create a DELETE API to delete all the books which have cost greater than 1000
Do this using native query part, no JPQL allowed in this function/API (4 marks)

In total you have to create 5 APIs for this project

Total marks for this question / project  = 25 marks

---------------------------------xxxxxxxxxxxxxxxxxxxx------------------------------------------------------
