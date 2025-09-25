package cohort_65.java.forumservice.accounting.service;

import cohort_65.java.forumservice.accounting.dao.AccountRepository;
import cohort_65.java.forumservice.accounting.dto.NewAccountDto;
import cohort_65.java.forumservice.accounting.dto.AccountDto;
import cohort_65.java.forumservice.accounting.dto.exception.LoginExistException;
import cohort_65.java.forumservice.accounting.model.Account;
import cohort_65.java.forumservice.post.dto.NewPostDto;
import cohort_65.java.forumservice.post.dto.PostDto;
import cohort_65.java.forumservice.post.model.Post;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;

    @Override
    public AccountDto addNewAccount(NewAccountDto newAccountDto) {
        Account existing = accountRepository.findByLogin(newAccountDto.getLogin());
        if (existing != null) {
            throw new LoginExistException();
        }
        Account account = new Account(
                newAccountDto.getLogin(),
                newAccountDto.getPassword(),
                newAccountDto.getFirstName(),
                newAccountDto.getLastName()
        );
        account = accountRepository.save(account);
        return modelMapper.map(account, AccountDto.class);
    }
}

