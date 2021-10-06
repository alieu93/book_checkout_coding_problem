package service.checkout;

import model.discount.BookPublicationDiscount;
import model.discount.SubtotalDiscount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import service.discount.DiscountService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;
import static service.checkout.CheckoutServiceTestUtils.*;

class CheckoutServiceImplTest {
    private static final BigDecimal BOOKS_AFTER_2000_DISCOUNT_PERCENT = new BigDecimal("0.1");
    private static final LocalDate BOOK_PUBLICATION_CUT_OFF = LocalDate.parse("1999-12-31");
    private static final BigDecimal CUT_OFF_FOR_DISCOUNT = new BigDecimal("30.00");
    private static final BigDecimal TOTAL_AMOUNT_DISCOUNT_IF_MORE_THAN_CUT_OFF = new BigDecimal("0.05");

    private static final BigDecimal EXPECTED_SUBTOTAL_OF_BOOK_LIST_1 = new BigDecimal("37.13");
    private static final BigDecimal EXPECTED_TOTAL_AMOUNT_OF_BOOK_LIST_1 = new BigDecimal("35.27");
    private static final BigDecimal EXPECTED_SUBTOTAL_OF_BOOK_LIST_2 = new BigDecimal("24.70");

    private final DiscountService discountService = mock(DiscountService.class);
    private final CheckoutServiceImpl fixture = new CheckoutServiceImpl(discountService);


    @BeforeEach
    void setUp() {
        when(discountService.getBookPublicationDiscount(isA(LocalDate.class))).thenReturn(new BookPublicationDiscount(BOOK_PUBLICATION_CUT_OFF, BOOKS_AFTER_2000_DISCOUNT_PERCENT));
        when(discountService.getSubtotalDiscount(isA(BigDecimal.class))).thenReturn(new SubtotalDiscount(CUT_OFF_FOR_DISCOUNT, TOTAL_AMOUNT_DISCOUNT_IF_MORE_THAN_CUT_OFF));
    }

    @Test
    void checkOut_Works_Ok() {
        assertThat(fixture.getFinalAmount(CheckoutServiceTestUtils.buildBookList1())).isEqualTo(EXPECTED_TOTAL_AMOUNT_OF_BOOK_LIST_1);

        verify(discountService).getSubtotalDiscount(EXPECTED_SUBTOTAL_OF_BOOK_LIST_1);
        ArgumentCaptor<LocalDate> localDateArgumentCaptor = ArgumentCaptor.forClass(LocalDate.class);
        verify(discountService, times(3)).getBookPublicationDiscount(localDateArgumentCaptor.capture());
        assertThat(localDateArgumentCaptor.getAllValues()).usingRecursiveComparison().isEqualTo(Arrays.asList(BOOK_PUBLICATION_1, BOOK_PUBLICATION_2, BOOK_PUBLICATION_5));
    }

    @Test
    void checkOutWorksOk_No_Subtotal_Discount() {
        assertThat(fixture.getFinalAmount(CheckoutServiceTestUtils.buildBookList2())).isEqualTo(EXPECTED_SUBTOTAL_OF_BOOK_LIST_2);
        verify(discountService).getSubtotalDiscount(EXPECTED_SUBTOTAL_OF_BOOK_LIST_2);

        ArgumentCaptor<LocalDate> localDateArgumentCaptor = ArgumentCaptor.forClass(LocalDate.class);
        verify(discountService, times(2)).getBookPublicationDiscount(localDateArgumentCaptor.capture());
        assertThat(localDateArgumentCaptor.getAllValues()).usingRecursiveComparison().isEqualTo(Arrays.asList(BOOK_PUBLICATION_4, BOOK_PUBLICATION_5));
    }

    @Test
    void checkOutWorksOk_With_Only_One_Book() {
        assertThat(fixture.getFinalAmount(buildBookList3())).isEqualTo(BOOK_PRICE_3);
        verify(discountService).getSubtotalDiscount(BOOK_PRICE_3);
        verify(discountService).getBookPublicationDiscount(BOOK_PUBLICATION_3);
    }

    @Test
    void checkOut_Works_Ok_With_Null_List() {
        assertThat(fixture.getFinalAmount(null)).isEqualTo(BigDecimal.ZERO);
        verifyNoInteractions(discountService);
    }
}
