package model.discount;

import java.math.BigDecimal;

public class Discount {
    private BigDecimal discountPercent;

    public BigDecimal getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(BigDecimal discountPercent) {
        this.discountPercent = discountPercent;
    }
}
