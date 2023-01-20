package com.multifilter.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.multifilter.entities.DesignationEntity;

@Repository
public interface DesignationRepo extends JpaRepository<DesignationEntity, Long> {

	@Query(value = "Select * from designation", nativeQuery = true)
	List<DesignationEntity> findAllAdmin();

}
