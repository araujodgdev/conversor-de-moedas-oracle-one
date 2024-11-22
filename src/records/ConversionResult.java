package records;

import java.util.HashMap;
import java.util.Map;

public record ConversionResult(Float conversionResult) {

    @Override
    public String toString() {
        return "Resultado da conversão = " + conversionResult + "\n";
    }
}
