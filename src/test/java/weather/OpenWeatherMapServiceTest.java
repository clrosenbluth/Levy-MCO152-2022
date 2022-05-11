package weather;

import io.reactivex.Observable;
import org.junit.jupiter.api.Test;
import weather.json.CurrentWeather;
import weather.json.OpenWeatherMapService;
import weather.json.OpenWeatherMapServiceFactory;

import static org.junit.jupiter.api.Assertions.*;

class OpenWeatherMapServiceTest
{
    @Test
    void getCurrentWeather()  // CAN USE blocking first for this test
    {
        // given
        OpenWeatherMapServiceFactory factory = new OpenWeatherMapServiceFactory();
        OpenWeatherMapService service = factory.getInstance();
        String zipcode = "10019";

        // when
        CurrentWeather currentWeather = service.getCurrentWeather(zipcode).blockingFirst();

        // then
        assertTrue(currentWeather.getTemperature() > 0);
        assertTrue(currentWeather.getMaxTemperature() > 0);
        assertTrue(currentWeather.getMinTemperature() > -459.67);   // the fahrenheit of 0 kelvin
        assertNotNull(currentWeather.getIcon());
        assertNotNull(currentWeather.getDescription());
    }
}