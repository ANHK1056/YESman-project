package com.kosa.projectdeveloper.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpdateUserReuest {
    private String userBirth;
    private String userGender;
    private String userPhNm;
    private String userAddress;

    private String userEmail;

}
