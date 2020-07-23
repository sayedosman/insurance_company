package com.example.demo.Repository;

import java.util.Optional;

import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Admin;
import com.example.demo.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public User findByUsername(String username);
}
