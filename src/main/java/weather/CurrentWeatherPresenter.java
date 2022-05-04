package weather;

import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import weather.json.CurrentWeather;

public class CurrentWeatherPresenter
{
    private CurrentWeatherFrame view;
    private GetCurrentWeather model;

    public CurrentWeatherPresenter(CurrentWeatherFrame view, GetCurrentWeather model)
    {
        this.view = view;
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
        view.setTemperature(temp);
    }

    private void onError(Throwable throwable)
    {
        view.showError("Error: " + throwable.getMessage());
        throwable.printStackTrace();
    }
}
