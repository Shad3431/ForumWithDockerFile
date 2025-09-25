package cohort_65.java.forumservice.accounting.service;

import cohort_65.java.forumservice.accounting.dto.NewAccountDto;
import cohort_65.java.forumservice.accounting.dto.AccountDto;

public interface AccountService {
     AccountDto addNewAccount(NewAccountDto newAccountDto);

    AccountDto deleteAccountByLogin(String login);
}

