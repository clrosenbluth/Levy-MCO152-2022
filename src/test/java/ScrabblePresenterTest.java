import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class ScrabblePresenterTest
{
    private ScrabbleFrame view = Mockito.mock(ScrabbleFrame.class);
    private ScrabbleGame model = Mockito.mock(ScrabbleGame.class);
    private ScrabblePresenter presenter = new ScrabblePresenter(view, model);
    private List<Character> tiles = new ArrayList<>();
    private String message;

    @Test
    public void fillTiles()
    {
        // given
        doReturn(tiles).when(model).getTiles();

        // when
        presenter.fillTiles();

        // then
        verify(model).getTiles();
        verify(view).setTiles(tiles);
    }

    @Test
    public void setOutput()
    {
        // given
        doReturn(message).when(model).getMessageString();

        // when
        presenter.setOutput();

        // then
        verify(model).getMessageString();
        verify(view).setOutput(message);
    }

    @Test
    public void playWord_true()
    {
        // given
        doReturn(tiles).when(model).getTiles();
        doReturn(Messages.IS_A_WORD.toString()).when(model).getMessageString();
        doReturn(true).when(model).playWord("HELLO");

        // when
        presenter.playWord("HELLO");

        // then
        verify(model).playWord("HELLO");
        verify(view).setScore("1");
        verify(view).setTiles(tiles);
        verify(model).getTiles();
        verify(model).getMessageString();
        verify(view).setOutput(Messages.IS_A_WORD.toString());
    }

    @Test
    public void playWord_false_notWord()
    {
        // given
        doReturn(tiles).when(model).getTiles();
        doReturn(Messages.NOT_A_WORD.toString()).when(model).getMessageString();
        doReturn(false).when(model).playWord("HEL");

        // when
        presenter.playWord("HEL");

        // then
        verify(model).playWord("HEL");
        verify(model).getMessageString();
        verify(view).setOutput(Messages.NOT_A_WORD.toString());
    }

    @Test
    public void playWord_false_badTiles()
    {
        // given
        doReturn(tiles).when(model).getTiles();
        doReturn(Messages.INSUFFICIENT_TILES.toString()).when(model).getMessageString();
        doReturn(false).when(model).playWord("HELLO");

        // when
        presenter.playWord("HELLO");

        // then
        verify(model).playWord("HELLO");
        verify(model).getMessageString();
        verify(view).setOutput(Messages.INSUFFICIENT_TILES.toString());
    }

}