package com.lovo.springBoot.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_user")//映射表面，默认就是类名
public class UserEntity {
    @Id
    @Column(name = "id",length = 32,insertable = false)//映射数据库的列
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 48,unique =true )
    private String userName;
    @Column(length = 48)
    private Integer password;
    @Column(length = 48)
    private Integer userAge;
    @Column(name = "date",columnDefinition = "TIMESTAMP")
    private String dateTime;
    @Column(columnDefinition = "TEXT")
    private String message;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
