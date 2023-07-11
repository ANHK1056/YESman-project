package com.kosa.projectdeveloper.domain;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Table(name = "reviews")
@NoArgsConstructor(access =  AccessLevel.PROTECTED)
@Getter
@Entity
public class ShowReview {

    // id is PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long review_id;

    // User 엔터티와 N:1(다대일)관계 매핑
    @ManyToOne
    // TODO: 2023-07-07 각 클래스?의 Id 형식 지정 필요할것 같습니다. 클래스명_Id  or  클래스명Id
    // ShowReview 테이블의 FK 를 userId 로 지정해 User 엔터티와 연결
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    // Show 엔터티와 N:1(다대일)관계 매핑
    @ManyToOne
    // ShowReview 테이블의 FK 를 show_Id 로 지정해 Show 엔터티와 연결
    @JoinColumn(name = "SHOW_ID", nullable = false)
    private Show show;

    // Book 엔터티와 1:1(일대일)관계 매핑
    @OneToOne
    // ShowReview 테이블의 FK 를 bookId 로 지정해 Book 엔터티와 연결
    @JoinColumn(name = "BOOK_ID", nullable = false)
    private Book book;

    // 뮤지컬 리뷰 제목
    @Column(nullable = false)
    private String review_Title;

    // 뮤지컬 리뷰 내용
    @Column(nullable = false)
    private String review_Content;

    // 뮤지컬 리뷰 작성일
    @CreatedDate
    // Temporal   ---> @CreatedDate가 안될경우 이걸로 바꿔서 해보기
    @Column(nullable = false)
    private LocalDateTime review_PostingDate;
    // Temporal

    // 기본 생성자
    @Builder
    // 기본 생성자
    public ShowReview(Long review_id, User user, Show show, Book book, String review_Title, String review_Content) {
//      this.review_id = review_id;
        this.user = user;
        this.show = show;
        this.book = book;
        this.review_Title = review_Title;
        this.review_Content = review_Content;
    }

}
