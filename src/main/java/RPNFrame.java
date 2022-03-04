import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RPNFrame extends JFrame
{
    private JTextField inputField;
    private JButton submit;
    private JLabel output;

    private JPanel verticalPanel;

    private RPN rpn;

    public RPNFrame()
    {
        setTitle("RPN Solver");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        createRPN();

        addVerticalPanel();

        addInputField();
        addSubmitButton();
        addOutputLabel();
    }

    private void createRPN()
    {
        rpn = new RPN();
    }

    private void addVerticalPanel()
    {
        verticalPanel = new JPanel();
        verticalPanel.setLayout(new BoxLayout(verticalPanel, BoxLayout.Y_AXIS));
        add(verticalPanel);
    }

    private void addInputField()
    {
        inputField = new JTextField();
        inputField.setPreferredSize(new Dimension(120, 60));
        verticalPanel.add(inputField);
    }

    private void addSubmitButton()
    {
        submit = new JButton("Submit");
        submit.addActionListener(this::onSubmitClicked);
        verticalPanel.add(submit);
    }

    private void addOutputLabel()
    {
        output = new JLabel("");
        verticalPanel.add(output);
    }

    public void onSubmitClicked(ActionEvent event)
    {
        String eqn = inputField.getText();
        output.setText(rpn.evaluate(eqn));
    }

    public static void main(String[] args)
    {
        JFrame frame = new RPNFrame();
        frame.setVisible(true);
    }
}
