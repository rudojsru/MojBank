public class Account {
    private double balanse;
    private int accountNumber;
    private static int numberOfAccount=100;



    public Account() {
        this.balanse = balanse;
        this.accountNumber = numberOfAccount++;
    }



    public  void deposit(double amount){
        balanse += amount;
    }

    public void witchdrawal(double amount) {
        if (balanse >=amount){
            balanse -=amount;
        }else {
            balanse =0;
            System.out.println("You don't have enough money");
        }
    }

    public double getBalanse() {
        return balanse;
    }

    @Override
    public String toString() {
        return "{" +
                "balanse=" + balanse +
                ", accountNumber=" + accountNumber +
                '}';
    }


}
