package se.terhol.hangman.drawer.ascii;

import java.io.InputStream;

/**
 * Levels connected with suitable picture.
 *
 * @author Tereza Holm
 */

public enum AsciiArtHangman {
    LEVEL_0(""),
    LEVEL_1("level_1.txt"),
    LEVEL_2("level_2.txt"),
    LEVEL_3("level_3.txt"),
    LEVEL_4("level_4.txt"),
    LEVEL_5("level_5.txt"),
    LEVEL_6("level_6.txt"),
    LEVEL_7("level_7.txt"),
    LEVEL_8("level_8.txt"),
    LEVEL_9("level_9.txt");

    private String fileName;

    AsciiArtHangman(String fileName) {
        this.fileName = fileName;
    }

    public InputStream getFileAsStream() {
        return getClass().getResourceAsStream(this.fileName);
    }
}
