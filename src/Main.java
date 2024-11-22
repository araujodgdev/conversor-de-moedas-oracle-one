import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import enums.ConvertionPairs;
import modules.Converter;
import modules.Interaction;
import records.ConversionResult;

import java.net.http.HttpResponse;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        Interaction interaction = new Interaction();
        interaction.welcome();
        while (true) {
            try {
                interaction.showMenu();
                int userOption = interaction.readOption();

                if (userOption == 0) {
                    interaction.bye();
                    break;
                }

                List<String> currencyPair = ConvertionPairs.getConvertionPairFromOrdinal(userOption).getPair();
                Converter converter = new Converter(currencyPair.getFirst(), currencyPair.getLast());

                float amount = interaction.readAmount();

                HttpResponse<String> response = converter.makeConversion(amount);
                ConversionResult result = gson.fromJson(response.body(), ConversionResult.class);
                System.out.println(result);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}