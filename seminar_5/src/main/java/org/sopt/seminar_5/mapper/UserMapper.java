package org.sopt.seminar_5.mapper;

import org.apache.ibatis.annotations.*;
import org.sopt.seminar_5.dto.User;
import org.sopt.seminar_5.model.SignUpReq;

import java.util.List;

@Mapper
public interface UserMapper {

    //모든 회원 조회
    @Select("SELECT * FROM user")
    List<User> findAll();

    //인덱스로 회원 조회
    @Select("SELECT * FROM user WHERE userIdx = #{userIdx}")
    User findByUserIdx(final int userIdx);

    //이름으로 회원 조회
    @Select("SELECT * FROM user WHERE name = #{name}")
    User findByUserName(final String name);

    //파트로 회원 조회
    @Select("SELECT * FROM user WHERE part = #{part}")
    List<User> findByUserPart(final String part);

    //회원 저장
    @Insert("INSERT INTO user(name, part, profileUrl) VALUES(#{signUpReq.name}, #{signUpReq.part}, #{signUpReq.profileUrl})")
    @Options(useGeneratedKeys = true, keyColumn = "user.userIdx")
    int saveUser(@Param("signUpReq") final SignUpReq signUpReq);

    //프로필 사진 없는 회원 정보 저장
    @Insert("INSERT INTO user(name, part) VALUES(#{user.name}, #{user.part})")
    @Options(useGeneratedKeys = true, keyColumn = "user.userIdx")
    int saveUserNoUrl(@Param("signUpReq") final User user);

    //회원 정보 수정
    @Update("UPDATE user SET name = #{user.name}, part = #{user.part} WHERE userIdx = #{userIdx}")
    void updateUser(@Param("userIdx") final int userIdx, @Param("user") final User user);

    //회원 삭제
    @Delete("DELETE FROM user WHERE userIdx = #{userIdx}")
    void deleteUser(@Param("userIdx") final int userIdx);
}
