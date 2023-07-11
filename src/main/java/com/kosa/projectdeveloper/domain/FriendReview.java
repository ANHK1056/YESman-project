package com.kosa.projectdeveloper.domain;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Table(name = "friends")
@EntityListeners(AuditingEntityListener.class)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class FriendReview {

    @Id // id 필드를 기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 자동으로 1씩 증가
    @Column(name = "id", updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Builder // 프론트에서 폼으로 받을 애들
    public FriendReview(User user,String title,String content ,LocalDateTime createdAt) {
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.user = user;
    }



    public void update(String title, String content, LocalDateTime createdAt) {

        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
    }


}



