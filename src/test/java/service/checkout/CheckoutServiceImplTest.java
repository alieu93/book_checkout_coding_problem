package service.checkout;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class CheckoutServiceImplTest {
    private static final BigDecimal BOOKS_AFTER_2000_DISCOUNT = new BigDecimal("0.1");
    private static final BigDecimal TOTAL_AMOUNT_CUT_OFF_FOR_DISCOUNT = new BigDecimal("30.00");
    private static final BigDecimal TOTAL_AMOUNT_DISCOUNT_IF_MORE_THAN_CUT_OFF = new BigDecimal("0.05");

    private final CheckoutServiceImpl fixture = new CheckoutServiceImpl();

    @Test
    void checkOutWorksOk() {
        assertThat(fixture.getFinalAmount()).isEqualTo(new BigDecimal("0.00"));
    }
}
