package com.eroskoller.practicing.cards.service;

import com.eroskoller.practicing.cards.dto.CustomerDto;

public interface IAccountsService {
    void createAccount(CustomerDto customerDto);
    CustomerDto fetchAccountDetails(String mobileNumber);
    boolean updateAccountDetails(CustomerDto customerDto);

    boolean deleteAccountDetails(String mobileNumber);
}
