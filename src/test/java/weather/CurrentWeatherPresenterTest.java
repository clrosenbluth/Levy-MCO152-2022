package weather;

import io.reactivex.Single;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import weather.json.CurrentWeather;
import weather.json.OpenWeatherMapService;

import javax.inject.Provider;

import static org.mockito.Mockito.*;

class CurrentWeatherPresenterTest
{
    @BeforeAll
    static public void beforeAllTests()
    {
        RxJavaPlugins.setIoSchedulerHandler((scheduler) -> Schedulers.trampoline());
        RxJavaPlugins.setNewThreadSchedulerHandler((scheduler) -> Schedulers.trampoline());
    }

    @Test
    void loadWeatherFromZipcode()
    {
        // given
        CurrentWeatherFrame view = mock(CurrentWeatherFrame.class);
        OpenWeatherMapService model = mock(OpenWeatherMapService.class);
        Provider<CurrentWeatherFrame> viewProvider = () -> view;
        CurrentWeatherPresenter presenter = new CurrentWeatherPresenter(viewProvider, model);
        CurrentWeather currentWeather = mock(CurrentWeather.class);
        doReturn(100.0)
                .when(currentWeather).getTemperature();
        doReturn(Single.just(currentWeather))
                .when(model).getCurrentWeather("00000");

        // when
        presenter.loadWeatherFromZipcode("00000");

        // then
        verify(view).setTemperature(100.0);
    }
}