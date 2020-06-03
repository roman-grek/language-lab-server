package com.languageschool.project.repository;

import java.util.Optional;

import com.languageschool.project.model.ERole;
import com.languageschool.project.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
