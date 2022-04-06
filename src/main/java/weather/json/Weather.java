package weather.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Weather
{
    @SerializedName("id")
    @Expose
    double id;

    @SerializedName("main")
    @Expose
    String main;

    @SerializedName("description")
    @Expose
    String description;

    @SerializedName("icon")
    @Expose
    String icon;

}
