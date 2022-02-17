import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScrabbleDictionaryTest
{
    @Test
    void isWord_True()
    {
        // given
        ScrabbleDictionary dictionary = new ScrabbleDictionary();

        // when

        // then
        assertTrue(dictionary.isWord("happy"));
    }

    @Test
    void isWord_False()
    {
        // given
        ScrabbleDictionary dictionary = new ScrabbleDictionary();

        // when

        // then
        assertFalse(dictionary.isWord("hapy"));
    }

    @Test
    void isWord_Fragment()
    {
        // given
        ScrabbleDictionary dictionary = new ScrabbleDictionary();

        // when

        // then
        assertFalse(dictionary.isWord("happ"));
    }

    @Test
    void isWord_NoDef()
    {
        // given
        ScrabbleDictionary dictionary = new ScrabbleDictionary();

        // when

        // then
        assertTrue(dictionary.isWord("ZOOGEOGRAPHICAL"));
    }

    @Test
    void getDef_HasDef()
    {
        // given
        ScrabbleDictionary dictionary = new ScrabbleDictionary();

        // when
        String definition = dictionary.getDefinition("AAH");

        // then
        assertEquals("to exclaim in amazement, joy, or surprise [v -ED, -ING, -S]", definition);
    }

    @Test
    void getDef_NoDef()
    {
        // given
        ScrabbleDictionary dictionary = new ScrabbleDictionary();

        // when
        String definition = dictionary.getDefinition("WRONGHEADEDNESS");

        // then
        assertEquals("", definition);
    }

    @Test
    void getDef_BadWord()
    {
        // given
        ScrabbleDictionary dictionary = new ScrabbleDictionary();

        // when
        String definition = dictionary.getDefinition("hapy");

        // then
        assertEquals(null, definition);
    }

    @Test
    void getDef_FragWord()
    {
        // given
        ScrabbleDictionary dictionary = new ScrabbleDictionary();

        // when
        String definition = dictionary.getDefinition("hapy");

        // then
        assertEquals(null, definition);
    }

}