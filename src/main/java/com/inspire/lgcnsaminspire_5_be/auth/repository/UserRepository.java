package com.inspire.lgcnsaminspire_5_be.auth.repository;

import com.inspire.lgcnsaminspire_5_be.auth.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
