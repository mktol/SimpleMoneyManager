package com.mtol.checker.repository;

import com.mtol.checker.entity.FamilyRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * This class
 */
@Repository
public interface FamilyRequestRepository extends CrudRepository<FamilyRequest, Long>{
}
