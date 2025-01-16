package com.eroskoller.practicing.accounts.repository;

import com.eroskoller.practicing.accounts.entity.AccountsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepository <AccountsEntity, Long> {
}
