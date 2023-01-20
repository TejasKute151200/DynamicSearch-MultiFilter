package com.multifilter.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.multifilter.entities.DepartmentEntity;

@Repository
public interface DepartmentRepo extends JpaRepository<DepartmentEntity, Long> {

	@Query(value = "SELECT * From department", nativeQuery = true)
	List<DepartmentEntity> findAllAdmin();

}
