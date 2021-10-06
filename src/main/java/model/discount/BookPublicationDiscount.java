package model.discount;

import java.time.LocalDate;

public class BookPublicationDiscount extends Discount{
    private LocalDate cutOffDate;

    public LocalDate getCutOffDate() {
        return cutOffDate;
    }

    public void setCutOffDate(LocalDate cutOffDate) {
        this.cutOffDate = cutOffDate;
    }
}
