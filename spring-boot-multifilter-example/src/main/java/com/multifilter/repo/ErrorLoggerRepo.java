package com.multifilter.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multifilter.entities.ErrorLoggerEntity;

@Repository
public interface ErrorLoggerRepo extends JpaRepository<ErrorLoggerEntity, Long> {

}
