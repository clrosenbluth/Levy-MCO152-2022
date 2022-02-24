import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ScrabbleGameTest
{
    ScrabbleDictionary dictionary = Mockito.mock(ScrabbleDictionary.class);
    LetterPool letterPool = Mockito.mock(LetterPool.class);

    @Test
    public void playWord_true()
    {
        // given
        String word = "HELLO";
        Mockito.doReturn(true)
                .when(dictionary)
                .isWord(word);
        Mockito.doReturn('A', 'H', 'E', 'L', 'L', 'O')
                .when(letterPool)
                .getRandomLetter();
        ScrabbleGame game = new ScrabbleGame(dictionary, letterPool);

        // when
        boolean val = game.playWord(word);

        // then
        assertTrue(val);
        assertTrue(game.playedWords.contains(word));
        assertEquals(7, game.tiles.size());
        Mockito.verify(letterPool, Mockito.times(7+5)).
                getRandomLetter();
    }

    @Test
    public void playWord_false()
    {
        // given
        String word = "LOGO";
        Mockito.doReturn(true)
                .when(dictionary)
                .isWord(word);
        Mockito.doReturn('A', 'H', 'E', 'L', 'L', 'O')
                .when(letterPool)
                .getRandomLetter();
        ScrabbleGame game = new ScrabbleGame(dictionary, letterPool);

        // when
        boolean val = game.playWord(word);

        // then
        assertFalse(val);
        assertTrue(game.playedWords.isEmpty());
        Mockito.verify(letterPool, Mockito.times(7))
                .getRandomLetter();
        assertEquals(7, game.tiles.size());
    }

    @Test
    public void playWord_notInDictionary()
    {
        // given
        String word = "HEL";
        Mockito.doReturn('A', 'H', 'E', 'L', 'L', 'O')
                .when(letterPool)
                .getRandomLetter();
        ScrabbleGame game = new ScrabbleGame(dictionary, letterPool);

        // when
        boolean val = game.playWord(word);

        // then
        assertFalse(val);
        Mockito.verify(dictionary)
                .isWord(word);
        assertTrue(game.playedWords.isEmpty());
        Mockito.verify(letterPool, Mockito.times(7))
                .getRandomLetter();
        assertEquals(7, game.tiles.size());
    }

}