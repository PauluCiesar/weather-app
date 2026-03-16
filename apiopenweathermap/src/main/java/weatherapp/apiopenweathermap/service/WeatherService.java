package weatherapp.apiopenweathermap.service;

import weatherapp.apiopenweathermap.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.url}")
    private String apiUrl;

    public WeatherResponse getWeather(String city) {
        // Monta a URL completa para chamar a OpenWeatherMap
        String url = apiUrl + "?q=" + city + "&appid=" + apiKey + "&units=metric&lang=pt_br";

        // Faz a requisição HTTP e recebe como String
        RestTemplate restTemplate = new RestTemplate();
        String jsonResult = restTemplate.getForObject(url, String.class);

        // Converte o JSON em objeto Java
        JSONObject json = new JSONObject(jsonResult);
        JSONObject main = json.getJSONObject("main");
        JSONObject weather = json.getJSONArray("weather").getJSONObject(0);
        JSONObject sys = json.getJSONObject("sys");

        return new WeatherResponse(
                json.getString("name"),
                sys.getString("country"),
                main.getDouble("temp"),
                main.getDouble("feels_like"),
                main.getInt("humidity"),
                weather.getString("description"),
                weather.getString("icon")
        );
    }
}
