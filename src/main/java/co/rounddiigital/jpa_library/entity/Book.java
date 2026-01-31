package co.rounddiigital.jpa_library.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TABLE_BOOK")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @OneToOne(cascade = CascadeType.ALL,  fetch = FetchType.LAZY)
    private Author author;
    private Double price;
    @Column(unique = true)
    private String isbn;
    @Column(length = 1000)
    private String description;
    private Date createDate;
    private Date publishDate;
}
// @OneToMany, ManytoOne, ManytoMany
// @JoinColumn