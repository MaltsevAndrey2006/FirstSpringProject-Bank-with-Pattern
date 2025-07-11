package andrey.dev.model.User;

import andrey.dev.model.Account.Account;

import java.util.HashMap;

import static andrey.dev.UserInterface.Constants.FORM_FOR_USER_TO_STRING;

public class User {
    private final int userId;
    private final String login;
    private int accountId = 1;
    private HashMap<Integer, Account> accountList = new HashMap<>();

    public User(int userId, String login) {
        this.userId = userId;
        this.login = login;
    }

    public int getUserId() {
        return userId;
    }

    public String getLogin() {
        return login;
    }

    public HashMap<Integer, Account> getAccountList() {
        return accountList;
    }

    public void addToAccountList(Account account) {
        accountList.put(accountId++, account);
    }

    public void removeFromAccountantList(int accountId) {
        accountList.remove(accountId);
    }

    @Override
    public String toString() {
        return String.format(FORM_FOR_USER_TO_STRING, userId, login, accountList);
    }
}
