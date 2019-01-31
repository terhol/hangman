# The Hangman Game

## Overview
This is a hangman game for __two players__. It enables one player to type down a word and second player to guess the word by guessing letters of the word. There is a limited number of guesses before game is lost. If player manages to guess the word before the limit of guesses is up, they win.

## How To Play
- The game prompts the __first player__ to type down the word. This word can contain only letters, no numbers or special characters are allowed. The word is typed in a secret mode.
- The __second player__ can now start guessing letters (it is not important if player types letter in uppercase or lowercase). There are now two possibilities:
    - The word which is being guessed __contains__ this letter: player is told that their guess was correct and can see the word with all letters which they guessed correctly uncovered (e.g. c _ t).
    - The word which is being guessed does __not contain__ this letter: player is told that their guess was not correct and sees picture of a hangman - the more wrong guesses have been made so far, the more complete the picture is. Player also sees all unsuccessful letters which have been tried and also the word with all letters which they guessed correctly uncovered. If player tries to guess the same wrong letter twice, it counts only as one unsuccessful try.
- Player has only 8 unsuccessful guesses before they lost the game.
- If player manages to guess all correct letters in the world before they run out of guesses, they have won the game.

## Download
Visit [Releases](https://github.com/terhol/hangman/releases) section and download the last version.

## How To Run The Game
Download the game and run it from terminal by the command below. JRE is required to be installed on your device.

```bash
java -jar hangman.jar
```

## License
MIT
