package weather.json;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.inject.Inject;

public class OpenWeatherMapServiceFactory
{
    @Inject
    public OpenWeatherMapServiceFactory() {
        // blank constructor, necessary for Dagger
    }

    public OpenWeatherMapService getInstance()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit.create(OpenWeatherMapService.class);
    }
}
