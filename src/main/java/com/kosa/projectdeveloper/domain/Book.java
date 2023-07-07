package com.kosa.projectdeveloper.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

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

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String showId;

    @Column(nullable = false)
    private String bookMail;

    // TODO: 2023-07-05 타입 확인 필요
    @Column(nullable = false)
    private String bookDay;

    // TODO: 2023-07-05 타입 확인 필요
    @Column(nullable = false)
    private String bookTime;

    // TODO: 2023-07-05 타입 확인 필요
    @Column(nullable = false)
    private Long bookPay;

    // TODO: 2023-07-06 좌석 위치 별도 추가, 확인 필요
    @Column(nullable = false)
    private String seatPosition;

    // TODO: 2023-07-06 공연장 위치 별도 추가, 확인 필요
    @Column(nullable = false)
    private String showLocation;


    @CreatedDate
    @Column
    private LocalDateTime createdAt;


    @Builder
    public Book(Long bookId, String userId, String showId, String bookMail, String bookDay,
                String bookTime, Long bookPay, String seatPosition, String showLocation) {
//        this.bookId = bookId;
        this.userId = userId;
        this.showId = showId;
        this.bookMail = bookMail;
        this.bookDay = bookDay;
        this.bookTime = bookTime;
        this.bookPay = bookPay;
        this.seatPosition = seatPosition;
        this.showLocation = showLocation;
    }

}
