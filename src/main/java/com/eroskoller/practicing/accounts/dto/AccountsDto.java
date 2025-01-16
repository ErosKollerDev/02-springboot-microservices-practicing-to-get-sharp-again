package com.eroskoller.practicing.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        name = "AccountsDto",
        description = "Schema Accounts to hold all details about the account"
)
public class AccountsDto {


    @Schema(
            description = "Account id is auto generated by the database",
            example = "123456789"
    )
    @NotEmpty(message = "Account number cannot be empty")
    @Pattern(regexp = "(^$[0-9]{9,10}$)", message = "Account number must be numeric")
    private Long accountNumber;

    @Schema(
            description = "SAVINGS or CURRENT",
            example = "SAVINGS"
    )
    @NotEmpty(message = "Account type cannot be empty")
    private String accountType;

    @Schema(
            description = "Address",
            example = "123 Main Street, New York"
    )
    @NotEmpty(message = "Branch address cannot be empty")
    private String branchAddress;

}
