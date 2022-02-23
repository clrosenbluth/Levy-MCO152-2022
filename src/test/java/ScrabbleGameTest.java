import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScrabbleGameTest
{
    @Test
    public void playWord_good()
    {
        // given
        ScrabbleGame game = new ScrabbleGame();

        // when

        // then
        assertTrue(game.playWordTest("audio"));
    }

    @Test
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
    }

}