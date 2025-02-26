package com.example.harel.repository;

import com.example.harel.entity.Policies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PoliciesRepository extends JpaRepository<Policies,Integer> {
    Optional<Policies> findByPolicyNumber(String policyNumber);

}
