package com.multifilter.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.multifilter.entities.EmployeeEntity;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Long> {

	@Query(value = "select * from employee e " + "	where e.department_id in :departmentId"
			+ " and e.branch_id in :branchId" + "	and e.designation_id in :designationId", nativeQuery = true)
	List<EmployeeEntity> findByDepartmentIdAndBranchIdAndDesignationId(
			@Param("departmentId") List<Integer> departmentId, @Param("branchId") List<Integer> branchId,
			@Param("designationId") List<Integer> designationId);

	@Query(value = "SELECT * FROM Employee e " + "WHERE e.employee_name LIKE %:search% " + "OR e.email LIKE %:search% "
			+ "OR e.address LIKE %:search% " + "OR e.mobile LIKE %:search% " + "OR e.salary LIKE %:search% "
			+ "OR e.pincode LIKE %:search% "
//		        + " OR e.deparment_id in :departmentId LIKE %:search% "
//		        + " OR e.designation_id in :designationId LIKE %:search% "
//		        + " OR e.branch_id in :branchId LIKE %:search% " 
			, nativeQuery = true)
	List<EmployeeEntity> findBySearch(@Param("search") String search);

	@Query(value = "SELECT * FROM employee", nativeQuery = true)
	List<EmployeeEntity> findAllAdmin();

	/* Ignore Below Things */

//	@Query(	value = "select * from employee e "
//				+ "	where e.department_id in :departmentId"
//				+ " and e.branch_id in :branchId"
//				+ "	and e.designation_id in :designationId", 
//				nativeQuery = true	)
//	List<EmployeeEntity> findBySorted(
//				@Param("departmentId") List<Integer> departmentId,
//				@Param("branchId") List<Integer> branchId,
//				@Param("designationId") List<Integer> designationId);

//		@Query(	value = "select * from employee e "
//				+ "	where(:branchId IS NULL OR e.branch_id in :branchId) "
//				+ "AND (:designationId IS NULL OR e.designation_id in :designationId) "
//				+ "AND (:departmentId IS NULL OR e.department_id in :departmentId) "
//				+ " e.employee_name LIKE %:search% "
//				+ " OR e.email LIKE %:search% "
//				+ " OR e.address LIKE %:search% "
//				+ " OR e.mobile LIKE %:search% "
//				+ " OR e.salary LIKE %:search% ", 
//				nativeQuery = true	)	
//		List<EmployeeEntity> findBySearch(
//				@Param("search") String search,
//				@Param("departmentId") List<Integer> departmentId,
//				@Param("branchId") List<Integer> branchId,
//				@Param("designationId") List<Integer> designationId);

}
