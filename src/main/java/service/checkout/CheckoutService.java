package service.checkout;

import model.book.Book;

import java.math.BigDecimal;
import java.util.List;

public interface CheckoutService {
    BigDecimal getFinalAmount(List<Book> bookList);
}
