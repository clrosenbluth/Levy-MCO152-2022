import java.util.ArrayList;
import java.util.List;

public class ScrabbleGame
{
    private final List<String> playedWords = new ArrayList<>();
    private final List<Character> tiles = new ArrayList<>();
    private final ScrabbleDictionary dictionary = new ScrabbleDictionary();

    public ScrabbleGame()
    {
        // give the player 7 random tiles.
        addTiles();
    }

    /**
     * If the word exists in the ScrabbleDictionary and the letters exist in the tiles List,
     * remove the letters from the list, add new random letters, and add the word to playedWords List.
     */
    public boolean playWord(String word)
    {
        if (isWord(word) && hasTiles(word))
        {
            removeTiles(word);
            addWord(word);
            addTiles();
            return true;
        }
        return false;
    }

    /**
     * A modified playWord method for testing. This ensures that known tiles are added.
     * @param word
     * @return
     */
    public boolean playWordTest(final String word)
    {
        String playWord = word.toLowerCase();
        makeTestTiles();
        if (isWord(playWord) && hasTiles(playWord))
        {
            removeTiles(playWord);
            addWord(playWord);
            makeTestTiles();
            return true;
        }
        return false;
    }

    private void makeTestTiles()
    {
        tiles.clear();
        tiles.add('a');
        tiles.add('u');
        tiles.add('d');
        tiles.add('i');
        tiles.add('o');
        tiles.add('g');
        tiles.add('r');
    }

    private void addTiles()
    {
        int ASCII_A = 65;
        int ASCII_Z = 90;
        while (tiles.size() < 7)
        {
            int tileAscii = (int) (Math.random() * (ASCII_Z - ASCII_A)) + ASCII_A;
            tiles.add((char) tileAscii);
        }
    }

    private boolean isWord(String word)
    {
        return dictionary.isWord(word);
    }

    private boolean hasTiles(String word)
    {
        boolean hasTiles = false;
        if (hasEnoughTiles(word))
        {
            char[] charsToCheck = word.toCharArray();
            List<Character> tempTiles = new ArrayList<>(tiles);
            hasTiles = true;
            for (Character letter : charsToCheck)
            {
                if (tempTiles.contains(letter))
                {
                    tempTiles.remove(letter);
                }
                else
                {
                    hasTiles = false;
                    break;
                }
            }
        }
        return hasTiles;
    }

    private boolean hasEnoughTiles(String word)
    {
        return word.length() <= tiles.size();
    }

    private void removeTiles(String word)
    {
        char[] letters = word.toCharArray();
        for (Character letter : letters)
        {
            tiles.remove(letter);
        }
    }

    private void addWord(String word)
    {
        playedWords.add(word);
    }
}
