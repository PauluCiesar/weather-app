package weatherapp.apiopenweathermap.model;

public class WeatherResponse {
    private String city;
    private String country;
    private double temperature;
    private double feelsLike;
    private int humidity;
    private String description;
    private String icon;

    // Construtor completo
    public WeatherResponse(String city, String country, double temperature,
                           double feelsLike, int humidity, String description, String icon) {
        this.city = city;
        this.country = country;
        this.temperature = temperature;
        this.feelsLike = feelsLike;
        this.humidity = humidity;
        this.description = description;
        this.icon = icon;
    }

    // Getters (obrigatórios para o Spring converter em JSON)
    public String getCity() { return city; }
    public String getCountry() { return country; }
    public double getTemperature() { return temperature; }
    public double getFeelsLike() { return feelsLike; }
    public int getHumidity() { return humidity; }
    public String getDescription() { return description; }
    public String getIcon() { return icon; }
}