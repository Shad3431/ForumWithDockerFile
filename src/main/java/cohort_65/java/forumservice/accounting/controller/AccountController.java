package cohort_65.java.forumservice.accounting.controller;

import cohort_65.java.forumservice.accounting.dto.NewAccountDto;
import cohort_65.java.forumservice.accounting.dto.AccountDto;
import cohort_65.java.forumservice.accounting.service.AccountService;
import cohort_65.java.forumservice.post.dto.PostDto;
import cohort_65.java.forumservice.post.dto.exception.PostNotFoundException;
import cohort_65.java.forumservice.post.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/register")
    public AccountDto register(@RequestBody NewAccountDto newAccountDto) {
        return accountService.addNewAccount(newAccountDto);
    }
    @DeleteMapping("/user/{login}")
    public AccountDto deleteUser(@PathVariable String login) {
        return accountService.deleteAccountByLogin(login);
    }



}
