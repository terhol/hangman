package se.terhol.hangman.logger;

/**
 * Logger.
 *
 * @author Tereza Holm
 */
public interface Logger {
    /**
     * Logs an error.
     */
    void logError(String prefix, String message);
}
