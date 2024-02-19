// Sofia Aguilar 2/18/24
// this program creates a front end or window to my game and draws out the cards, players name, intro, and who wins
import java.awt.*;

public class Card {
    // instances varaibles
    // Can write a class containing instance variables, constructors, and methods, using access modifiers (private vs public) appropriately.
    private String rank;
    private int point;
    private String suit;
    private CardGameViewer window;
    private Image cardImage;

    public Card(String rank, String suit, int point, CardGameViewer card,Image cardImage){
        // Inzalizing the instance varables of the contructor
        this.rank = rank;
        this.suit = suit;
        this.point = point;
        this.window = card;
        this.cardImage = cardImage;

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
    // card draw itself with given x and y cooridinate of specific player
    public void draw(Graphics g,int x, int y){
        g.drawImage(cardImage, x, y, 100, 150, window);

    }
}
