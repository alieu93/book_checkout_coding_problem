package model.book;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Book {
    private String title;
    private LocalDate publicationDate;
    private BigDecimal price;

    public Book(String title, LocalDate publicationDate, BigDecimal price) {
        this.title = title;
        this.publicationDate = publicationDate;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
