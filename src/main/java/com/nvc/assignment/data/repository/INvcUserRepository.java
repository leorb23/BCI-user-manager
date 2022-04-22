package com.nvc.assignment.data.repository;

import com.nvc.assignment.data.dao.NvcUserDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface INvcUserRepository extends JpaRepository<NvcUserDao, Long> {

    List<NvcUserDao> findAll();

    NvcUserDao findByEmail(String email);

}
