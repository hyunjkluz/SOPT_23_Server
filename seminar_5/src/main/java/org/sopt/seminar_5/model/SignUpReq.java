package org.sopt.seminar_5.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
//회원 가입, 회원 정보 수정 시 받을 객체 정의
public class SignUpReq {
    private String name, password, part;
    private MultipartFile profile;  //프로필 사진 객체
    private String profileUrl;      //프로필 사진 저장 url 주소
}
