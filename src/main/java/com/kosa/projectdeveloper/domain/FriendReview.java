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

    // 커뮤니티 게시판 글 id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    // 작성자
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // 제목
    @Column(name = "title", nullable = false)
    private String title;

    // 내용
    @Column(name = "content", nullable = false)
    private String content;

    // 작성일
    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Builder // 프론트에서 폼으로 받을 애들
    public FriendReview(User user,String title,String content) {
        this.title = title;
        this.content = content;
//        this.createdAt = createdAt;
        this.user = user;
    }



    public void update(String title, String content) {

        this.title = title;
        this.content = content;
//        this.createdAt = createdAt;
    }


}



