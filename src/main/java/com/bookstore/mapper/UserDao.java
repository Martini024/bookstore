package com.bookstore.mapper;

import com.bookstore.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {

    @Select("SELECT * FROM users")
    List<User> findAllUsers();

    @Select("SELECT * FROM users WHERE id = #{id}")
    User findUserById(@Param("id") String id);

    @Insert("INSERT INTO users (id, name) VALUES (#{id}, #{name})")
    void createUser(@Param("id") String id, @Param("name") String name);

    @Delete("DELETE FROM users WHERE id = #{id}")
    void deleteUser(@Param("id") String id);

    @Update("UPDATE users SET name = #{name} WHERE id = #{id}")
    void updateUser(@Param("id") String id, @Param("name") String name);
}