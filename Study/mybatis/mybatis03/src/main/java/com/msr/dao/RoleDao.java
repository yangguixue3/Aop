package com.msr.dao;

import com.msr.domain.Role;

import java.util.List;

public interface RoleDao {

    /**
     * 查询所有的角色,同时查询角色的扮演者
     * @return
     */
    List<Role> findAll();
}
