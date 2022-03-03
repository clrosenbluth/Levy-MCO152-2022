import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ScrabbleFrame extends JFrame
{
    private int score = 0;
    private JLabel scoreLabel;
    private JLabel[] tiles;
    private JTextField inputField;
    private JButton submit;
    private JLabel output;
    
    private JPanel verticalPanel;

    private ScrabbleGame scrabbleGame;

    public ScrabbleFrame()
    {
        setTitle("Touro Scrabble");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        ScrabbleDictionary dictionary = new ScrabbleDictionary();
        LetterPool letterPool = new LetterPool();
        scrabbleGame = new ScrabbleGame(dictionary, letterPool);
        
        verticalPanel = new JPanel();
        verticalPanel.setLayout(new BoxLayout(verticalPanel, BoxLayout.Y_AXIS));
        add(verticalPanel);

        addTilesPanel(verticalPanel);

        inputField = new JTextField();
        inputField.setPreferredSize(new Dimension(120, 60));
        verticalPanel.add(inputField);

        scoreLabel = new JLabel("0");
        verticalPanel.add(scoreLabel);

        submit = new JButton("Submit");
        submit.addActionListener(this::onSubmitClicked);
        verticalPanel.add(submit);

        output = new JLabel("Output");
        verticalPanel.add(output);

    }

    private void addTilesPanel(JPanel verticalPanel)
    {
        JPanel tilesPanel = new JPanel();
        tilesPanel.setLayout(new FlowLayout());
        tiles = new JLabel[7];
        for (int i = 0; i < 7; i++)
        {
            tiles[i] = new JLabel(scrabbleGame.tiles.get(i).toString());
            tilesPanel.add(tiles[i]);
        }
        verticalPanel.add(tilesPanel);
    }

    public void onSubmitClicked(ActionEvent event)
    {
        String word = inputField.getText();
        if (scrabbleGame.playWord(word))
        {
            score++;
            scoreLabel.setText(String.valueOf(score));

            for (int i = 0; i < tiles.length; i++)
            {
                tiles[i].setText(scrabbleGame.tiles.get(i).toString());
            }
        }

    }

    public static void main(String[] args)
    {
        JFrame frame = new ScrabbleFrame();
        frame.setVisible(true);
    }
}
