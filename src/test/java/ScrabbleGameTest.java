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
        Mockito.doReturn(true)
                .when(dictionary)
                .isWord("HELLO");
        Mockito.doReturn('A', 'H', 'E', 'L', 'L', 'O')
                .when(letterPool)
                .getRandomLetter();
        ScrabbleGame game = new ScrabbleGame(dictionary, letterPool);

        // when

        // then.getRandomLetter()
        assertTrue(game.playWord("HELLO"));
        Mockito.verify(letterPool, Mockito.times(7+5)).
                getRandomLetter();
        assertTrue(game.playedWords.contains("HELLO"));
                    
    }

    @Test
    public void playWord_false()
    {
        // given
        Mockito.doReturn(true)
                .when(dictionary)
                .isWord("LOGO");
        Mockito.doReturn('A', 'H', 'E', 'L', 'L', 'O')
                .when(letterPool)
                .getRandomLetter();
        ScrabbleGame game = new ScrabbleGame(dictionary, letterPool);

        // when

        // then
        assertFalse(game.playWord("LOGO"));
        assertTrue(game.playedWords.isEmpty());
        Mockito.verify(letterPool, Mockito.times(7))
                .getRandomLetter();
        assertEquals(7, game.tiles.size());
    }

    @Test
    public void playWord_notInDictionary()
    {
        // given
        Mockito.doReturn('A', 'H', 'E', 'L', 'L', 'O')
                .when(letterPool)
                .getRandomLetter();
        ScrabbleGame game = new ScrabbleGame(dictionary, letterPool);

        // when
        boolean val = game.playWord("HEL");

        // then
        assertFalse(val);
        Mockito.verify(dictionary)
                .isWord("HEL");
        assertTrue(game.playedWords.isEmpty());
    }

    /*@Test
    public void playWord_wrongTiles()
    {
        // given
        ScrabbleGame game = new ScrabbleGame();

        // when

        // then
        assertFalse(game.playWordTest("word"));
    }

    @Test
    public void playWord_notWord()
    {
        // given
        ScrabbleGame game = new ScrabbleGame();

        // when

        // then
        assertFalse(game.playWordTest("udio"));
    }

    @Test
    public void playWord_tooLong()
    {
        // given
        ScrabbleGame game = new ScrabbleGame();

        // when

        // then
        assertFalse(game.playWordTest("audiograph"));
    }*/

}