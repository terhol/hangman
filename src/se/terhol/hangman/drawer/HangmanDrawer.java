package se.terhol.hangman.drawer;

/**
 * Draws a hangman picture depending on number of unsuccessful guesses.
 *
 * @author Tereza Holm
 */
public interface HangmanDrawer {
    /**
     * Checks if the picture is complete which marks that player is dead.
     *
     * @return TRUE if the player is dead, FALSE otherwise
     */
    boolean isDead();

    /**
     * Adds one level of the picture if possible. If the max level has been reached already, does nothing.
     */
    void addOneLevel();

    /**
     * Gets a current picture (progression level) of hangman.
     *
     * @return current picture (progression level) of hangman
     */
    String getPicture();
}
