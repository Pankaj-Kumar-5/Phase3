package com.Repo;

import com.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyRepo extends CrudRepository<User,Integer> {

    public User findByEmail(String Email);
    public User findByPhone(String phone);
    public List<User> findByEmailOrNameOrPhone(String email,String name,String phone);
}
