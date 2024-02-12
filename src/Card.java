import java.awt.*;

public class Card {
    // instances varaibles
    // Can write a class containing instance variables, constructors, and methods, using access modifiers (private vs public) appropriately.
    private String rank;
    private int point;
    private String suit;
    private CardGameViewer card;
    private Image[] cardImage;

    // A constructor that takes in these 3 parameters (rank, suit, and point)
    public Card(String rank, String suit, int point){
        this.rank = rank;
        this.suit = suit;
        this.point = point;

    }
    // Getter and Setter methods for each instance variable
    public String getRank() {
        return rank;
    }
    public int getPoint() {

        return point;
    }
    public String getSuit() {

        return suit;
    }
    // setters
    public void setRank(String rank) {

        this.rank = rank;
    }
    public void setPoint(int point) {

        this.point = point;
    }
    public void setSuit(String suit) {

        this.suit = suit;
    }
// A toString method that returns a String in the following format:
    // “[rank] of [suit]” (Ex. “Jack of Clubs”)

    public String toString() {

        return rank + " of " + suit;
    }

    public void draw(Graphics g){
        // card draw itself
    }
}
