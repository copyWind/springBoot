package com.lovo.springBoot.service;

import com.lovo.springBoot.entity.UserEntity;

import java.util.List;

public interface IUserService {

    public UserEntity findUser(String userName,Integer password);

    public List<UserEntity> findAll();

    public UserEntity findUserById(Integer id);

    public void saveUser(UserEntity user);

    public void deleteUser(Integer id);
}
