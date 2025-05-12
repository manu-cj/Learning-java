# Hello data types pt2 

- Repository: `java_week_1`

- Type of Challenge: `Learning`

- Team challenge : `solo`

  

## The Mission

Create the same application but now with the object version of these data types. What is the difference?

- These are objects. Primitive data types are raw values, but objects are not. Objects are actually pointers,
  they point to memory in the jvm. So a variable of type Integer can also NOT have a pointer, which makes it 'null'.
- Very extra: Is there a way to loop over all of the variables automatically and only have 1 print statement? If so, 
  why was this not possible the primitive datatypes?


  # Challenge 3: Hello arrays

- Repository: `java_week_1`

- Type of Challenge: `Learning`

- Team challenge : `solo`

  

## The Mission

Create a small application that will assign and print out an example of all the primitive data types in Java.
hint: None of these datatypes have a capital letter. 

### Extra

- How come you can just print all of these datatypes? 
- Why are those called primitive data types?
- Why can't you assign a double to an integer?
- But why can you assign an integer to a char?
- Why can't you assign a long to a int?


# Challenge 4: hello exceptions

- Repository: `java_week_1`

- Type of Challenge: `Learning`

- Team challenge : `solo`

  

## The Mission

Write a small program that will build up a random array of non-primitive integers, and 0 is a valid 
entry. Now loop over the array and divide each integer with the previous integer. The first integer can
be divided by itself. How will you make sure that the program doesn't crash when dividing by zero?

This challenge can be a way to introduce exceptions, try catch blocks, etc. Extra


# Challenge 5: Counting words

- Repository: `java_week_1`

- Type of Challenge: `Learning`

- Team challenge : `solo`

  

## The Mission

Write a program that reads in a text file and then counts the appearance of words line by line. The result should 
be an overview of how many times each word was in the text. 

## Challenge 5 bis: Most frequently used word

The same as challenge 5, but now we also want to know which word was used the most. 



## Challenge 6: Counting letters
Repository: java_week_1

Type of Challenge: Learning

Team challenge : solo

The Mission
Write a program that reads in a text file and then counts the appearance of letters line by line. The result should be an overview of how many times each letter (or should we go for character?) appeared.

Challenge 6 bis: most frequent letter
The same as challenge 6, but also report which is the most commonly used letter.


## Challenge 7: hello classes
Repository: java_week_1

Type of Challenge: Learning

Team challenge : solo

The Mission
Write a program that can read in a comma separated value file (a csv file). Make a data model (a class) to hold the lines and print out only one particular piece of information. So we are expecting getter and setter methods. Students should also be able to explain what a method signature is. Ideally, the solution for this challenge also consists out of multiple classes.


## Challenge 8: Hello classes part 2
Repository: java_week_1

Type of Challenge: Learning

Team challenge : solo

The Mission
Again write a program that can read a comma separated value file. Each row of this file contains some information that has its own meaning and value separate, but it can also have value when combined with other fields. For example each row of a cvs file can represent a day and count of visitors/patients per department in a hospital. For example on 27-07-2021, there are 40 visitor for cardiology, 98 for radiology, 1120 people just visiting somebody in the hospital, etc etc. The students need to make classes that model the file, but they also add behaviour to that class that operates on the data that it contains. In other words, we are setting the first encapsulation steps. ---- > maybe a bit too early to call it out already.

we want to be able to 'report' per day and per month, these reports are written in files. So we will be needing multiple classes to do this, also making them write to files.


# Challenge 9: The CSV factory (big challenge)

- Repository: `java_week_1`

- Type of Challenge: `Learning`

- Team challenge : `solo`

  

## The Mission

Write a program that will create csv files. The csv files will contain the following fields: 

- firstname: The firstname is a name which will be chosen randomly from a set of 30 firstnames. 
- Lastname: The lastname is a name which will be chosen randomly from a set of 40 lastnames.
- Reason: This value is to be chosen randomly from 2 values: Appointment or visit
- Department: This value is a value chosen from 5 values: Cardiology, Radiology, Pediatrics, Geriatrics, Pulmonology. This is only to be
  filled in if the reason of the visit is 'Appointment'
- Date of the visit. The date can be something random, but let's keep it in a certain month in the current year. 

You can decide how long this file is, don't make it too long though. Ideally, this challenge also consists out of multiple classes

**Note:** This challenge plays with the idea of code reuse. OO is not about code reuse, however, randomly picking a value
from a fixed set of values is something that can be abstracted out. The coach should pay attention to this. 

**A small word on code reuse:** Code reuse is only viable when change is out of the equation. In 80% of the cases, 
change originates from stakeholders (users, customers, managers, financiers, etc) and they mostly want feature 
changes. If this 'random' csv factory was to be a real life feature, it is very unlikely that one of the stakeholders
is interested in how these values were randomly picked. Nobody cares how these values are randomly pickd. That means that
the chances that it will need to change are very limited. And this makes it a perfect candidate for an abstraction/code reuse.  

# Challenge 10: Hello generics

- Repository: `java_week_1`

- Type of Challenge: `Learning`

- Team challenge : `solo & team of 2`

  

## The Mission

Create a program that has 2 classes: Car and Truck. Give them both a field `int numberOfWheels` and write a 
getter method for that. Now in your program, try to create a collection (can be List, a Set, anything) that holds
an object of both classes. How would you do that? 

## Bonus

### Teamwork: Counting appearance of words in a folder filled with text files

Pair up. The goal is to create a report of the amount of times certain words (sequences of characters) appear
in all the different files. How are you going to divide the work? 

# Learning-java
