package com.lovo.springBoot.dao;

import com.lovo.springBoot.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IUserDao extends CrudRepository<UserEntity,Integer> {
   @Query("from UserEntity where userName=?1 and password=?2")
    public UserEntity getUser(String userName,Integer password);
    @Query("from UserEntity")
    public List<UserEntity> getListUser();

}
