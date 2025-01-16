package com.eroskoller.practicing.accounts.controller;


import com.eroskoller.practicing.accounts.contants.AccountsConstants;
import com.eroskoller.practicing.accounts.dto.AccountsDto;
import com.eroskoller.practicing.accounts.dto.ResponseDto;
import com.eroskoller.practicing.accounts.service.impl.AccountsServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Slf4j
public class AccountsController {


    private final AccountsServiceImpl accountsService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccounts(@RequestBody AccountsDto accountsDto) {
        this.accountsService.createAccount(accountsDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
    }


    @GetMapping("say-hello")
    public ResponseEntity<String> getAccounts() {
        return ResponseEntity.ok("Accounts");
    }

}
