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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long bookId;
    
    // 예매 일시
    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime bookDate;
    
    // 연극 상영 일자
    @Column(nullable = false)
    private String showDate;

    // 좌석
    @Column(nullable = false)
    private String seat;

    // 유저 정보
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    // 연극 정보
    @ManyToOne
    @JoinColumn(name = "SHOW_ID")
    private Show show;

    @Builder
    public Book(User user, Show show, String seat, String showDate) {
        this.user = user;
        this.show = show;
        this.showDate = showDate;
        this.seat = seat;
    }

}
