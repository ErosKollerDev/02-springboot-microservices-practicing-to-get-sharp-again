package com.eroskoller.practicing.accounts.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Schema(
        name = "ErrorResponseDto",
        description = "Schema ErrorResponseDto "
)
public class ErrorResponseDto {


    @Schema(
            description = "apiPath",
            example = "api/v1/accounts"
    )
    private String apiPath;
    @Schema(
            description = "errorCode",
            example = "500"
    )
    private HttpStatus errorCode;
    @Schema(
            description = "errorMessage",
            example = "Internal Server Error"
    )
    private String errorMessage;
    @Schema(
            description = "errorTime",
            example = "2023-06-05T10:00:00"
    )
    private LocalDateTime errorTime;
}
