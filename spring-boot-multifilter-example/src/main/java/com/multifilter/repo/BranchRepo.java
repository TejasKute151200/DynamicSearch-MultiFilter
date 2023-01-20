package com.multifilter.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.multifilter.entities.BranchEntity;

@Repository
public interface BranchRepo extends JpaRepository<BranchEntity, Long> {

	@Query(value = "select * from branch", nativeQuery = true)
	List<BranchEntity> findAllAdmin();

}
