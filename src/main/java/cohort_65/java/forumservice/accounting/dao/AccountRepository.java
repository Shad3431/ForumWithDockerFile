package cohort_65.java.forumservice.accounting.dao;

import cohort_65.java.forumservice.accounting.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.Set;

public interface AccountRepository extends MongoRepository<Account, String> {

    Account save(Account account);
    Account findByLogin(String login);
}
