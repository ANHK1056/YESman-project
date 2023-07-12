package com.kosa.projectdeveloper.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
// 예매 관련 엔티티
public class Book {
    @Id
    // TODO: 2023-07-05 키 값 생성하는 방식 검토 필요 date+001 ?
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long bookId;

    // TODO: 2023-07-05 타입 확인 필요
    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime bookDate;

    // TODO: 2023-07-05 타입 확인 필요
    @Column(nullable = false)
    private String showDate;

    // TODO: 2023-07-06 좌석 위치 별도 추가, 확인 필요
    @Column(nullable = false)
    private String seat;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;


<<<<<<< HEAD
=======
//    @OneToOne(mappedBy = "book")
//    private ShowReview showReview;
//    private List<ShowReview> showReviews = new ArrayList<>();

>>>>>>> f5e1c8fb9d7fd2061e60d2e5934d1263ad7ba531
    @ManyToOne
    @JoinColumn(name = "SHOW_ID", nullable = false)
    private Show show;

    // ShowReview 랑 Join 위해 넣었어요..!
    @OneToOne(mappedBy = "book")
    @JoinColumn(name = "bookId", nullable = false)
    // @JoinColumn(name = "bookId", referencedColumnName = "id")
    private ShowReview showReview;

    @Builder
    public Book(User user, Show show, String seat, String showDate) {
        this.user = user;
        this.show = show;
        this.showDate = showDate;
        this.seat = seat;
    }

}
