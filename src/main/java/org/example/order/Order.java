package org.example.order;

public class Order {
    private String firstName;
    private String lastName;
    private String address;
    private String[] color;

    public Order(String firstName, String lastName, String address, String[] color) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.color = color;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String[] getColor() {
        return color;
    }

    public void setColor(String[] color) {
        this.color = color;
    }
}
