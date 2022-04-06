package weather.json;

public class CurrentWeather
{
    Main main;
    Weather[] weather;

    public double getTemperature()
    {
        return main.temp;
    }

    public double getMaxTemperature()
    {
        return main.temp_max;
    }

    public double getMinTemperature()
    {
        return main.temp_min;
    }

    public String getDescription()
    {
        return weather[0].description;
    }

    public String getIcon()
    {
        return weather[0].icon;
    }

}
