package com.wansan.mybatis.dao;

import java.util.List;

import com.wansan.mybatis.vo.User;
public interface UseDao {
public User findById(int id);
public List<User>findByIdMsg(String name);
public void add(User user);
public void update(User user);
public void delete(int id);
public List getUserArticles(int id);
}
