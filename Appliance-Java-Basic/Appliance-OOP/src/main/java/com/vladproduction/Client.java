package com.vladproduction;

public class Client extends User {

    private String card;

    public Client(long id, String name, String email, String password, String card) {
        super(id, name, email, password);
        this.card = card;
    }

    public Client() {
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Client{" + super.toString() +
                ", card='" + getCard() + '\'' +
                '}';
    }

}
