# Parallel-Assignment2
COP4520 Assignment 2 

Running:
Open terminal and navigate to the folder where MinotaurLabyrinth.java and MinotaurVase.java are saved.

To run MinotaurLabyrinth.java, Type in the terminal:
javac MinotaurLabyrinth.java
java MinotaurLabyrinth.java


To run MinotaurLabyrinth.java, Type in the terminal:
javac MinotaurVase.java
java MinotaurVase.java

Statements:
This program simulates the processes of knowing when all guests have visited the minotaur's labyrinth, and when all guests have viewed the minotaur's vase. 

For the labyrinth problem, the program assigns a guest to be the "leader". This guest is responsible for keeping count of the number of guests who have entered the labyrinth. My approach to the problem was that every guest can only eat the cupcake during their first visit to the labyrinth where it is present. The leader will keep count of each time the cupcake has been eaten. Once this count has reached the number of guests total, the leader may declare that all the guests have visited the labyrinth and the program ends. 

Efficiency:

Proof of correctness:

Experimental Evaluation: 
