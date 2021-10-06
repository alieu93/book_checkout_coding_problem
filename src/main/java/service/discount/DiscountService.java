package service.discount;

import model.book.Book;
import model.discount.BookPublicationDiscount;
import model.discount.SubtotalDiscount;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface DiscountService {
    BookPublicationDiscount getBookPublicationDiscount(LocalDate publicationDate);

    SubtotalDiscount getSubtotalDiscount(BigDecimal subTotal);
}
