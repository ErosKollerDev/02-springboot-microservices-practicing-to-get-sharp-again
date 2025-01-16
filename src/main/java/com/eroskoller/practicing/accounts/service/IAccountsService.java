package com.eroskoller.practicing.accounts.service;

import com.eroskoller.practicing.accounts.dto.AccountsDto;
import com.eroskoller.practicing.accounts.dto.CustomerDto;

public interface IAccountsService {
    void createAccount(CustomerDto customerDto);
    CustomerDto fetchAccountDetails(String mobileNumber);
    boolean updateAccountDetails(CustomerDto customerDto);

    boolean deleteAccountDetails(String mobileNumber);
}
