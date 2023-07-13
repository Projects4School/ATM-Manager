package Models;

public class Client {
    private String ClientId;
    private String Surname;
    private String Name;
    private String Address;
    private Integer PostalCode;
    private String City;
    private Float Balance;

    public Client(String clientId, String surname, String name, String address, Integer postalCode, String city, Float balance) {
        super();
        ClientId = clientId;
        Surname = surname;
        Name = name;
        Address = address;
        PostalCode = postalCode;
        City = city;
        Balance = balance;
    }

    public String getClientId() {
        return ClientId;
    }

    public void setClientId(String clientId) {
        ClientId = clientId;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Integer getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(Integer postalCode) {
        PostalCode = postalCode;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public Float getBalance() {
        return Balance;
    }

    public void setBalance(Float balance) {
        Balance = balance;
    }

    public Object[] toObject() {
        return new Object[] {getClientId(), getName(), getSurname(), getAddress(), getPostalCode(), getCity(), getBalance()};
    }
}
