package model.discount;

import java.math.BigDecimal;

public class SubtotalDiscount extends Discount {
    private BigDecimal subtotalAmountCutOff;

    public SubtotalDiscount(BigDecimal subtotalAmountCutOff, BigDecimal discountPercent) {
        this.subtotalAmountCutOff = subtotalAmountCutOff;
        setDiscountPercent(discountPercent);
    }

    public BigDecimal getSubtotalAmountCutOff() {
        return subtotalAmountCutOff;
    }

    public void setSubtotalAmountCutOff(BigDecimal subtotalAmountCutOff) {
        this.subtotalAmountCutOff = subtotalAmountCutOff;
    }
}
