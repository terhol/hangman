package se.terhol.hangman;

import se.terhol.hangman.engine.Engine;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Hangman application with command line user interface.
 *
 * @author Tereza Holm
 */
public class Hangman {
    private static final String REGEX_CORRECT_WORD = "^[a-zA-Z]+$";

    public static void main(String[] args) {
        Engine engine = new Engine();

        setWord(engine);

        while (engine.isPlaying()) {
            char letter = inputLetter();
            evaulateLetter(engine, letter);
            endTurn(engine);
        }

        endGame(engine);
    }

    private static char inputLetter() {
        Scanner scanner = new Scanner(System.in);
        char letter;

        do {
            System.out.println("---------------------------------------------------------");
            System.out.println();
            System.out.println("Guess a letter:");
            letter = Character.toLowerCase(scanner.next().charAt(0));
            System.out.println();
        }
        while (!Character.isAlphabetic(letter));

        return letter;
    }

    private static void evaulateLetter(Engine engine, char letter) {
        boolean isLetterCorrect = engine.guessLetter(letter);

        if (isLetterCorrect) {
            System.out.println(String.format(">>> CORRECT: %s", Hangman.getRandomText(getCorrectTextList())));
        } else {
            System.out.println(String.format("### WRONG: %s", Hangman.getRandomText(getWrongTextList())));
            System.out.println();
            System.out.println(engine.getPicture());
        }
    }

    private static void endTurn(Engine engine) {
        System.out.println();
        System.out.println("Letters you have already tried");
        System.out.println("-------");
        System.out.println(engine.getTriedLetters().toUpperCase());
        System.out.println();
        System.out.println(engine.getWord().toUpperCase());
        System.out.println();
    }

    private static void endGame(Engine engine) {
        System.out.println("=========================================================");
        System.out.println();

        if (engine.hasLost()) {
            System.out.println("OOPS! YOU HAVE LOST!");
            System.out.println();
            System.out.println(String.format("The correct answer was: %s", engine.getOriginalWord().toUpperCase()));
        } else if (engine.hasWon()) {
            System.out.println("CONGRATS! YOU HAVE WON!");
        }

        System.out.println();
        System.out.println("=========================================================");
    }

    private static void setWord(Engine engine) {
        String word;
        Console console = System.console();

        do {
            System.out.println("Type word to be guessed: no digits or spaces.");
            char[] secretWordArray = console.readPassword();
            word = new String(secretWordArray).toLowerCase();
        }
        while (!word.matches(REGEX_CORRECT_WORD));

        engine.setSecretWord(word);
    }

    private static String getRandomText(List<String> list) {
        int index = new Random().nextInt(list.size());

        return list.get(index);
    }

    private static List<String> getWrongTextList() {
        List<String> wrongTextList = new ArrayList<>();

        wrongTextList.add("E-e, this one not!");
        wrongTextList.add("One step closer to death!");
        wrongTextList.add("This will be fast!");
        wrongTextList.add("Oops, you are almost dead!");
        wrongTextList.add("You are not so smart, are you?");
        wrongTextList.add("What are you doing bro?");

        return wrongTextList;
    }

    private static List<String> getCorrectTextList() {
        List<String> correctTextList = new ArrayList<>();

        correctTextList.add("Yeah, correct!");
        correctTextList.add("Damn, you are good!");
        correctTextList.add("Wohooo, another one!");
        correctTextList.add("You have alived one more round!");
        correctTextList.add("That was easy, right?");
        correctTextList.add("Wow, how are you doing that?");

        return correctTextList;
    }
}
