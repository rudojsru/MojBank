public class User {
    private final String firstName;
    private final String lastName;
    private final int pessel;
    private final Account account;

    public User(String firstName, String lastName, int pessel, Account account) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pessel = pessel;
        this.account = account;
    }
}
