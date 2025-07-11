package andrey.dev.model;

import andrey.dev.model.Account.AccountService;
import andrey.dev.model.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Model {
    private final UserService userService ;
    private final AccountService accountService ;

    @Autowired
    public Model(UserService userService, AccountService accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    public UserService getUserService() {
        return userService;
    }

    public AccountService getAccountService() {
        return accountService;
    }
}
