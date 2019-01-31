package se.terhol.hangman.engine;

/**
 * Letter in a guessed word which can be hidden or revealed.
 *
 * @author Tereza Holm
 */
public class Letter {
    private char letter;
    private boolean isHidden = true;

    public Letter(char letter) {
        this.letter = letter;
    }

    public char getLetter() {
        return letter;
    }

    public boolean isHidden() {
        return isHidden;
    }

    /**
     * Set the latter as not hidden.
     */
    public void reveal() {
        this.isHidden = false;
    }
}
