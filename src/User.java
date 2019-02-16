public class User {
    private final String firstName;
    private final String lastName;
    private final int pessel;
    private final Account account;

    public int getPessel() {
        return pessel;
    }

    public User(String firstName, String lastName, int pessel, Account account) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pessel = pessel;
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pessel=" + pessel +
                ", account=" + account +
                '}';
    }
}
