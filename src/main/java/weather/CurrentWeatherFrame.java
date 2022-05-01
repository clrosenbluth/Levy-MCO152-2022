package weather;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import weather.json.CurrentWeather;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

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

    private GetCurrentWeather getCurrentWeather = new GetCurrentWeather();

    public CurrentWeatherFrame()
    {
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
        zipcode.setPreferredSize(new Dimension(120, 60));
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
        Observable<CurrentWeather> observable = getCurrentWeather.getCurrentWeather(zipcode.getText());
        observable
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .subscribe(this::onNext, this::onError);
    }

    public void onNext(CurrentWeather currentWeather)
    {
        double temp = currentWeather.getTemperature();
        temperature.setText(String.valueOf(temp));
    }

    public void onError(Throwable throwable)
    {
        temperature.setText("Error: " + throwable.getMessage());
        throwable.printStackTrace();
    }

    public static void main(String[] args)
    {
        JFrame frame = new CurrentWeatherFrame();
        frame.setVisible(true);
    }
}
