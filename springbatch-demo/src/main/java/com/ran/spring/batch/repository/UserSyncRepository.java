package com.ran.spring.batch.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ran.spring.batch.model.UserSync;

public interface UserSyncRepository extends JpaRepository<UserSync, Integer> {
	@Query(
			value = "SELECT us FROM UserSync us WHERE us.status=?1 OR us.status=?2",
			countQuery = "SELECT count(us) FROM UserSync us WHERE us.status=?1 OR us.status=?2",
			nativeQuery = false)
	Page<UserSync> findSyncByStatus(String status, String status1, Pageable pageable);
}
