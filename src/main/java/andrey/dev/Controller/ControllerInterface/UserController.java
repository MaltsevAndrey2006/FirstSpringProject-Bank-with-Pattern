package andrey.dev.Controller.ControllerInterface;

import andrey.dev.UserInterface.ConsoleListener.Commands;
import andrey.dev.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

import static andrey.dev.UserInterface.Constants.MASSAGE_TO_INPUT_LOGIN_FOR_USER;
import static andrey.dev.UserInterface.Constants.MESSAGE_OF_ERROR_IN_USER_LOGIN;

@Service
public class UserController implements Controller {
    private final Model model;
    private final Scanner scanner;

    @Autowired
    public UserController(Model model, Scanner scanner) {
        this.model = model;
        this.scanner = scanner;
    }

    public void createUserWithController() {
        System.out.println(MASSAGE_TO_INPUT_LOGIN_FOR_USER);
        try {
            model.getUserService().createUser(scanner.nextLine());
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(MESSAGE_OF_ERROR_IN_USER_LOGIN);
        }
    }

    public void showALLUsersWithController() {
        model.getUserService().showAllUsers();
    }

}
