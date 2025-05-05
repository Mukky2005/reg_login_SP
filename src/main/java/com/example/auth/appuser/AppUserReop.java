package com.example.auth.appuser;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Repository
@Transactional(readOnly = true)
public interface AppUserReop {
    Optional<AppUser> findByEmail(String email);
}
