package utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class CurrencyUtils {
    private static final int DEFAULT_SCALE = 2;
    private static final RoundingMode DEFAULT_ROUNDING_MODE = RoundingMode.HALF_UP;

    public static BigDecimal scale(BigDecimal amount) {
        return scaleTo(amount, DEFAULT_SCALE);
    }

    private static BigDecimal scaleTo(BigDecimal amount, int scale) {
        if (amount == null) {
            return null;
        }

        return amount.setScale(scale, DEFAULT_ROUNDING_MODE);
    }
}
