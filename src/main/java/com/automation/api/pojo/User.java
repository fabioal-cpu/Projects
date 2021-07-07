package com.automation.api.pojo;


/**
 * Class that represent the base of the resource schema
 * @author fabio.alarcon
 */
public class User {

    private String id;
    private String name;
    private String lastName;
    private double AccountNumber;
    private double Amount;
    private String TransactionType;
    private String Email;
    private boolean Active;
    private String Country;
    private String Telephone;

    /**
     * Constructor.
     */
    public User() {}

    /**
     * Constructor.
     * @param id String
     * @param name String
     * @param lastName String
     * @param accountNumber double
     * @param amount double
     * @param transactionType String
     * @param email String
     * @param active boolean
     * @param country String
     * @param telephone String
     *
     */
    public User(String id, String name, String lastName, double accountNumber,
                double amount, String transactionType, String email, boolean active,
                String country, String telephone) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.AccountNumber = accountNumber;
        this.Amount = amount;
        this.TransactionType = transactionType;
        this.Email = email;
        this.Active = active;
        this.Country = country;
        this.Telephone = telephone;
    }

    /**
     * Constructor.
     * @param name String
     * @param lastName String
     * @param accountNumber double
     * @param amount double
     * @param transactionType String
     * @param email String
     * @param active boolean
     * @param country String
     * @param telephone String
     *
     */
    public User(String name, String lastName, double accountNumber,
                double amount, String transactionType, String email, boolean active,
                String country, String telephone) {
        this.name = name;
        this.lastName = lastName;
        this.AccountNumber = accountNumber;
        this.Amount = amount;
        this.TransactionType = transactionType;
        this.Email = email;
        this.Active = active;
        this.Country = country;
        this.Telephone = telephone;
    }

    /**
     * Get id.
     * @return String
     */
    public String getId() {
        return id;
    }

    /**
     * Set id.
     * @param id String
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get first name.
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Set first name.
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get last name.
     * @return String
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set last name
     * @param lastName String
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get email.
     * @return String
     */
    public String getEmail() {
        return Email;
    }

    /**
     * Set email
     * @param email String
     */
    public void setEmail(String email) {
        this.Email = email;
    }

    /**
     * Get country.
     * @return String
     */
    public String getCountry() {
        return Country;
    }

    /**
     * Set country.
     * @param country String
     */
    public void setCountry(String country) {
        this.Country = country;
    }

    /**
     * Get telephone.
     * @return String
     */
    public String getTelephone() {
        return Telephone;
    }

    /**
     * Set telephone
     * @param telephone String
     */
    public void setTelephone(String telephone) {
        this.Telephone = telephone;
    }

    /**
     * Get active.
     * @return boolean
     */
    public boolean getActive() {
        return Active;
    }


    /**
     * Set active.
     * @param active boolean
     */
    public void setActive(boolean active) {
        this.Active = active;
    }

    /**
     * get AccountNumber
     * @return AccountNumber double
     */
    public double getAccountNumber() {
        return AccountNumber;
    }

    /**
     * set Account Number
     * @param AccountNumber double
     */
    public void setAccountNumber(double AccountNumber) {
        this.AccountNumber = AccountNumber;
    }

    /**
     * get Amount
     * @return Amount double
     */
    public double getAmount() {
        return Amount;
    }

    /**
     * set Amount
     * @param amount double
     */
    public void setAmount(double amount) {
        this.Amount = amount;
    }

    /**
     * get Transaction Type
     * @return TransactionType String
     */
    public String getTransactionType() {
        return TransactionType;
    }

    /**
     * set Transaction Type
     * @param transactionType String
     */
    public void setTransactionType(String transactionType) {
        this.TransactionType = transactionType;
    }

    /**
     * Override method toSting object.
     * @return String
     */
    @Override
    public String toString() {
        return "\nUser{" +
                "id='" + id + '\'' +
                ", first_name='" + name + '\'' +
                ", last_name='" + lastName + '\'' +
                ", accountNumber='" + AccountNumber + '\'' +
                ", amount='" + Amount + '\'' +
                ", transactionType='" + TransactionType + '\'' +
                ", email='" + Email + '\'' +
                ", active='" + Active + '\'' +
                ", country='" + Country + '\'' +
                ", telephone='" + Telephone + '\'' +
                '}';
    }
}
