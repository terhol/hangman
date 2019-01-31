package se.terhol.hangman.drawer;

import se.terhol.hangman.drawer.ascii.AsciiArtHangman;
import se.terhol.hangman.logger.ErrorOutputLogger;
import se.terhol.hangman.logger.Logger;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Draws an ASCII hangman picture depending on number of unsuccessful guesses.
 *
 * @author Tereza Holm
 */
public class AsciiHangmanDrawer implements HangmanDrawer {
    private static final int MAX_LEVEL = 9;
    private static final Logger LOGGER = new ErrorOutputLogger("AsciiHangmanDrawer");

    private int currentLevel = 0;
    private boolean isDead = false;

    private AsciiArtHangman getLevelByNumber(int level) {
        switch(level) {
            case 1: return AsciiArtHangman.LEVEL_1;
            case 2: return AsciiArtHangman.LEVEL_2;
            case 3: return AsciiArtHangman.LEVEL_3;
            case 4: return AsciiArtHangman.LEVEL_4;
            case 5: return AsciiArtHangman.LEVEL_5;
            case 6: return AsciiArtHangman.LEVEL_6;
            case 7: return AsciiArtHangman.LEVEL_7;
            case 8: return AsciiArtHangman.LEVEL_8;
            case 9: return AsciiArtHangman.LEVEL_9;
            default: return AsciiArtHangman.LEVEL_0;
        }
    }

    private String loadLevel(AsciiArtHangman level) {
        try {
            BufferedInputStream bis = new BufferedInputStream(level.getFileAsStream());
            ByteArrayOutputStream buf = new ByteArrayOutputStream();

            int result = bis.read();

            while(result != -1) {
                buf.write((byte) result);
                result = bis.read();
            }

            return buf.toString(StandardCharsets.UTF_8.name());
        } catch (IOException e) {
            String prefix = String.format("loadLevel(%s)", level.getFileAsStream());
            String message = String.format("Error when trying to load a level file: %s", e);

            LOGGER.logError(prefix, message);

            return "";
        }
    }

    @Override
    public boolean isDead() {
        return this.isDead;
    }

    @Override
    public void addOneLevel() {
        if (!isDead()) {
            this.currentLevel++;

            if (this.currentLevel == MAX_LEVEL) {
                this.isDead = true;
            }
        }
    }

    @Override
    public String getPicture() {
        AsciiArtHangman level = getLevelByNumber(this.currentLevel);
        return loadLevel(level);
    }
}
