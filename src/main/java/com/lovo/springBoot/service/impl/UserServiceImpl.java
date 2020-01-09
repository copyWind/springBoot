package com.lovo.springBoot.service.impl;

import com.lovo.springBoot.dao.IUserDao;
import com.lovo.springBoot.entity.UserEntity;
import com.lovo.springBoot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "userService")
@Transactional
public class UserServiceImpl implements IUserService {
   @Autowired
   IUserDao userDao;

    @Override
    public UserEntity findUser(String userName, Integer password) {
        return userDao.getUser(userName,password);
    }

    @Override
    public List<UserEntity> findAll() {
        return userDao.getListUser();
    }

    @Override
    public UserEntity findUserById(Integer id) {
        return userDao.findById(id).get();
    }

    @Override
    public void saveUser(UserEntity user) {
        userDao.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userDao.deleteById(id);
    }
}
