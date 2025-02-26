package com.example.harel.repository;

import com.example.harel.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CustomersRepository extends JpaRepository<Customers,Integer> {

}
