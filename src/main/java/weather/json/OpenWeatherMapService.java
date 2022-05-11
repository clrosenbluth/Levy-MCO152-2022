package weather.json;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenWeatherMapService
{
    String APPID = "356b130974f0167a6792aff5b8127efe";

    @GET("data/2.5/weather?appid=" + APPID + "&units=imperial")
    Observable<CurrentWeather> getCurrentWeather(@Query("q")String zipcode);
}
