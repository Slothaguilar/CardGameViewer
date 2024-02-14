import java.awt.*;

public class Card {
    // instances varaibles
    // Can write a class containing instance variables, constructors, and methods, using access modifiers (private vs public) appropriately.
    private String rank;
    private int point;
    private String suit;
    private CardGameViewer window;
    private Image cardImage;
    private Image[] backImage;

    // A constructor that takes in these 3 parameters (rank, suit, and point)
    public Card(String rank, String suit, int point, CardGameViewer card,Image cardImage){
        this.rank = rank;
        this.suit = suit;
        this.point = point;

        this.window = card;
        this.cardImage = cardImage;
        backImage = new Image[1];

        backImage[0] = card.getCardImage()[52];

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
    public String toString() {

        return rank + " of " + suit;
    }

    public void draw(Graphics g,int x, int y){
        // card draw itself
        g.drawImage(cardImage, x, y, 100, 150, window);
            // draw the card images

    }
}
