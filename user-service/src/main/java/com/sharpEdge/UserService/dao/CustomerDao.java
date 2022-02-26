package com.sharpEdge.UserService.dao;

import com.sharpEdge.UserService.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Long> {
    public Customer findByUsername(String user);
}
