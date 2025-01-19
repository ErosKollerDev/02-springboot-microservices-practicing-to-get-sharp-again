package com.eroskoller.practicing.cards.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Schema(
    name = "CustomerDto",
    description = "Schema Customer details to hold Customer and Account details"
)
public class CustomerDto {


    @Schema(
            description = "Customer name",
            example = "John Doe"
    )
    @Size(min = 3, max = 90, message = "Name must be between 3 and 90 characters")
    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @Schema(
            description = "Customer email",
            example = "johndoe@gmail.com"
    )
    @Email(message = "Invalid email address")
    @NotEmpty(message = "Email cannot be empty")
    private String email;

    @Schema(
            description = "Customer mobile number",
            example = "11962861001"
    )
    @NotEmpty(message = "Mobile number cannot be empty")
    @Size(min = 10, max = 12, message = "Mobile number must be between 10 and 12 characters")
//    @Pattern(regexp = "($[0-9]{10,12}$)", message = "Mobile number must be numeric")
    @Pattern(regexp = "(^$|[0-9]{10,12})", message = "Mobile number must be 10 digits")
    private String mobileNumber;


    private AccountsDto account;
}
