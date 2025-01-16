package com.eroskoller.practicing.accounts.service.impl;


import com.eroskoller.practicing.accounts.contants.AccountsConstants;
import com.eroskoller.practicing.accounts.dto.CustomerDto;
import com.eroskoller.practicing.accounts.entity.AccountsEntity;
import com.eroskoller.practicing.accounts.entity.CustomerEntity;
import com.eroskoller.practicing.accounts.mapper.CustomerMapper;
import com.eroskoller.practicing.accounts.repository.AccountsRepository;
import com.eroskoller.practicing.accounts.repository.CustomerRepository;
import com.eroskoller.practicing.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@AllArgsConstructor
@Slf4j
public class AccountsServiceImpl implements IAccountsService {


    private final CustomerRepository customerRepository;
    private final AccountsRepository accountsRepository;

    public void createAccount(CustomerDto customerDto) {
        CustomerEntity customerEntity = CustomerMapper.mapToCustomer(customerDto, CustomerEntity.builder().build());
        CustomerEntity customerSaved = this.customerRepository.save(customerEntity);

        AccountsEntity saved = this.accountsRepository.save(createNewAccount(customerSaved));
    }


    /**
     * @param customer - Customer Object
     * @return the new account details
     */
    private AccountsEntity createNewAccount(CustomerEntity customer) {
        AccountsEntity newAccount = new AccountsEntity();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        return newAccount;
    }

}
