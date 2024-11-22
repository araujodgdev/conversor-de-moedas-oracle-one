package enums;

import records.Pair;

import java.util.ArrayList;
import java.util.List;

public enum ConvertionPairs {USD_TO_ARS("USD", "ARS"), ARS_TO_USD("ARS", "USD"), USD_TO_BRL("USD", "BRL"), BRL_TO_USD("BRL", "USD"), EUR_TO_BRL("EUR", "BRL"), BRL_TO_EUR("BRL", "EUR");

    private final Pair pair;
    ConvertionPairs(String base, String target) {
        this.pair = new Pair(base, target);
    }

    public List<String> getPair() {
        List<String> list = new ArrayList<>();
        list.add(pair.baseCurrency());
        list.add(pair.targetCurrency());
        return list;
    }

    public static ConvertionPairs getConvertionPairFromOrdinal(int ordinal) {
        for (ConvertionPairs cp : ConvertionPairs.values()) {
            if (cp.ordinal() == ordinal - 1) {
                return cp;
            }
        }

        throw new IllegalArgumentException("No pair matches the given ordinal number: " + ordinal);
    }
}
