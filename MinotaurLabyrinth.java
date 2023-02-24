import java.util.*;
import java.util.concurrent.Semaphore;

public class MinotaurLabyrinth {
    static int counter = 0;
    static boolean[] hasVisited = new boolean[100];
    static boolean isCupcakeThere = true;
    static int currentThread = 0;
    static int numGuests = 100;
    static Semaphore mutex = new Semaphore(1);

    // thread representing a guest that enters the labyrinth
    static class GuestThread implements Runnable {
        public int id;

        public GuestThread(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            try {
                if (id == 0) {
                    leaderCheck();
                } else {
                    GuestCheck(id);
                }

            } catch (Exception e) {
                System.out.println("excetion caught");
            }
        }

        // the leader goes into the labyrinth and updates count if the cupcake has been
        // eaten, then replaces cupcake
        void leaderCheck() {
            while (counter < numGuests) {
                try {
                    mutex.acquire();
                } catch (Exception e) {
                    System.out.println("Exception caught!");
                }
                if (isCupcakeThere && !hasVisited[0]) {
                    System.out.println("Guest " + id + " ate the cupcake");
                    isCupcakeThere = false;
                    counter = counter + 1;
                    System.out.println("Replace Cupcake! Count is: " + counter);
                    isCupcakeThere = true;
                    hasVisited[0] = true;
                }
                if (currentThread == 0 && !isCupcakeThere) {
                    counter = counter + 1;
                    System.out.println("Replace Cupcake! Count is: " + counter);
                    isCupcakeThere = true;
                }
                mutex.release();
            }
        }
        // a guest who is not the leader enters the labyrinth, if the cupcake is there and they have not previously eaten a cupcake 
        // before they eat the cupcake. this guest is marked as having eaten a cupcake 
        void GuestCheck(int threadNum) {
            while (counter < numGuests) {
                try {
                    mutex.acquire();
                } catch (Exception e) {
                    System.out.println("Exception found");

                }
                if (currentThread == threadNum && isCupcakeThere && !hasVisited[threadNum]) {
                    System.out.println("Guest " + id + " ate the cupcake");
                    isCupcakeThere = false;
                    hasVisited[threadNum] = true;
                }
                mutex.release();
            }
        }
    }

    public static void main(String args[]) {
        // start timer
        long startTime = System.nanoTime();
        // create the threads representing the guests
        ArrayList<Thread> threads = new ArrayList<Thread>();
        for (int i = 0; i < numGuests; i++) {
            threads.add(new Thread(new GuestThread(i)));
        }

        for (Thread s : threads) {
            s.start();
        }

        // simulate picking guests at random
        while (counter < numGuests) {
            int max = numGuests;
            int min = 0;
            currentThread = (int) ((Math.random() * (max - min)) + min);
        }

        for (Thread s : threads) {
            try {
                s.join();

            } catch (Exception e) {
                System.out.println("exception caught");

            }
        }
        long endTime = System.nanoTime();
        System.out.println("Time taken : " + (endTime - startTime) / 100000 + " milliseconds");
    }
}
