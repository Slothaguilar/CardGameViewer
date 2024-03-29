// Sofia Aguilar 2/18/24
// back end of holding information of each player with their specific hand of cards, their name and how many points they have

import java.awt.*;
import java.util.ArrayList;

public class Player {
    // Instance variables for the ArrayList of cards, hand, and the integer points
    // Can write a class containing instance variables, constructors, and methods, using access modifiers (private vs public) appropriately.
    private String name;
    private ArrayList<Card> hand;
    private int points;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.points = 0;
    }

    public Player(String name, ArrayList<Card> hand) {
        this.name = name;
        this.hand = hand;
        this.points = 0;
    }

    // Getter methods for name, hand, and points
    public ArrayList<Card> getHand() {
        return hand;
    }
    public String getName() {
        return name;
    }
    public int getPoints() {
        return points;
    }
    public void addPoints(int points) {
        this.points += points;
    }

    public void addCard(Card card) {
        hand.add(card);
    }
    // toString of returing the players name, how many points they have, and how their hand
    @Override
    public String toString() {
        return name + " has " + points + " points\n" + name + "'s cards: " + hand;
    }


}
