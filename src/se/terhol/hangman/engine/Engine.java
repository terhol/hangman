package se.terhol.hangman.engine;

import se.terhol.hangman.drawer.AsciiHangmanDrawer;
import se.terhol.hangman.drawer.HangmanDrawer;

import java.util.ArrayList;
import java.util.List;

/**
 * Application engine, combines all logic together.
 *
 * @author Tereza Holm
 */
public class Engine {
    private Word word;
    private HangmanDrawer hangmanDrawer = new AsciiHangmanDrawer();
    private List<Character> triedLetters = new ArrayList<>();

    /**
     * Sets a word which should user guess.
     *
     * @param word word to guess
     */
    public void setSecretWord(String word) {
        this.word = new Word(word);
    }

    /**
     * Decides if the word which is being guessed contains given letter. If not, adds letter to list of guessed letters.
     *
     * @param letter letter which user tries to guess
     *
     * @return TRUE if guessed word contains letter, FALSE otherwise
     */
    public boolean guessLetter(char letter) {
        boolean isLetterCorrect = word.guessLetter(letter);

        if (!isLetterCorrect && !triedLetters.contains(letter)) {
            triedLetters.add(letter);
            hangmanDrawer.addOneLevel();
        }

        return isLetterCorrect;
    }

    /**
     * Gets a current picture of a hangman.
     *
     * @return current picture of a hangman
     */
    public String getPicture() {
        return hangmanDrawer.getPicture();
    }

    /**
     * Marks if the game has finished or not.
     *
     * @return TRUE if the game continues, FALSE otherwise
     */
    public boolean isPlaying() {
        return !hasWon() && !hasLost();
    }

    /**
     * Marks if word is completely revealed and if player has won the game.
     *
     * @return TRUE if player has won, FALSE otherwise
     */
    public boolean hasWon() {
        return this.word.isCompletelyRevealed();
    }
    /**
     * Marks if player has lost the game.
     *
     * @return TRUE if player has lost, FALSE otherwise
     */
    public boolean hasLost() {
        return this.hangmanDrawer.isDead();
    }

    /**
     * Gets the guessed word with missing letters replaced by underscores.
     *
     * @return the guessed word with missing letters replaced by underscores
     */
    public String getWord() {
        return this.word.toString();
    }

    /**
     * Gets incorrect letters which have been tried already.
     *
     * @return gets incorrect letters which have been tried already
     */
    public String getTriedLetters() {
        StringBuilder sb = new StringBuilder();

        for (char letter : this.triedLetters) {
            if (sb.length() > 0) {
                sb.append(',').append(' ');
            }

            sb.append(letter);
        }

        return sb.toString();
    }

    /**
     * Gets the original (decrypted) word.
     *
     * @return original (decrypted) word
     */
    public String getOriginalWord() {
        return this.word.getOriginalWord();
    }
}
