package com.eroskoller.practicing.accounts.repository;

import com.eroskoller.practicing.accounts.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    Optional<CustomerEntity> findByEmail(String email);

    Optional<CustomerEntity> findByMobileNumber(String mobileNumber);
}
