package com.hanmz.wechat.service;

import com.hanmz.wechat.entity.User;
import com.hanmz.wechat.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hanmz on 2016/8/4.
 */
@Service
public class UserService {
  @Autowired
  UserMapper userMapper;

  User findById(long id) {
    return userMapper.findById(id);
  }

  void insert(User user) {
    userMapper.insert(user);
  }
}
