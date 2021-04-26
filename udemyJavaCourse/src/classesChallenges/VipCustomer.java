package classesChallenges;

public class VipCustomer {

    private String name;
    private double creditLimit;
    private String emailAddress;

    /**
     * 1st - Empty constructor with default values
     */

    public VipCustomer() {
        this("default name", 0.0, "default@john.com");

    }

    /**
     * 2nd constructor should pass on two values and add a default value for 3rd
     */

    public VipCustomer(String name, double creditLimit) {
        this(name, creditLimit, "unknown@email.com");
    }

    /**
     * 3rd constructor save all the fields
     *
     * @param name         customer VIP name
     * @param creditLimit  with how much this wealthy customer will start
     * @param emailAddress private email address
     */

    public VipCustomer(String name, double creditLimit, String emailAddress) {
        this.name = name;
        this.creditLimit = creditLimit;
        this.emailAddress = emailAddress;
    }


    public String getName() {
        return name;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

}
