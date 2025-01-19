package com.eroskoller.practicing.cards.repository;

import com.eroskoller.practicing.cards.entity.AccountsEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import jakarta.transaction.Transactional;

import java.util.Optional;

@Repository
public interface AccountsRepository extends JpaRepository <AccountsEntity, Long> {

    Optional<AccountsEntity> findByAccountNumber(Long accountNumber);
    Optional<AccountsEntity> findByCustomerId(Long customerId);

    @Transactional
    @Modifying
    void deleteByCustomerId(Long customerId);
}
