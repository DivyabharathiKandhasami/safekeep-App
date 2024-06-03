package com.userportal.safekeep.repo;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.userportal.safekeep.entity.AppEntity;

@Repository
public interface AppRepo extends JpaRepository<AppEntity, Long> {
	AppEntity findByUsername(String username);

	// @Modifying
	// @Query("UPDATE AppEntity a SET a.expired_time = :expiryTime WHERE a.id =
	// :id")
	// void updateOtpExpiryTime(@Param("id") Long id, @Param("expiryTime")
	// LocalDateTime expiryTime);

	// void updateOtpExpiryTime(Long id, LocalDateTime expiryTime);

	// LocalDateTime now = LocalDateTime.now();
	// LocalDateTime expiryTime = now.plusMinutes(8);

	@Modifying
	@Query("UPDATE AppEntity a SET a.expired_time = :expiryTime WHERE a.id = :id")
	void updateOtpExpiryTime(@Param("id") Long id, @Param("expiryTime") LocalDateTime expiryTime);

}
