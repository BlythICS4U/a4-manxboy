# a4 Assignment 4

A separate NetBeans project has been provided for each assignment question. Before you start your work, ensure that you have cloned this repository and created a develop branch. When you have completed the assignment, commit to your develop branch and create a pull request.

### Problem 1

Write a Java/Swing program that performs Decimal to Binary and Binary to Decimal conversion. The top part of the frame allows the user to input a decimal number. When the "CONVERT" button is pressed, the binary equivalent is displayed. Likewise the lower part of the frame converts from Binary to Decimal. Your program needs to work on numbers in the 0 - 255 range, and provide appropriate feedback if a value outside of that range is entered. For the conversion, you need to write your own methods for the number/base conversions (i.e. DO NOT use the available built-in functions ... write them yourself). Your frame should look similar to the following:

<img src="https://github.com/BlythICS4U/a4/blob/master/ReadmeImages/Problem1.png" width="350" height="400"/>

### Problem 2

Create a java program that draws an 8X8 chess board, with the proper colors and title.

<img src="https://github.com/BlythICS4U/a4/blob/master/ReadmeImages/Problem2.png" width="400" height="400"/>


### Problem 3

Write a program that calculates the Binary Coefficient, C(n,r). This value is given by the expression:
```
   n!
--------
r!(n-r)!
```
Your program should contain to have a method for calculating the factorial.

<img src="https://github.com/BlythICS4U/a4/blob/master/ReadmeImages/Problem3.png" width="500" height="300"/>

### Problem 4

Write a program that has 10 simultaneous bouncing balls in a frame that is 800x800 pixels.

### Problem 5

Create the survey below.  Try to get the window to look as close as possible.
* For question 1, the options are: Shooters, Fighters, Platformers, Strategy, RPG, Puzzle, Arcade, Sports, Other
* For question 2, the options are: < 5 hours, < 10 hours, < 15 hours, 15+ hours
* For question 3, the user can write any text into the text field

For question 2, the question should read "How many hours per week do you spend gaming?" (the image below is incorrect).

<img src="https://github.com/BlythICS4U/a4/blob/master/ReadmeImages/Problem5.png" width="450" height="400"/>

When the **Submit** button is pressed, the contents of the survey are saved to a text file called "results.txt".  If the text file does not exist, the first submission will create the file.  All subsequent submissions will update the contents of the file.  For the first 2 questions, you should be keeping a running total of the options chosen.  For the final question, the text should be added to the end of the file.  You should also be keeping track of the number of surveys completed.  As an example, if the survey was submitted 5 times, the result contents should look something like this:

```
Number of surveys completed: 5

Question 1:
Shooters - 3
Fighters - 1
Platformers - 1
Strategy - 2
RPG - 1
Puzzle - 0
Arcade - 3
Sports - 2
Other - 4

Question 2:
< 5 hours - 1
< 10 hours - 3
< 15 hours - 1
15+ hours - 0

Question 3:
- Fortnite, Minecraft
- Breath of the Wild, Mario Kart 8, Fallen Order
- Pong, Pac-man, Donkey Kong
- Civilization 6
- Candy Crush, Merge Meadow
```
