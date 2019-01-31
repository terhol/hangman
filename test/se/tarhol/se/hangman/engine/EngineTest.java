package se.tarhol.se.hangman.engine;

import org.junit.jupiter.api.Test;
import se.terhol.hangman.engine.Engine;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Tereza Holm
 */
class EngineTest {
    @Test
    void guessLetter() {
        Engine engine = new Engine();

        engine.setSecretWord("elephant");

        assertTrue(engine.guessLetter('e'));
        assertTrue(engine.guessLetter('P'));
        assertFalse(engine.guessLetter('F'));
        assertFalse(engine.guessLetter('9'));
        assertFalse(engine.guessLetter(' '));
        assertFalse(engine.guessLetter('!'));
    }

    @Test
    void isPlaying() {
        Engine engine = new Engine();
        engine.setSecretWord("cat");

        assertTrue(engine.isPlaying());

        engine.guessLetter('c');
        engine.guessLetter('a');
        engine.guessLetter('q');

        assertTrue(engine.isPlaying());

        engine.guessLetter('t');

        assertFalse(engine.isPlaying());
    }

    @Test
    void hasWon() {
        Engine engine = new Engine();

        engine.setSecretWord("cat");

        assertFalse(engine.hasWon());

        engine.guessLetter('c');
        engine.guessLetter('a');
        engine.guessLetter('t');

        assertTrue(engine.hasWon());
    }

    @Test
    void hasLost() {
        Engine engine = new Engine();

        engine.setSecretWord("x");

        assertFalse(engine.hasLost());

        engine.guessLetter('a');
        assertFalse(engine.hasLost());

        engine.guessLetter('b');
        assertFalse(engine.hasLost());

        engine.guessLetter('d');
        assertFalse(engine.hasLost());

        engine.guessLetter('e');
        assertFalse(engine.hasLost());

        engine.guessLetter('f');
        assertFalse(engine.hasLost());

        engine.guessLetter('g');
        assertFalse(engine.hasLost());

        engine.guessLetter('h');
        assertFalse(engine.hasLost());

        engine.guessLetter('i');
        assertFalse(engine.hasLost());

        engine.guessLetter('j');

        assertTrue(engine.hasLost());
    }

    @Test
    void getWord() {
        Engine engine = new Engine();

        engine.setSecretWord("cat");

        assertEquals("_ _ _", engine.getWord());

        engine.guessLetter('c');
        engine.guessLetter('t');

        assertEquals("c _ t", engine.getWord());

        engine.guessLetter('a');

        assertEquals("c a t", engine.getWord());
    }

    @Test
    void getTriedLetters() {
        Engine engine = new Engine();

        engine.setSecretWord("x");
        assertEquals("", engine.getTriedLetters());

        engine.guessLetter('a');
        assertEquals("a", engine.getTriedLetters());

        engine.guessLetter('b');
        assertEquals("a, b", engine.getTriedLetters());
    }


}