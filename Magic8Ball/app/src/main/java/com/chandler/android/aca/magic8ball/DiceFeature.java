package com.chandler.android.aca.magic8ball;

import java.util.Random;

public class DiceFeature {

    public String getDice() {

        String diceText; // Cast int dice into this string to print
        int dice;

        // Create two random generators, used .nextInt(7) because (6) would only print values up to 10
        // Using 7 seems to have solved the issue and max output so far has been 12
        Random randomGenerator = new Random();
        int ourRandomNumber = randomGenerator.nextInt(7);

        Random randomGenerator2 = new Random();
        int ourRandomNumber2 = randomGenerator2.nextInt(7);

        // Concatenate random numbers and cast to string to print
        dice = ourRandomNumber + ourRandomNumber2;
        diceText = Integer.toString(dice);

        return diceText;
    }


}
