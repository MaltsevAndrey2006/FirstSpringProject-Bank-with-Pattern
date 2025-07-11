package andrey.dev.Controller.ControllerInterface;

import andrey.dev.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

import static andrey.dev.UserInterface.Constants.*;

@Service
public class AccountController implements Controller {
    private final Model model;
    private Scanner scanner;

    @Autowired
    public AccountController(Model model, Scanner scanner) {
        this.model = model;
        this.scanner = scanner;
    }

    public void createAccountWithController() {
        System.out.println(MESSAGE_TO_INPUT_USER_ID);
        try {
            model.getAccountService().createAccount(scanner.nextInt());
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(MASSAGE_ERROR_OF_WRONG_USER_ID);
        }
    }

    public void depositOnAccountWithController() {
        System.out.println(MESSAGE_TO_INPUT_ACCOUNT_ID);
        int accountId = scanner.nextInt();
        System.out.println(MESSAGE_TO_INPUT_COUNT_OF_MONEY_TO_DEPOSIT);
        model.getAccountService().depositOnAccount(accountId, scanner.nextInt());
    }

    public void withdrawFromAccountWithController() {
        System.out.println(MESSAGE_TO_INPUT_ACCOUNT_ID);
        int accountId = scanner.nextInt();
        System.out.println(MESSAGE_TO_INPUT_COUNT_OF_MONEY_TO_WITHDRAW);
        try {
            model.getAccountService().withdrawFromAccount(accountId, scanner.nextInt());
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.printf(FORM_FOR_NOT_ENOUGH_MONEY_ON_ACCOUNT_MASSAGE
                    , model.getAccountService().getAmountOfMoney(accountId));
        }
    }

    public void transferMoneyFromAccountToAccountWithController() {
        System.out.println(MASSAGE_TO_INPUT_ID_OF_SOURCE_ACCOUNT_FOR_TRANSFER);
        int sourceAccountId = scanner.nextInt();
        System.out.println(MASSAGE_TO_INPUT_IF_OF_RECIPIENT_ACCOUNT_FOR_TRANSFER);
        int recipientAccountId = scanner.nextInt();
        System.out.println(MASSAGE_TO_INPUT_COUNT_OF_MONEY_TO_TRANSFER);
        try {
            model.getAccountService().transferMoneyFromAccountToAccount(sourceAccountId, recipientAccountId, scanner.nextInt());
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.printf(FORM_FOR_NOT_ENOUGH_MONEY_ON_ACCOUNT_MASSAGE
                    , model.getAccountService().getAmountOfMoney(sourceAccountId));
        }
    }

    public void closeAccountWithController() {
        System.out.println(MESSAGE_TO_INPUT_USER_ID);
        int userId = scanner.nextInt();
        System.out.println(MESSAGE_TO_INPUT_ACCOUNT_ID);
        try {
            model.getAccountService().closeAccount(scanner.nextInt(), userId);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(MASSAGE_ERROR_OF_WRONG_USER_ID);
        }
    }


}
