package com.interstellarcarrental.carrental.repositories;

import java.util.List;

import com.interstellarcarrental.carrental.models.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
    Role findByRoleName(String roleName);
    Role findByRoleDescription(String roleDescription);

    List<Role> findRoleByUsersId(long userId);
}