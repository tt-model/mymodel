package com.application.v1.daos;

import com.application.v1.orms.Dept;
import com.application.v1.repositorys.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptDao extends JpaRepository<Dept, Long>, BaseRepository<Dept, Long> {

}
