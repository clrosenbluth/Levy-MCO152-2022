package weather;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GetCurrentWeatherTest
{

    @Test
    void getTemperature() throws IOException
    {
        // given
        GetCurrentWeather getCurrentWeather = new GetCurrentWeather();

        // when
        double temp = getCurrentWeather.getTemperature();

        // then
        assertTrue(temp > 0);
    }

    @Test
    void getMinTemperature() throws IOException
    {
        // given
        GetCurrentWeather getCurrentWeather = new GetCurrentWeather();

        // when
        double minTemp = getCurrentWeather.getMinTemperature();

        // then
        assertTrue(minTemp > 0);
    }

    @Test
    void getMaxTemperature() throws IOException
    {
        // given
        GetCurrentWeather getCurrentWeather = new GetCurrentWeather();

        // when
        double maxTemp = getCurrentWeather.getMaxTemperature();

        // then
        assertTrue(maxTemp > 0);
    }

    @Test
    void getDescription() throws IOException
    {
        // given
        GetCurrentWeather getCurrentWeather = new GetCurrentWeather();

        // when
        String description = getCurrentWeather.getDescription();

        // then
        assertNotNull(description);
    }

    @Test
    void getIcon() throws IOException
    {
        // given
        GetCurrentWeather getCurrentWeather = new GetCurrentWeather();

        // when
        String icon = getCurrentWeather.getIcon();

        // then
        assertNotNull(icon);
    }

}