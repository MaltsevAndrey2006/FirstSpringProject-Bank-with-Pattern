package andrey.dev.Controller;

import andrey.dev.Controller.ControllerInterface.AccountController;
import andrey.dev.Controller.ControllerInterface.UserController;
import andrey.dev.UserInterface.ConsoleListener.Commands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

import static andrey.dev.UserInterface.Constants.*;

@Service
public class ControllerService {
    private final AccountController accountController;
    private final UserController userController;
    private final Scanner scanner;

    @Autowired
    public ControllerService(AccountController accountController, UserController userController, Scanner scanner) {
        this.accountController = accountController;
        this.userController = userController;
        this.scanner = scanner;
    }

    public void menu() {
        System.out.println(MASSAGE_OF_MENU);
        System.out.println(MASSAGE_TO_INPUT_COMMAND);
        Commands command;
        try {
             command = Commands.valueOf(scanner.nextLine());
        } catch (IllegalArgumentException illegalArgumentException) {
            command=Commands.ERROR;
            System.out.println(COMMAND_ERROR);
        }
        switch (command){
            case USER_CREATE ->userController.createUserWithController() ;
            case ACCOUNT_CLOSE -> accountController.closeAccountWithController();
            case ACCOUNT_CREATE -> accountController.createAccountWithController();
            case SHOW_ALL_USERS -> userController.showALLUsersWithController();
            case ACCOUNT_TRANSFER -> accountController.transferMoneyFromAccountToAccountWithController();
            case ACCOUNT_WITHDRAW -> accountController.withdrawFromAccountWithController();
            case ACCOUNT_ADDER -> accountController.depositOnAccountWithController();
            default -> System.out.println(COMMAND_ERROR);
        }
    }

}
