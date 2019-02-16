import java.util.List;
import java.util.Scanner;

public class Menu {

        Scanner keubord =new Scanner(System.in);

        Bank bank =new Bank();

    public static void main(String[] args) {
  Menu menu= new Menu();
  menu.runMenu();
    }

    public  void  runMenu(){
        printHeader();
        boolean exit=false;
        int choise=0;

                 clerkOrKlient();

        while (!exit){
        choise =getInput();
        performAction(choise);
        printClerkMenu();
         }

    }

    private void performAction(int choise) {
        switch (choise){
             case 1: createANewUserAccount(); break;
             case 2: makeADeposit(); break;
            case 3: makeAWithdrawal(); break;
            case 4: listAccount(); break;
            case 5: transferFromTo(); break;
            case 0: exit(); break;
        }
    }

    private void transferFromTo() {
         double amount =0;
         System.out.println("Who are You?");
         int hoGiveTheMoney =findTheNecesaryUser();
         int hoRecivedTheMoney=-1;
         double balanse=bank.users.get(hoGiveTheMoney).getAccount().getBalanse();
         System.out.println("Please provide how much would you like a transfer");
        try {
             amount = Double.parseDouble(keubord.nextLine());
             if(balanse >=amount){
                 System.out.println("who should receive the money?");
                      hoRecivedTheMoney = findTheNecesaryUser();
                  if (hoGiveTheMoney >=0){
                      bank.users.get(hoGiveTheMoney).getAccount().witchdrawal(amount);
                      bank.users.get(hoRecivedTheMoney).getAccount().deposit(amount);
                  }
             }
            System.out.println("You don't have so much money");

        }catch (NumberFormatException e){
            System.out.println(" Must be just numbers");
        }




    }

    private void makeAWithdrawal() {
        System.out.println("How much would you like a withdrawal ");
        try {
            double amount = Double.parseDouble(keubord.nextLine());
            bank.users.get(findTheNecesaryUser()).getAccount().witchdrawal(amount);
        }catch (NumberFormatException e){
            System.out.println(" Must be just numbers");
        }

    }


    private void makeADeposit() {
        System.out.println("How much would you like to deposit?:");
        try{
        Double amount = Double.parseDouble(keubord.nextLine());
        bank.users.get(findTheNecesaryUser()).getAccount().deposit(amount);
            System.out.println("Your account was deposit on "+amount);
        }catch (NumberFormatException e){
        System.out.println(" Must be just numbers");
        }


    }

    private int findTheNecesaryUser() {
        List <User> users = bank.getUsers();
        int pessel=-1;
        while (true) {
            System.out.println("Please provide PESSEL the necessary user \n" +
                    "For Exit please ENTER 0");
            try {
                pessel = Integer.parseInt(keubord.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("The pessel must consist of numbers only.");
                continue;
            }
            if(pessel == 0){
                exit();
            }

           for (int i =0; i<users.size(); i++){
             int pesselFromList=users.get(i).getPessel();
             if (pessel == pesselFromList){
                return i;
             }
           }
            System.out.println("User was not found. For Exit please ENTER 0 or repiad Your choice ");
        }
    }

    private boolean createANewUserAccount() {
        String firstName ="", lastName="";
        int pessel=0;
        Account account = new Account();

            System.out.println("Please provide First Name:");
            firstName = keubord.nextLine();
            System.out.println("Please provide Last Name:");
            firstName = keubord.nextLine();
            System.out.println("Please provide PESSEL Name:");
            pessel = Integer.parseInt(keubord.nextLine());



        return bank.users.add(new User(firstName,lastName,pessel,account));
    }


    private void listAccount(){
        List <User> users = bank.getUsers();
        for (int i = 0; i < users.size(); i++) {
            System.out.println( bank.users.get(i));
        }

    }

    private void exit() {
        System.exit(0);
    }

    private void printClerkMenu() {
        System.out.println("Please make a selection");
        System.out.println(" 1) Create a new account");
        System.out.println(" 2) Make a deposit");
        System.out.println(" 3) Make a withdrawal");
        System.out.println(" 4) List account balance");
        System.out.println(" 5) Make transfer from to");
        System.out.println(" 0) EXIT");
    }



    private void printHeader(){
        System.out.println("+----------------------------------------+");
        System.out.println("|--------Uwelkam to bank EPAM------------|");
        System.out.println("|----------------------------------------|");
        System.out.println("+----------------------------------------+");
    }


    private void clerkOrKlient() {
        System.out.println("Please make a selection");
        System.out.println("Are You klient or Bank Clerk? ");
        System.out.println(" Please provide  -1- for klient or -2- for clerk");

        int choise=getInput();
        if (choise == 1 ) {
             System.out.println("Klient");
        }else if (choise ==2){
            System.out.println("Klerk");
            printClerkMenu();
        }
        System.out.println("Invalid selection");
    }


    private int getInput() {
        int choise = -1;
        do {
            try {
                choise = Integer.parseInt(keubord.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid selection number");
            }if (choise < 0 || choise > 5) {
                System.out.println("Choice outside of range. Please chose again");
            }
        }while (choise<0 || choise>5);
        return choise;
    }


}
