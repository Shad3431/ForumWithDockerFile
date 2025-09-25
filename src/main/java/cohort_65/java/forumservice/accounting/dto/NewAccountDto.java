package cohort_65.java.forumservice.accounting.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class NewAccountDto {
    String login;
    String password;
    String firstName;
    String lastName;
}