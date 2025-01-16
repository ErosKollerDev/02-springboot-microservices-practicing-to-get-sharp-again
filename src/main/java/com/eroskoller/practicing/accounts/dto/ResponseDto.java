package com.eroskoller.practicing.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        name = "ResponseDto",
        description = "Schema Response "
)
public class ResponseDto {

    @Schema(
            description = "Status Code",
            example = "200"
    )
    private String statusCode;
    @Schema(
            description = "Status Message",
            example = "OK"
    )
    private String statusMsg;


}
