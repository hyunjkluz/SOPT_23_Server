package org.sopt.seminar_5.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Select;
import org.sopt.seminar_5.dto.User;
import org.sopt.seminar_5.mapper.UserMapper;
import org.sopt.seminar_5.model.DefaultRes;
import org.sopt.seminar_5.model.SignUpReq;
import org.sopt.seminar_5.utils.ResponseMessage;
import org.sopt.seminar_5.utils.StatusCode;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Slf4j
@Service(value = "UserService")
public class UserService {
    private final UserMapper userMapper;
    private final S3FileUploadService s3FileUploadService;

    public UserService(final UserMapper usermapper, final S3FileUploadService s3fileuploadservice) {
        this.userMapper = usermapper;
        this.s3FileUploadService = s3fileuploadservice;
    }

    //전체 회원 목록 조회
    public DefaultRes<List<User>> getAllUsers() {
        final List<User> userList = userMapper.findAll();

        if (userList.isEmpty())
            return DefaultRes.res(StatusCode.NOT_FOUND, ResponseMessage.NOT_FOUND_USER);
        return DefaultRes.res(StatusCode.OK, ResponseMessage.READ_USER, userList);
    }

    //회원 인덱스로 조회
    public DefaultRes<User> findByUserIdx(final int userIdx) {
        final User user = userMapper.findByUserIdx(userIdx);

        if (user == null)
            return DefaultRes.res(HttpStatus.NOT_FOUND.value(), ResponseMessage.NOT_FOUND_USER);
        return DefaultRes.res(StatusCode.OK, ResponseMessage.READ_USER, user);
    }

    //이름으로 회원 조회
    public DefaultRes<User> findByUserName(final String name) {
        final User user = userMapper.findByUserName(name);

        if (user == null)
            return DefaultRes.res(HttpStatus.NOT_FOUND.value(), ResponseMessage.NOT_FOUND_USER);
        return DefaultRes.res(StatusCode.OK, ResponseMessage.READ_USER, user);
    }

    //파트로 회원 조희
    public DefaultRes<List<User>> findByUserPart(final String part) {
        final List<User> partList = userMapper.findByUserPart(part);

        if (partList == null)
            return DefaultRes.res(HttpStatus.NOT_FOUND.value(), ResponseMessage.NOT_FOUND_USER);
        return DefaultRes.res(StatusCode.OK, ResponseMessage.READ_USER, partList);

    }

    //회원가입
    @Transactional
    public DefaultRes saveUser(SignUpReq signUpReq) {
        try {
            if (signUpReq.getProfile() != null)
                signUpReq.setProfileUrl(s3FileUploadService.upload(signUpReq.getProfile()));

            userMapper.saveUser(signUpReq);

            return DefaultRes.res(StatusCode.CREATED, ResponseMessage.CREATED_USER);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.error(e.getMessage());

            return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
        }
    }

    //회원 정보 수정
    @Transactional
    public DefaultRes updateUser(final int userIdx, final User user) {
        User temp = userMapper.findByUserIdx(userIdx);
        if (temp == null)
            return DefaultRes.res(StatusCode.NOT_FOUND, ResponseMessage.NOT_FOUND_USER);

        try {
            if (user.getName() != null)
                temp.setName(user.getName());
            if (user.getPart() != null)
                temp.setPart(user.getPart());

            userMapper.updateUser(userIdx, temp);

            return DefaultRes.res(StatusCode.NO_CONTENT, ResponseMessage.UPDATE_USER);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.error(e.getMessage());

            return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
        }
    }

    //회원 탈퇴
    @Transactional
    public DefaultRes deleteUser(final int userIdx) {
        final User user = userMapper.findByUserIdx(userIdx);

        if (user != null)
            return DefaultRes.res(StatusCode.NOT_FOUND, ResponseMessage.NOT_FOUND_USER);

        try {
            userMapper.deleteUser(userIdx);

            return DefaultRes.res(StatusCode.NO_CONTENT, ResponseMessage.DELETE_USER);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.error(e.getMessage());

            return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
        }
    }
}
