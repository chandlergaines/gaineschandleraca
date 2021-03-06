package com.chandler.android.aca.hangman;

public class Game {
public String mAnswer;
public String mHits;
public String mMisses;

    public static final int MAX_MISSES = 7;

    public Game (String answer) {
        mAnswer = answer;
        mHits = "";
        mMisses = "";
    }

    public boolean applyGuess(char letter){
        boolean isHit = mAnswer.indexOf(letter) >= 0;
        if (isHit){
            mHits += letter;
        } else {
            mMisses += letter;
        }
        return isHit;
    }

    public String getCurrentProgress(){
        String progress = "";
        for(char letter: mAnswer.toCharArray()){
            char display = '_';
            if(mHits.indexOf(letter)>=0){
                display = letter;
            }
            progress += display;
        }
        return progress;
    }

    public int getRemainingTries(){
        return MAX_MISSES - mMisses.length();
    }
}
