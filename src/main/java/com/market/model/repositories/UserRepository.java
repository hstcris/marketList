package com.market.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.market.model.entity.user.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmailIgnoreCaseAndTenantId(String email, String tenantId);
}
