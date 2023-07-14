//package com.kosa.projectdeveloper.domain.pumpkin;
//
//import com.kosa.projectdeveloper.domain.User;
//import jakarta.persistence.*;
//import lombok.AccessLevel;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import java.lang.reflect.Member;
//import java.util.ArrayList;
//
//import static jakarta.persistence.CascadeType.ALL;
//import static jakarta.persistence.FetchType.LAZY;
//import static jakarta.persistence.GenerationType.IDENTITY;
//
//@Table(name = "PUMPKIN")
//@Getter
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@Entity
//public class Pumpkin {
//
//    @Id
//    @GeneratedValue(strategy = IDENTITY)
//    @Column(name = "post_id")
//    private Long id;
//
//
//    @ManyToOne(fetch = LAZY)
//    @JoinColumn(name = "writer_id")
//    private User writer;
//
//
//    @Column(length = 40, nullable = false)
//    private String title;
//
//    @Lob
//    @Column(nullable = false)
//    private String content;
//
//    @Column(nullable = true)
//    private String filePath;
//
//    @Builder
//    public Pumpkinkin(String title, String content) {
//        this.title = title;
//        this.content = content;
//    }
//
//    //== 게시글을 삭제하면 달려있는 댓글 모두 삭제 ==//
//    @OneToMany(mappedBy = "pumpkin", cascade = ALL, orphanRemoval = true)
//    private List<Comment> commentList = new ArrayList<>();
//
//
//
//
//    //== 연관관계 편의 메서드 ==//
//    public void confirmWriter(Member writer) {
//        //writer 는 변경이 불가능하므로 이렇게만 해주어도 될듯
//        this.writer = writer;
//        writer.addPumpkin(this);
//    }
//
//    public void addComment(Comment comment){
//        //comment의 Post 설정은 comment에서 함
//        commentList.add(comment);
//    }
//
//
//
//    //== 내용 수정 ==//
//    public void updateTitle(String title) {
//        this.title = title;
//    }
//
//    public void updateContent(String content) {
//        this.content = content;
//    }
//
//    public void updateFilePath(String filePath) {
//        this.filePath = filePath;
//    }
//}