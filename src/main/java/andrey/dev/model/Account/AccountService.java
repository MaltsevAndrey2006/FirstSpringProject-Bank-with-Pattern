package andrey.dev.model.Account;

import andrey.dev.model.User.User;
import andrey.dev.model.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;

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

    public Account createAccount(int userId ) {
        try{
            userService.searchUserByUserId(userId);
            Account account = new Account(concurrentAccountId, userId, startMoneyAmount);
            mapAccount.put(concurrentAccountId++,account);
            userService.searchUserByUserId(userId).addToAccountList(account);
            return account;
        } catch (IllegalArgumentException illegalArgumentException){
            throw new  IllegalArgumentException() ;
        }
    }

    public void depositOnAccount(int accountId, double count) {
        mapAccount.get(accountId).addMoneyToMoneyAmount(count);
    }

    public void withdrawFromAccount(int accountId, double count) {
        if (count >= mapAccount.get(accountId).getMoneyAmount()) {
            mapAccount.get(accountId).DeleteMoneyFromMoneyAmount(count);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void transferMoneyFromAccountToAccount(int sourceId, int recipientID, double count) {
        if (count >= mapAccount.get(sourceId).getMoneyAmount()) {
            withdrawFromAccount(sourceId, count);
            depositOnAccount(recipientID, (count * (1 - commissionForTransfer)));
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void closeAccount(int accountId, int userId) {
        try{
            userService.searchUserByUserId(userId).removeFromAccountantList(accountId);
            mapAccount.remove(accountId);
        } catch (IllegalArgumentException illegalArgumentException){
            throw  new IllegalArgumentException();
        }
    }

    public int getAmountOfMoney(int userId) {
        return mapAccount.get(userId).getMoneyAmount();
    }


}
