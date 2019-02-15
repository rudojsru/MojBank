public class Account {
    private double balanse;
    private int accountNumber;
    private static int numberOfAccount=100000000;


    public Account(int accountNumber) {
        this.accountNumber = numberOfAccount++;
    }

    public Account() {
        this.balanse = balanse;
        this.accountNumber = accountNumber;
    }
}
