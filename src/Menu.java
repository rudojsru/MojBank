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
        while (!exit){

            while (true){
                 clerkOrKlient();
                 choise=getInput();
                 if (choise == 1 ) {
              //       printKlientMenu();
                     System.out.println("Klient");
                     break;

                 }else if (choise ==2){
                     System.out.println("Klerk");
                     printClerkMenu();
                     break;
                 }
                System.out.println("Invalid selection");

            }
        choise =getInput();
        performAction(choise);
        exit=true;
        }

    }

    private void performAction(int choise) {
        switch (choise){
             case 1: createANewUserAccount();
//            case 2: makeADeposit();
//            case 3: makeAWithDrawal();
//            case 4: listAccount();
            case 0: exit();
        }
    }

    private User createANewUserAccount() {
        String firstName ="", lastName="";
        int pessel=0;
        Account account = new Account();


        return new User(firstName,lastName,pessel,account);
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
    }


    private int getInput() {
        int choise = -1;
        do {
            try {
                choise = Integer.parseInt(keubord.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid selection number");
            }if (choise < 0 || choise > 4) {
                System.out.println("Choice outside of range. Please chose again");
            }
        }while (choise<0 || choise>4);
        return choise;
    }







//    User user1 = new User("Slon","Sloniczowicz", 56345, ){
//
//    }
}
