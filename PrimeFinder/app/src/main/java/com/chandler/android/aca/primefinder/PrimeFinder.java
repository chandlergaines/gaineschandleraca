package com.chandler.android.aca.primefinder;

public class PrimeFinder implements Runnable{
    //created a new class, initiated needed variables, step 1
    public long target;
    public long prime;
    public boolean finished = false;
    private Thread runner; //private because no other class needs to use this
    MainActivity numPrimes = this.numPrimes;


    //Need a constructor, use a long for argument, step 3
    PrimeFinder(long inTarget){
        target = inTarget;
        if (runner == null){
            runner = new Thread(this);
            runner.start(); //when we call runner.start, public run() gets called
        }
    }

    //this code was inserted by implementing interface Runnable, step 2
    @Override
    public void run() {
        long numPrimes = 0; //the number of primes is set to 0
        long candidate = 2; //the first candidate of prime is 2


        while(numPrimes < target){ //while number of primes run by program is less than the target number
            if (isPrime(candidate)){ //method isPrime, returns a boolean
                numPrimes++; //increment the number of primes
                prime = candidate; //set prime to the candidate being tested
                System.out.println("Prime Candidate: " + prime); //print that the candidate is prime
            }
            candidate++; //increment the candidate
        }
        System.out.println("Number of Primes: " + numPrimes); //print the number of primes
        finished = true; //stop the method when the loop is finished???
    }

    boolean isPrime(long checkNumber){ //check to see if a number is prime (true false)
        double root = Math.sqrt(checkNumber);
        //the double called root is assigned the value of the square root of the number we are checking
        for (int i = 2; i<= root; i++){ //beginning at 2, if i<= square root of number, increment 1
            if (checkNumber % i == 0){ //if the number we check returns a remainder of zero, it aint prime
                return false;
            }
        }
        return true;
    }
}
