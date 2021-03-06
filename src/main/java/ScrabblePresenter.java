/*
 * Presenter: acts on model and view. Takes data from model and formats it for display in view
 */

public class ScrabblePresenter
{
    private final ScrabbleFrame view;
    private final ScrabbleGame model;
    private int score;

    public ScrabblePresenter(ScrabbleFrame view, ScrabbleGame model)
    {
        this.view = view;
        this.model = model;
    }

    public void playWord(String word)
    {
        if (model.playWord(word))
        {
            score++;
            view.setScore(String.valueOf(score));
            view.setTiles(model.getTiles());
        }
        this.setOutput();
    }

    public void fillTiles()
    {
        view.setTiles(model.getTiles());
    }

    public void setOutput()
    {
        view.setOutput(model.getMessageString());
    }
}
