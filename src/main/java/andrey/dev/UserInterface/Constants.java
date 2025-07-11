package andrey.dev.UserInterface;

public class Constants {
    //user
    public final static String FORM_FOR_USER_TO_STRING = "[userId:%s ,login: %s , accountList:%s ]\n";
    //AccountController
    public final static String FORM_FOR_ACCOUNT_TO_STRING = "[accountId:%s , userId: %s , moneyAmount:%s ]\n";
    public final static String MESSAGE_TO_INPUT_USER_ID = "Input user id :";
    public final static String MESSAGE_TO_INPUT_ACCOUNT_ID = "Input account id :";
    public final static String MESSAGE_TO_INPUT_COUNT_OF_MONEY_TO_DEPOSIT = "Input count of money to deposit:";
    public final static String MESSAGE_TO_INPUT_COUNT_OF_MONEY_TO_WITHDRAW = "Input count of money to withdraw:";
    public final static String FORM_FOR_NOT_ENOUGH_MONEY_ON_ACCOUNT_MASSAGE = "Not enough money on account , you have only :%s\n";
    public final static String MASSAGE_TO_INPUT_ID_OF_SOURCE_ACCOUNT_FOR_TRANSFER = "Input id of source account:";
    public final static String MASSAGE_TO_INPUT_IF_OF_RECIPIENT_ACCOUNT_FOR_TRANSFER = "Input id of recipient account ";
    public final static String MASSAGE_TO_INPUT_COUNT_OF_MONEY_TO_TRANSFER = "Input count of money to transfer";
    public final static String MASSAGE_ERROR_OF_WRONG_USER_ID = "Such user id don't exist";
    public final static String ERROR_NO_SUCH_ACCOUNT = "you haven't such account";
    public final static String ERROR_NO_ACCOUNTS_FOR_CLOSE = "You cant close this account ";
    //UserController
    public final static String MASSAGE_TO_INPUT_LOGIN_FOR_USER = "Input login for user:";
    public final static String MESSAGE_OF_ERROR_IN_USER_LOGIN = "Such login already exist";
    //ControllerService

    public static final String MASSAGE_OF_MENU = "USER_CREATE\n" +
            "SHOW_ALL_USERS\n" +
            "ACCOUNT_CREATE\n" +
            "ACCOUNT_CLOSE\n" +
            "ACCOUNT_TRANSFER\n" +
            "ACCOUNT_WITHDRAW \n" +
            "ACCOUNT_ADDER ";
    public static final String MASSAGE_TO_INPUT_COMMAND = "Chose command ";
    public static final String COMMAND_ERROR = "No such command";
}
