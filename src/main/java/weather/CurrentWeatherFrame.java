package weather;

import weather.dagger.DaggerCurrentWeatherComponent;
import weather.json.OpenWeatherMapServiceFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

@Singleton
public class CurrentWeatherFrame extends JFrame
{
    /*
     * A JTextField for the zipcode
     * A JButton to Submit
     * A JLabel for temperature in F
     */

    private JTextField zipcode;
    private JButton submit;
    private JLabel temperature;

    private JPanel verticalPanel;

    private final OpenWeatherMapServiceFactory factory = new OpenWeatherMapServiceFactory();
    private final CurrentWeatherPresenter presenter;

    @Inject
    public CurrentWeatherFrame(CurrentWeatherPresenter presenter)
    {
        this.presenter = presenter;

        setTitle("Current Weather");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        addVerticalPanel();
        addZipcode();
        addSubmitButton();
        addTemperature();
    }

    private void addVerticalPanel()
    {
        verticalPanel = new JPanel();
        verticalPanel.setLayout(new BoxLayout(verticalPanel, BoxLayout.Y_AXIS));
        add(verticalPanel);
    }

    private void addZipcode()
    {
        zipcode = new JTextField();
        zipcode.setPreferredSize(new Dimension(60, 30));
        zipcode.setToolTipText("Enter zipcode");
        verticalPanel.add(zipcode);
    }

    private void addSubmitButton()
    {
        submit = new JButton("Submit");
        submit.addActionListener(this::onSubmitClicked);
        verticalPanel.add(submit);
    }

    private void addTemperature()
    {
        temperature = new JLabel();
        verticalPanel.add(temperature);
    }

    public void onSubmitClicked(ActionEvent event)
    {
        presenter.loadWeatherFromZipcode(zipcode.getText());
    }

    public void setTemperature(double temp)
    {
        temperature.setText(String.valueOf(temp));
    }

    public void showError(String error)
    {
        temperature.setText(error);
    }

    public static void main(String[] args)
    {
        JFrame frame = DaggerCurrentWeatherComponent.create()
                        .getCurrentWeatherFrame();
        frame.setVisible(true);
    }
}
