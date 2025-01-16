package com.eroskoller.practicing.accounts.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor @Builder
@Table(name = "accounts")
public class AccountsEntity extends BaseEntity   {

    @Id
    @Column(name="account_number")
    private Long accountNumber;

    @Column(name="customer_id")
    private Long customerId;

    @Column(name="account_type")
    private String accountType;

    @Column(name="branch_address")
    private String branchAddress;



}
