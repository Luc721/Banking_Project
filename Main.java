package INFO;
import EXCEPTIONS.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

class Main {

    public static void main(String[] args) throws AccountNotFound, PinNotFound, InsufficientFunds {
        Service service = new Service();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("Select among the following options");
            System.out.println("1: Create a new Account");
            System.out.println("2: Update Balance");
            System.out.println("3: Withdraw money");
            System.out.println("4: Get account Details");
            System.out.println("5: Get all previous transactions");
            System.out.println("6: Transfer funds to another account");
            System.out.println("7: Pin Change");
            System.out.println("8: Delete Account");
            System.out.println("9: Show all accounts");
            System.out.println("10: Exit");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("You have selected : Create a new Account");
                    System.out.println("Please enter Account Holder Name");
                    sc.nextLine();
                    String AccountHolderName = sc.nextLine();
                    System.out.println("Please enter Account Number");
                    int accountNumber = sc.nextInt();
                    System.out.println("Please enter Starting Balance");
                    int startingBalance = sc.nextInt();
                    System.out.println("Please enter Account Pin");
                    int pin = sc.nextInt();
                    Account account = new Account(AccountHolderName, accountNumber, startingBalance, pin);
                    service.createAccount(account);
                    break;

                case 2:
                    System.out.println("Please enter your Account Number");
                    int accountNumber1 = sc.nextInt();
                    service.checkAccountExist(accountNumber1);
                    System.out.println("Please enter your pin");
                    int pin1 = sc.nextInt();
                    service.checkPin(accountNumber1, pin1);

                    System.out.println("Enter amount to be deposited");
                    int deposit = sc.nextInt();
                    int total = service.depositAmount(accountNumber1, deposit);
                    System.out.println("Your updated balance is Rs." + total);
                    break;

                case 3:
                    System.out.println("Please enter your Account Number");
                    int accountNumber2 = sc.nextInt();
                    service.checkAccountExist(accountNumber2);
                    System.out.println("Please enter your pin");
                    int pin2 = sc.nextInt();
                    service.checkPin(accountNumber2, pin2);
                    System.out.println("Please enter the amount to be withdrawn");
                    int withraw = sc.nextInt();
                    int check_withraw = service.withdraw(accountNumber2, withraw);
                    System.out.println("Amount available in your account is Rs." + check_withraw);

                    break;


                case 4:
                    System.out.println("Please enter your Account Number");
                    int accountNumber3 = sc.nextInt();
                    service.checkAccountExist(accountNumber3);
                    System.out.println("Please enter your pin");
                    int pin3 = sc.nextInt();
                    service.checkPin(accountNumber3, pin3);
                    Account ref = service.getDetails(accountNumber3);
                    System.out.println("The account Holder name is: " + ref.getAccountHolderName());
                    System.out.println("The cuurent balance in your account is Rs." + ref.getCurrentBalance());
                    break;


                case 5:
                    System.out.println("Please enter your Account Number");
                    int accountNumber4 = sc.nextInt();
                    service.checkAccountExist(accountNumber4);
                    System.out.println("Please enter your pin");
                    int pin4 = sc.nextInt();
                    service.checkPin(accountNumber4, pin4);
                    ArrayList<Integer> al = service.getAllTransaction(accountNumber4);
                    for (Integer integer : al) {
                        System.out.println(integer);
                    }
                    break;


                case 6:
                    System.out.println("Enter the sender's account number");
                    int accountNumber_sender = sc.nextInt();
                    service.checkAccountExist(accountNumber_sender);
                    System.out.println("Enter the sender's account pin");
                    int accountPin_sender = sc.nextInt();
                    service.checkPin(accountNumber_sender, accountPin_sender);
                    System.out.println("Enter the receiver's account number");
                    int accountNumber_receiver = sc.nextInt();
                    service.checkAccountExist(accountNumber_receiver);
                    System.out.println("Enter the amount to be transferred");
                    int transfer = sc.nextInt();
                    int balance = service.transferFunds(accountNumber_sender, accountNumber_receiver, transfer, service);
                    System.out.println("Transfer successful,Amount left in your account is Rs." + balance);
                    break;

                case 7:
                    System.out.println("Please enter your Account Number");
                    int accountNumber5 = sc.nextInt();
                    service.checkAccountExist(accountNumber5);
                    System.out.println("Please enter your  previous pin");
                    int pin5 = sc.nextInt();
                    service.checkPin(accountNumber5, pin5);
                    System.out.println("Please enter your new pin");
                    int newpin = sc.nextInt();
                    service.changePin(accountNumber5, newpin);
                    System.out.println("Your pin has been successfully updated");
                    break;

                case 8:
                    System.out.println("Please enter your Account Number");
                    int accountNumber6 = sc.nextInt();
                    service.checkAccountExist(accountNumber6);
                    System.out.println("Please enter your pin");
                    int pin6 = sc.nextInt();
                    service.checkPin(accountNumber6, pin6);
                    service.deleteAccount(accountNumber6);
                    System.out.println("Your account has been successfully deleted");
                    break;

                case 9:
                    for (Map.Entry<Integer, Account> accountEntry : service.showAllAccounts().entrySet()) {
                        System.out.println("Account number : " + accountEntry.getValue().getAccountNumber());
                        System.out.println("Account holder name : " + accountEntry.getValue().getAccountHolderName());
                        System.out.println("Account balance : " + accountEntry.getValue().getCurrentBalance());

                    }
                    break;
                case 10:
                    flag = false;
                    break;

                default:
                    System.out.println("Please select a valid option");
                    break;

            }


        }
    }
}
