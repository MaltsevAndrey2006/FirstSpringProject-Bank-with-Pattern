package andrey.dev.model.Account;

import andrey.dev.model.User.User;
import andrey.dev.model.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.NoSuchElementException;

@Service
public class AccountService {
    private final UserService userService;
    private int concurrentAccountId = 1;
    private HashMap<Integer, Account> mapAccount = new HashMap<>();
    @Value("${account.default-amount}")
    private int startMoneyAmount;
    @Value("${account.transfer-commission}")
    private double commissionForTransfer;

    @Autowired
    public AccountService(UserService userService) {
        this.userService = userService;
    }
    //после очередного фикса очередного метода, потому что там может выпасть NullPointerException я понял ,что
    //не стоило игнарировать идею возращать Optional ,а не Account
    public Account createAccount(int userId) {
        try {
            userService.searchUserByUserId(userId);
            Account account = new Account(concurrentAccountId, userId, startMoneyAmount);
            mapAccount.put(concurrentAccountId++, account);
            userService.searchUserByUserId(userId).addToAccountList(account);
            return account;
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException();
        }
    }

    public void depositOnAccount(int accountId, double count) {
        if (!mapAccount.containsKey(accountId)) {
            throw new NoSuchElementException();
        }
        mapAccount.get(accountId).addMoneyToMoneyAmount(count);
    }

    public void withdrawFromAccount(int accountId, double count) {
        if (mapAccount.isEmpty() || !mapAccount.containsKey(accountId)) {
            throw new NoSuchElementException();
        }
        if (count >= mapAccount.get(accountId).getMoneyAmount()) {
            mapAccount.get(accountId).DeleteMoneyFromMoneyAmount(count);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void transferMoneyFromAccountToAccount(int sourceId, int recipientID, double count) {
        if (mapAccount.size() == 0 || !mapAccount.containsKey(sourceId) || !mapAccount.containsKey(recipientID)) {
            throw new NoSuchElementException();
        }
        if (count >= mapAccount.get(sourceId).getMoneyAmount()) {
            withdrawFromAccount(sourceId, count);
            depositOnAccount(recipientID, (count * (1 - commissionForTransfer)));
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void closeAccount(int accountId, int userId) {
        if (!mapAccount.containsKey(accountId) || userService.searchUserByUserId(userId).getAccountList().size() == 1) {
            throw new NoSuchElementException();
        }
        try {
            userService.searchUserByUserId(userId).removeFromAccountantList(accountId);
            mapAccount.remove(accountId);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException();
        }
    }

    public int getAmountOfMoney(int userId) {
        return mapAccount.get(userId).getMoneyAmount();
    }


}
