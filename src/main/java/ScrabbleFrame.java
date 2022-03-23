import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

/*
 * View
 */

public class ScrabbleFrame extends JFrame
{
    private final ScrabblePresenter presenter;

    private JLabel scoreLabel;
    private JLabel[] tileLabels;
    private JTextField inputField;
    private JButton submit;
    private JLabel output;
    
    private JPanel verticalPanel;

    public ScrabbleFrame()
    {
        setTitle("Touro Scrabble");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        ScrabbleDictionary dictionary = new ScrabbleDictionary();
        LetterPool letterPool = new LetterPool();
        ScrabbleGame scrabbleGame = new ScrabbleGame(dictionary, letterPool);

        presenter = new ScrabblePresenter(this, scrabbleGame);

        addVerticalPanel();
        addTilesPanel();
        addInputField();
        addScoreLabel();
        addSubmitButton();
        addOutputLabel();

    }

    private void addOutputLabel()
    {
        output = new JLabel();
        verticalPanel.add(output);
        presenter.setOutput();
    }

    private void addSubmitButton()
    {
        submit = new JButton("Submit");
        submit.addActionListener(this::onSubmitClicked);
        verticalPanel.add(submit);
    }

    private void addScoreLabel()
    {
        scoreLabel = new JLabel("0");
        verticalPanel.add(scoreLabel);
    }

    private void addInputField()
    {
        inputField = new JTextField();
        inputField.setPreferredSize(new Dimension(120, 60));
        verticalPanel.add(inputField);
    }

    private void addVerticalPanel()
    {
        verticalPanel = new JPanel();
        verticalPanel.setLayout(new BoxLayout(verticalPanel, BoxLayout.Y_AXIS));
        add(verticalPanel);
    }

    private void addTilesPanel()
    {
        JPanel tilesPanel = new JPanel();
        tilesPanel.setLayout(new FlowLayout());
        tileLabels = new JLabel[7];

        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

        for (int i = 0; i < 7; i++)
        {
            tileLabels[i] = new JLabel();
            tileLabels[i].setBorder(border);
            tilesPanel.add(tileLabels[i]);
        }
        verticalPanel.add(tilesPanel);

        presenter.fillTiles();
    }

    public void onSubmitClicked(ActionEvent event)
    {
        String word = inputField.getText();
        presenter.playWord(word);
        presenter.setOutput();
    }

    public void setScore(String score)
    {
        scoreLabel.setText(score);
    }

    public static void main(String[] args)
    {
        JFrame frame = new ScrabbleFrame();
        frame.setVisible(true);
    }

    public void setTileLabels(List<Character> tiles)
    {
        for (int i = 0; i < tiles.size(); i++)
        {
            tileLabels[i].setText(tiles.get(i).toString());
        }
    }

    public void setOutput(String messageString)
    {
        output.setText(messageString);
    }
}
