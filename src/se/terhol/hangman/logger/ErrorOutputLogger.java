package se.terhol.hangman.logger;

/**
 * Standard output logger.
 *
 * @author Tereza Holm
 */
public class ErrorOutputLogger implements Logger {
    private String className;

    public ErrorOutputLogger(String className) {
        this.className = className;
    }

    @Override
    public void logError(String prefix, String message) {
        System.err.println(String.format("%s.%s - %s", this.className, prefix, message));
    }
}
