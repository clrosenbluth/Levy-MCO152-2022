package weather;

import io.reactivex.Observable;
import org.junit.jupiter.api.Test;
import weather.json.CurrentWeather;
import static org.junit.jupiter.api.Assertions.*;

class GetCurrentWeatherTest
{
    @Test
    void getCurrentWeather()  // CAN USE blocking first for this test
    {
        // given
        GetCurrentWeather getCurrentWeather = new GetCurrentWeather();
        String zipcode = "10019";

        // when
        Observable<CurrentWeather> observable = getCurrentWeather.getCurrentWeather(zipcode);
        CurrentWeather currentWeather = observable.blockingFirst();

        // then
        assertTrue(currentWeather.getTemperature() > 0);
        assertTrue(currentWeather.getMaxTemperature() > 0);
        assertTrue(currentWeather.getMinTemperature() > 0);
        assertNotNull(currentWeather.getIcon());
        assertNotNull(currentWeather.getDescription());
    }
}