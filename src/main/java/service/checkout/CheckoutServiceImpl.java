package service.checkout;

import java.math.BigDecimal;

public class CheckoutServiceImpl implements CheckoutService {
    @Override
    public BigDecimal getFinalAmount() {
        return new BigDecimal("0.00");
    }
}
