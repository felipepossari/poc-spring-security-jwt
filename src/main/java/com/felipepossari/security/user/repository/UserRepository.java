package com.felipepossari.security.user.repository;

import com.felipepossari.security.user.repository.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
