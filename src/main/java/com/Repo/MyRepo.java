package com.Repo;

import com.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyRepo extends CrudRepository<User,String> {

    public User findByEmail(String Email);
}
