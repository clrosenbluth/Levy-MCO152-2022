package weather;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import weather.json.CurrentWeather;
import weather.json.OpenWeatherMapService;

import java.io.IOException;

public class GetCurrentWeather
{

    public CurrentWeather getCurrentWeather(String zipcode) throws IOException
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://samples.openweathermap.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        OpenWeatherMapService service = retrofit.create(OpenWeatherMapService.class);

        CurrentWeather currentWeather = service.getCurrentWeather(zipcode)
                .execute()
                .body();

        return currentWeather;
    }

    /**
     *
     * @return the current temperature in Kelvin
     */
    public double getTemperature() throws IOException
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://samples.openweathermap.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        OpenWeatherMapService service = retrofit.create(OpenWeatherMapService.class);

        CurrentWeather currentWeather = service.getCurrentWeather("10019")
                .execute()
                .body();

        return currentWeather.getTemperature();
    }

    public double getMinTemperature() throws IOException
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://samples.openweathermap.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        OpenWeatherMapService service = retrofit.create(OpenWeatherMapService.class);

        CurrentWeather currentWeather = service.getCurrentWeather("10019")
                .execute()
                .body();

        return currentWeather.getMinTemperature();
    }

    public double getMaxTemperature() throws IOException
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://samples.openweathermap.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        OpenWeatherMapService service = retrofit.create(OpenWeatherMapService.class);

        CurrentWeather currentWeather = service.getCurrentWeather("10019")
                .execute()
                .body();

        return currentWeather.getMaxTemperature();
    }

    public String getDescription() throws IOException
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://samples.openweathermap.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        OpenWeatherMapService service = retrofit.create(OpenWeatherMapService.class);

        CurrentWeather currentWeather = service.getCurrentWeather("10019")
                .execute()
                .body();

        return currentWeather.getDescription();
    }

    public String getIcon() throws IOException
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://samples.openweathermap.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        OpenWeatherMapService service = retrofit.create(OpenWeatherMapService.class);

        CurrentWeather currentWeather = service.getCurrentWeather("10019")
                .execute()
                .body();

        return currentWeather.getIcon();
    }


}
