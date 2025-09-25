package cohort_65.java.forumservice.accounting.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Account {
    private String id;

    private String login;

    private String password;

    private String firstName;

    private String lastName;

    public Account(String login, String password, String firstName, String lastName) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

