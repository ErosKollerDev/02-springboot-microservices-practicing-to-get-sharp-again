package com.eroskoller.practicing.accounts.service;

import com.eroskoller.practicing.accounts.dto.AccountsDto;
import com.eroskoller.practicing.accounts.dto.CustomerDto;

public interface IAccountsService {
    void createAccount(CustomerDto customerDto);
}
