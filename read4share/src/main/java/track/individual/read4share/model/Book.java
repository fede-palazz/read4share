package track.individual.read4share.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Book")
@Table(name = "book")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @Column(name = "isbn", length = 13)
    private String isbn;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "author", nullable = false)
    private String author;
    @Column(name = "publ_date", nullable = false)
    private Date publDate;
    @Column(name = "publisher", nullable = false)
    private String publisher;
    @Column(name = "lang", nullable = false)
    private String language;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_cat_id", referencedColumnName = "cat_id")
    private Category category;
}