package andrey.dev.model.Account;

import static andrey.dev.UserInterface.Constants.FORM_FOR_ACCOUNT_TO_STRING;

public class Account {
    private final int accountId;
    private final int userId;
    private int moneyAmount;

    public Account(int accountId, int userId, int moneyAmount) {
        this.accountId = accountId;
        this.userId = userId;
        this.moneyAmount = moneyAmount;
    }

    public int getAccountId() {
        return accountId;
    }

    public int getUserId() {
        return userId;
    }

    public int getMoneyAmount() {
        return moneyAmount;
    }

    public void addMoneyToMoneyAmount(double count) {
        moneyAmount += count;
    }

    public void DeleteMoneyFromMoneyAmount(double count) {
        moneyAmount -= count;
    }

    @Override
    public String toString() {
        return String.format(FORM_FOR_ACCOUNT_TO_STRING, accountId, userId, moneyAmount);
    }
}
