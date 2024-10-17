package com.project.staragile.banking.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.staragile.banking.controller.AccountController;
import com.project.staragile.banking.model.Account;
import com.project.staragile.banking.service.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AccountController.class)
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private AccountService accountService;

    @InjectMocks
    private AccountController accountController;

    private Account account;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        account = new Account();
        account.setAccountHolderName("Test User");
        account.setBalance(1500.0);
    }

    @Test
    public void createAccountTest() throws Exception {
        when(accountService.createAccount(any(Account.class))).thenReturn(account);

        mockMvc.perform(post("/api/accounts/createAccount")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(account)))
                .andExpect(status().isOk());
    }

    @Test
    public void updateAccountTest() throws Exception {
        when(accountService.updateAccount(any(Long.class), any(Account.class))).thenReturn(account);

        mockMvc.perform(put("/api/accounts/updateAccount/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(account)))
                .andExpect(status().isOk());
    }

    @Test
    public void viewPolicyTest() throws Exception {
        when(accountService.viewAccount(any(Long.class))).thenReturn(java.util.Optional.of(account));

        mockMvc.perform(get("/api/accounts/viewPolicy/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void deletePolicyTest() throws Exception {
        mockMvc.perform(delete("/api/accounts/deletePolicy/1"))
                .andExpect(status().isNoContent());
    }
}
