package com.kosa.projectdeveloper.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Interest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Interest_Id", updatable = false)
    private Long interestId;

    @Column
    private String actorName;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @Builder
    public Interest (User user, String actorName){
        this.user = user;
        this.actorName = actorName;
    }


}
