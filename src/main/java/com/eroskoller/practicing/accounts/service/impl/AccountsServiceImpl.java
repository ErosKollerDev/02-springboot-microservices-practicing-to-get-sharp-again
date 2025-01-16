package com.eroskoller.practicing.accounts.service.impl;


import com.eroskoller.practicing.accounts.contants.AccountsConstants;
import com.eroskoller.practicing.accounts.dto.AccountsDto;
import com.eroskoller.practicing.accounts.dto.CustomerDto;
import com.eroskoller.practicing.accounts.entity.AccountsEntity;
import com.eroskoller.practicing.accounts.entity.CustomerEntity;
import com.eroskoller.practicing.accounts.exception.CustomerAlreadyExistsException;
import com.eroskoller.practicing.accounts.exception.ResourceNotFoundException;
import com.eroskoller.practicing.accounts.mapper.AccountsMapper;
import com.eroskoller.practicing.accounts.mapper.CustomerMapper;
import com.eroskoller.practicing.accounts.repository.AccountsRepository;
import com.eroskoller.practicing.accounts.repository.CustomerRepository;
import com.eroskoller.practicing.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
@Slf4j
public class AccountsServiceImpl implements IAccountsService {


    private final CustomerRepository customerRepository;
    private final AccountsRepository accountsRepository;

    public void createAccount(CustomerDto customerDto) {


        Optional<CustomerEntity> customerRepositoryByEmail = this.customerRepository.findByEmail(customerDto.getEmail());

        if (customerRepositoryByEmail.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer already exists, mobile number already exists : " + customerDto.getMobileNumber());
        }
        CustomerEntity customerEntity = CustomerMapper.mapToCustomer(customerDto, CustomerEntity.builder().build());
//        customerEntity.setCreatedAt(LocalDateTime.now());
//        customerEntity.setCreatedBy("Anonymous");
        CustomerEntity customerSaved = this.customerRepository.save(customerEntity);

        AccountsEntity saved = this.accountsRepository.save(createNewAccount(customerSaved));
    }

    @Override
    public CustomerDto fetchAccountDetails(String mobileNumber) {
        CustomerEntity customer =
                this.customerRepository
                        .findByMobileNumber(mobileNumber)
                        .orElseThrow(() -> new ResourceNotFoundException("Customer not found with mobile number : " + mobileNumber, "mobileNumber", mobileNumber));

        AccountsEntity accountsEntity = this.accountsRepository
                .findByCustomerId(customer
                        .getCustomerId()).orElseThrow(() -> new ResourceNotFoundException("Account not found", "customerId", customer.getCustomerId().toString()));

        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer, new CustomerDto());
        AccountsDto accountsDto = AccountsMapper.mapToAccountsDto(accountsEntity, new AccountsDto());
        customerDto.setAccount(accountsDto);
        return customerDto;
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
//        newAccount.setCreatedAt(LocalDateTime.now());
//        newAccount.setCreatedBy("Anonymous");
        return newAccount;
    }

    @Override
    public boolean updateAccountDetails(CustomerDto customerDto) {
        boolean isUpdated = false;
        AccountsDto accountDto = customerDto.getAccount();
        if (accountDto != null) {
            AccountsEntity accountsEntity = this.accountsRepository
                    .findByAccountNumber(accountDto.getAccountNumber())
                    .orElseThrow(() -> new ResourceNotFoundException("Account", "accountNumber", accountDto.getAccountNumber().toString()));

            AccountsMapper.mapToAccounts(accountDto, accountsEntity);
            this.accountsRepository.save(accountsEntity);

            Long customerId = accountsEntity.getCustomerId();
            CustomerEntity customerEntity = this.customerRepository
                    .findById(customerId)
                    .orElseThrow(() -> new ResourceNotFoundException("Customer", "customerId", customerId.toString()));
            CustomerMapper.mapToCustomer(customerDto, customerEntity);
            CustomerEntity save = this.customerRepository.save(customerEntity);
            isUpdated = true;
        }
        return isUpdated;
    }

    @Override
    public boolean deleteAccountDetails(String mobileNumber) {
        CustomerEntity customerEntity = this.customerRepository
                .findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));
            this.customerRepository.delete(customerEntity);
            this.accountsRepository.deleteByCustomerId(customerEntity.getCustomerId());
        return true;
    }
}
