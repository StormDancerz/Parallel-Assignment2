import java.util.*;
import java.util.concurrent.Semaphore;

public class MinotaurVase {
    static int numGuests = 100;
    static int haveViewedVase = 0;
    static boolean[] hasVisitedVase = new boolean[100];
    static boolean roomAvailability = true;
    static int currentThread = 0;
    static Semaphore mutex = new Semaphore(1);

    // thread representing a guest that wants to view the minotaur's vase
    static class GuestThread implements Runnable {
        public int id;

        public GuestThread(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            try {
                viewVase(id);
            } catch (Exception e) {
                System.out.println("exception caught");
            }
        }

        // guests enter the room if the room is available
        void viewVase(int threadNum) {
            while (haveViewedVase < numGuests) {
                try {
                    mutex.acquire();
                } catch (Exception e) {
                    System.out.println("Exception caught!");
                }
                if (currentThread == threadNum && roomAvailability) {
                    // guest enters room, places sign on door stating "BUSY" upon entering
                    roomAvailability = false;
                    try {
                        // Thread.sleep(100);
                    } catch (Exception e) {
                        System.out.println("Exception caught");
                    }

                    if (!hasVisitedVase[threadNum]) {
                        haveViewedVase += 1;
                        System.out.println("Guest # " + id + " has viewed the vase Counter is " + haveViewedVase);
                        hasVisitedVase[threadNum] = true;
                    }
                    // guest exits room, places sign on door stating "AVAILABLE" upon exiting
                    roomAvailability = true;
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
        while (haveViewedVase < numGuests) {
            int max = numGuests;
            int min = 0;
            currentThread = (int) ((Math.random() * (max - min)) + min);
        }

        for (Thread s : threads) {
            try {
                s.join();
            } catch (Exception e) {
                System.out.println("Exception caught");
            }
        }
        long endTime = System.nanoTime();
        System.out.println("Time taken : " + (endTime - startTime) / 100000 + " milliseconds");
    }
}
