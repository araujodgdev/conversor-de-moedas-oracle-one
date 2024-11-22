package modules;

import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Converter {
    private final String baseCurrency;
    private final String targetCurrency;
    private final HttpClient client;
    private URI uri;
    private HttpRequest request;
    private final String apiKey;

    public Converter(String baseCurrency, String targetCurrency) {
        Dotenv dotenv = Dotenv.load();
        apiKey = dotenv.get("API_KEY");
        this.baseCurrency = baseCurrency;
        this.targetCurrency = targetCurrency;
        client = HttpClient.newHttpClient();
    }

    public HttpResponse<String> makeConversion(Float amount) {
        this.uri = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + baseCurrency + "/" + targetCurrency + "/" + amount);
        this.request = HttpRequest.newBuilder(this.uri).GET().build();

        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
