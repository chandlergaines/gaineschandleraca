package com.chandler.android.aca.magic8ball;

import java.util.Random;

// Class to hold all the magic
public class MagicBook {
    // Magic array of magic strings
    private String[] mMagic = {
        // 10 positive
        "Obviously",
        "Fuck yeah",
        "Oh hell yes!",
        "Abso-fucking-lutely",
        "Duh.",
        "Yaaaaaassss",
        "YOU DON'T EVEN KNOW, MAN",
        "I guess, yeah..",
        "Uhh, fuck, I think so?",
        "I mean, maybe..",
        // 5 neutral
        "How the hell would I know?",
        "Ask literally anyone else",
        "You really don't want to know",
        "No idea.",
        "Who cares?",
        // 5 negative
        "Hell no",
        "No, are you fucking kidding?",
        "Not a chance",
        "No way in hell",
        "Fuck that"
    };

    // String object to hold the selected magic
    public String getMagic(){
        String magic;
        // Random number generator
        Random randomGenerator = new Random();
        // Set the random number generator to the length of the array
        int randomNumber = randomGenerator.nextInt(mMagic.length);
        magic = mMagic[randomNumber];

        return magic;
    }
}
