# scala_assignment_sigmoid

# Q1. 
This code defines a Scala object Solution with two functions roundOff and convertToRange.
The roundOff function takes a double value as input and returns a string representing the rounded value. It works by first converting the double value to a string and then taking the left and right parts of the string separated by the decimal point. If the right part of the string is less than 4.9 times 10 to the power of (length of the right part minus 1), the function returns the left part of the string with "00" appended. Otherwise, it returns the left part of the string with "50" appended.

The convertToRange function takes an array of doubles as input and returns an array of tuples of two strings representing the lower and upper bounds of each range. It works by iterating over the input array, calling roundOff on each element to get the lower bound, and then computing the upper bound by adding 0.049 to the rounded value and converting the result back to a string. The lower and upper bounds are then appended to a mutable ArrayBuffer and finally converted to an immutable array using the toArray method.

The main function creates an array of doubles and calls convertToRange on it. The resulting array of tuples is then printed to the console.


#Q2.
This Scala code defines a case class Player with attributes representing information about a cricket player, including their year of performance, name, country, number of matches played, runs scored, and wickets taken. It also defines a class Solve with several methods to analyze this data.

The printPlayer method takes a Player object as input and prints their attributes.

The highestRuns method finds the player with the highest number of runs scored and prints their attributes using the printPlayer method.

The top5Runs method sorts the players by runs scored in descending order and prints the top 5 players using the printPlayer method.

The top5Wickets method sorts the players by wickets taken in descending order and prints the top 5 players using the printPlayer method.

The rankPlayers method ranks the players based on a weighted sum of their runs scored and wickets taken, and prints their attributes along with their rank using the printPlayer method.

The main method takes user input to select one of the methods to execute based on their choice.
