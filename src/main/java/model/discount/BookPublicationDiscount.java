package model.discount;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BookPublicationDiscount extends Discount {
    private LocalDate cutOffDate;

    public BookPublicationDiscount(LocalDate cutOffDate, BigDecimal discountPercent) {
        this.cutOffDate = cutOffDate;
        setDiscountPercent(discountPercent);
    }

    public LocalDate getCutOffDate() {
        return cutOffDate;
    }

    public void setCutOffDate(LocalDate cutOffDate) {
        this.cutOffDate = cutOffDate;
    }
}
