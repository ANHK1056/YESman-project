package com.kosa.projectdeveloper.domain;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;




@Table(name = "reviews")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access =  AccessLevel.PROTECTED)
@Getter
@Entity
public class ShowReview {

    // id is PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long reviewId;

    // Book 엔터티와 1:1(일대일)관계 매핑
    @OneToOne
    // ShowReview 테이블의 FK 를 bookId 로 지정해 Book 엔터티와 연결
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    // 뮤지컬 리뷰 제목
    @Column(nullable = false)
    private String reviewTitle;

    // 뮤지컬 리뷰 내용
    @Column(nullable = false)
    private String reviewContent;

    // 뮤지컬 리뷰 작성일
    @CreatedDate
    @Column(nullable = false)
    private LocalDate reviewPostingDate;


    // 기본 생성자
    @Builder
    public ShowReview(String reviewTitle, String reviewContent, Book book) {
        this.reviewTitle = reviewTitle;
        this.reviewContent = reviewContent;
        this.book = book;

    }

    public void setId(Long reviewId) {
    }

    public void update(String reviewTitle, String reviewContent) {
        this.reviewTitle = reviewTitle;
        this.reviewContent = reviewContent;
    }
}
