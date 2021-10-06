package service.checkout;

import model.book.Book;
import model.discount.BookPublicationDiscount;
import model.discount.SubtotalDiscount;
import service.discount.DiscountService;
import utils.CurrencyUtils;

import java.math.BigDecimal;
import java.util.List;

public class CheckoutServiceImpl implements CheckoutService {
    private final DiscountService discountService;

    public CheckoutServiceImpl(DiscountService discountService) {
        this.discountService = discountService;
    }

    @Override
    public BigDecimal getFinalAmount(List<Book> bookList) {
        if (bookList != null && !bookList.isEmpty()) {
            return getTotalAmountFromBookList(bookList);
        }
        return BigDecimal.ZERO;
    }

    private BigDecimal getTotalAmountFromBookList(List<Book> bookList) {
        BigDecimal subTotal = BigDecimal.ZERO;
        for (Book book: bookList) {
            subTotal = subTotal.add(getCalculatedAmountFromPublicationDiscount(book));
        }
        return getCalculatedFinalAmount(subTotal);
    }

    private BigDecimal getCalculatedAmountFromPublicationDiscount(Book book) {
        BookPublicationDiscount bookPublicationDiscount = discountService.getBookPublicationDiscount(book.getPublicationDate());
        return book.getPublicationDate().isAfter(bookPublicationDiscount.getCutOffDate()) ?
                CurrencyUtils.calculateDiscountedAmount(book.getPrice(), bookPublicationDiscount.getDiscountPercent()) : book.getPrice();
    }

    private BigDecimal getCalculatedFinalAmount(BigDecimal subTotal) {
        SubtotalDiscount subTotalDiscount = discountService.getSubtotalDiscount(subTotal);
        return subTotal.compareTo(subTotalDiscount.getSubtotalAmountCutOff()) > 0 ?
                CurrencyUtils.calculateDiscountedAmount(subTotal, subTotalDiscount.getDiscountPercent()) : subTotal;
    }
}
