package org.sopt.seminar_5.dto;

import lombok.Data;

@Data
//회원 조회 시 전달할 객체 정의
public class User {
    private int userIdx;
    private String name;
    private String part;
    //private String password;
    private String profileUrl;
}
