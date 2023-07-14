package com.kosa.projectdeveloper.dto;

import com.kosa.projectdeveloper.domain.Interest;
import com.kosa.projectdeveloper.domain.User;
import lombok.Getter;

@Getter
public class InterestListViewResponse {
    private String actorName;
    private User user;

    private String userEmail;

    public InterestListViewResponse(Interest interest){
        this.actorName = interest.getActorName();
        this.user = interest.getUser();
    }


}
