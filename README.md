# Parallel-Assignment2
COP4520 Assignment 2 

Running:
Open terminal and navigate to the folder where MinotaurLabyrinth.java and MinotaurVase.java are saved.

To run MinotaurLabyrinth.java, Type in the terminal:
javac MinotaurLabyrinth.java
followed by
java MinotaurLabyrinth.java


To run MinotaurLabyrinth.java, Type in the terminal:
javac MinotaurVase.java
followed by
java MinotaurVase.java

Statements:
This program simulates the processes of knowing when all guests have visited the minotaur's labyrinth, and when all guests have viewed the minotaur's vase. 

For the labyrinth problem, the program assigns a guest to be the "leader". This guest is responsible for keeping count of the number of guests who have entered the labyrinth. My approach to the problem was that every guest can only eat the cupcake during their first visit to the labyrinth where it is present. The leader will keep count of each time the cupcake has been eaten. Once this count has reached the number of guests total, the leader may declare that all the guests have visited the labyrinth and the program ends. 

Efficiency:

Proof of correctness:
    Labyrinth:
        The approach to the labyrinth problem closely resembles the prisoner's lightbulb problem that we went over in class. The guest assigned to be the leader is to count each time the cupcake is no longer in the labyrinth and must be replaced. As each guest will eat the cupcake once and only once, the leader will know the decalre that all guests have viewed the labyrinth once their count reaches whatever number of guests there are. The program prints out when each guest eats their cupcake and the current count of cupcakes that have been eaten. As each guest eats a cupcake before the program is over and the final count is always equal to the number of guests, we can assume the program is correctly simulating the minotaur's labyrinth. 
        
    Vases:
        For the vase problem, I have selected strategy number 2 to simulate, which is as follows:
         
         "The Minotaur’s second strategy allowed the guests to place a sign on the door 
indicating when the showroom is available. The sign would read “AVAILABLE” or 
“BUSY.” Every guest is responsible to set the sign to “BUSY” when entering the 
showroom and back to “AVAILABLE” upon exit. That way guests would not bother trying 
to go to the showroom if it is not available. "

        I used this approach where each guest places a sign starting "BUSY" or "AVAILBLE" on the door as they enter or exit respectively. This strategy works well for this problem and is easy to simulate in code as each guest can be selected at random to enter the room. There is a boolean variable denoting whether the room is avaliable or not. If the room is avaliable the guests may enter the room, changing the variable from true to false. This is the equivalent to putting up a sign that says "BUSY". As the guest views the room, they are then marked as having viewed the room, and the total count of people who have viewed the room is incremented. Then, as they leave the room, the boolean variable changes from false back to true, signaling that the signed that says "AVAILABLE" has been put up and the next guest may enter the room. I believe this solution simulates the problem well and is very efficient as it can have 100 guests visit the room in 644 milliseconds. 
        

Experimental Evaluation: 
    the code currently has numGuests = 100, to test runtimes with other guests just change the numGuests variable to be equal to something else 
MinotaurLabyrinth.java Runtimes:
10 guests - 215 milliseconds
25 guests - 394 milliseconds
50 guests - 1127 milliseconds
75 guests - 3876 milliseconds
100 guests - 6798 milliseconds

MinotaurVase.java Runtimes:
10 guests - 202 milliseconds
25 guests - 267 milliseconds
50 guests - 332 milliseconds
75 guests - 482 milliseconds
100 guests - 644 milliseconds
