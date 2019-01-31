package se.terhol.hangman.engine;

import java.util.ArrayList;
import java.util.List;

/**
 * Word to guess. All logic is case insensitive.
 *
 * @author Tereza Holm
 */
public class Word {
    private static final String HIDDEN_LETTER = "_";

    private String originalWord;
    private List<Letter> word = new ArrayList<>();
    private boolean isCompletelyRevealed = false;

    public Word(String word) {
        this.originalWord = word.toLowerCase();

        for (int i = 0; i < this.originalWord.length(); i++) {
            this.word.add(new Letter(this.originalWord.charAt(i)));
        }
    }

    /**
     * Iterates the word with the given letter and reveals all letter occurrences.
     *
     * @param guessedLetter letter to guess
     *
     * @return TRUE if guessed word contains letter, FALSE otherwise
     */
    boolean guessLetter(char guessedLetter) {
        boolean containsLetter = false;
        boolean isSomeLetterStillHidden = false;

        for (Letter letter : word) {
            if (letter.getLetter() == Character.toLowerCase(guessedLetter)) {
                letter.reveal();
                containsLetter = true;
            }

            if (letter.isHidden()) {
                isSomeLetterStillHidden = true;
            }
        }

        if (!isSomeLetterStillHidden) {
            this.isCompletelyRevealed = true;
        }

        return containsLetter;
    }

    /**
     * Checks if the world is completely revealed.
     *
     * @return TRUE if revealed, FALSE otherwise
     */
    public boolean isCompletelyRevealed() {
        return this.isCompletelyRevealed;
    }

    /**
     * Gets the whole decrypted word.
     *
     * @return whole decrypted word
     */
    public String getOriginalWord() {
        return this.originalWord;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Letter letter : this.word) {
            if (sb.length() > 0) {
                sb.append(' ');
            }

            sb.append(letter.isHidden() ? HIDDEN_LETTER : letter.getLetter());
        }

        return sb.toString();
    }
}
