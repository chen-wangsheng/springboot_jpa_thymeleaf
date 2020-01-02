package com.offcn.dao;

import com.offcn.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 陈旺生
 * @create 2019-12-31 20:45
 */
public interface UserDao extends JpaRepository<User,Long> {
    public User findByNameIs(String name);
    public User findByNameAndAge(String name,Integer age);
}
