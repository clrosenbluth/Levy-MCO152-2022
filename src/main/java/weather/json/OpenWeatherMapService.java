package weather.json;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenWeatherMapService
{
    @GET("data/2.5/weather?appid=b6907d289e10d714a6e88b30761fae22")
    Observable<CurrentWeather> getCurrentWeather(@Query("zip")String zipcode);
}
