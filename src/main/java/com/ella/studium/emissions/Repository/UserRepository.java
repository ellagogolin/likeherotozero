package com.ella.studium.emissions.Repository;

import com.ella.studium.emissions.Entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    public User findByUsername(String username);
}
