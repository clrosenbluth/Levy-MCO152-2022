package weather;

import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import weather.json.CurrentWeather;
import weather.json.OpenWeatherMapService;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
public class CurrentWeatherPresenter
{
    private Provider<CurrentWeatherFrame> viewProvider;
    private OpenWeatherMapService model;

    @Inject
    public CurrentWeatherPresenter(
            Provider<CurrentWeatherFrame> viewProvider,
            OpenWeatherMapService model)
    {
        this.viewProvider = viewProvider;
        this.model = model;
    }

    public void loadWeatherFromZipcode(String zipcode)
    {
        Disposable disposable = model.getCurrentWeather(zipcode)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .subscribe(this::onNext, this::onError);
    }

    private void onNext(CurrentWeather currentWeather)
    {
        double temp = currentWeather.getTemperature();
        viewProvider.get().setTemperature(temp);
    }

    private void onError(Throwable throwable)
    {
        viewProvider.get().showError("Error: " + throwable.getMessage());
        throwable.printStackTrace();
    }
}
