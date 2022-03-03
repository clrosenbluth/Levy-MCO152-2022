import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ScrabbleGame
{
    final List<String> playedWords = new ArrayList<>();
    final List<Character> tiles = new ArrayList<>();
    private final ScrabbleDictionary dictionary;
    private final LetterPool letterPool;

    private final static int numTiles = 7;

    public ScrabbleGame(
            ScrabbleDictionary dictionary,
            LetterPool letterPool
    )
    {
        this.dictionary = dictionary;
        this.letterPool = letterPool;
        addTiles();
    }

    /**
     * If the word exists in the ScrabbleDictionary and the letters exist in the tiles List,
     * remove the letters from the list, add new random letters, and add the word to playedWords List.
     */
    public boolean playWord(String word)
    {
        word = word.toUpperCase();
        if (isWord(word) && hasTiles(word))
        {
            removeTiles(word);
            addWord(word);
            addTiles();
            return true;
        }
        return false;
    }

    void addTiles()
    {
        while (tiles.size() < numTiles)
        {
            tiles.add(letterPool.getRandomLetter());
        }
    }

    boolean isWord(String word)
    {
        return dictionary.isWord(word);
    }

    boolean hasTiles(String word)
    {
        if (!hasEnoughTiles(word)) {
            return false;
        }
        char[] charsToCheck = word.toCharArray();
        List<Character> tempTiles = new ArrayList<>(tiles);
        for (Character letter : charsToCheck)
        {
            if (tempTiles.contains(letter))
            {
                tempTiles.remove(letter);
            }
            else
            {
                return false;
            }
        }
        return true;
    }

    boolean hasEnoughTiles(String word)
    {
        return word.length() <= tiles.size();
    }

    void removeTiles(String word)
    {
        char[] letters = word.toCharArray();
        for (Character letter : letters)
        {
            tiles.remove(letter);
        }
    }

    void addWord(String word)
    {
        playedWords.add(word);
    }
}
