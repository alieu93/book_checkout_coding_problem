package service.checkout;

import model.book.Book;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CheckoutServiceTestUtils {
    public static final String BOOK_TITLE_1 = "Still Life With Woodpecker";
    public static final LocalDate BOOK_PUBLICATION_1 = LocalDate.parse("1980-01-20");
    public static final BigDecimal BOOK_PRICE_1 = new BigDecimal("11.05");

    public static final String BOOK_TITLE_2 = "Great Expectations";
    public static final LocalDate BOOK_PUBLICATION_2 = LocalDate.parse("1861-01-20");
    public static final BigDecimal BOOK_PRICE_2 = new BigDecimal("13.21");

    public static final String BOOK_TITLE_3 = "Moby Dick";
    public static final LocalDate BOOK_PUBLICATION_3 = LocalDate.parse("1851-01-20");
    public static final BigDecimal BOOK_PRICE_3 = new BigDecimal("15.20");

    public static final String BOOK_TITLE_4 = "The Terrible Privacy of Maxwell Sim";
    public static final LocalDate BOOK_PUBLICATION_4 = LocalDate.parse("2020-01-20");
    public static final BigDecimal BOOK_PRICE_4 = new BigDecimal("13.14");

    public static final String BOOK_TITLE_5 = "Three Men in a Boat";
    public static final LocalDate BOOK_PUBLICATION_5 = LocalDate.parse("1889-02-10");
    public static final BigDecimal BOOK_PRICE_5 = new BigDecimal("12.87");

    static List<Book> buildBookList1() {
        return Arrays.asList(new Book(BOOK_TITLE_1, BOOK_PUBLICATION_1, BOOK_PRICE_1),
                            new Book(BOOK_TITLE_2, BOOK_PUBLICATION_2, BOOK_PRICE_2),
                            new Book(BOOK_TITLE_5, BOOK_PUBLICATION_5, BOOK_PRICE_5));
    }

    static List<Book> buildBookList2() {
        return Arrays.asList(new Book(BOOK_TITLE_4, BOOK_PUBLICATION_4, BOOK_PRICE_4),
                new Book(BOOK_TITLE_5, BOOK_PUBLICATION_5, BOOK_PRICE_5));
    }

    static List<Book> buildBookList3() {
        return Collections.singletonList(new Book(BOOK_TITLE_3, BOOK_PUBLICATION_3, BOOK_PRICE_3));
    }
}
