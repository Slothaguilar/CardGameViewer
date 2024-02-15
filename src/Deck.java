// Sofia Aguilar
import java.awt.*;
import java.util.ArrayList;
import java.lang.Math;

public class Deck {
    // Instance variables for the ArrayList of cards and the number of cardsLeft
    // Can write a class containing instance variables, constructors, and methods, using access modifiers (private vs public) appropriately.
    private ArrayList<Card> cards;
    private int cardsLeft;
    private CardGameViewer a;
    private Image[] backImage;
    private Image image;


    public Deck(String[] rank, String[] suits, int[] values, Game game){
//        cards = new ArrayList<>();
        cards = new ArrayList<>();
        cardsLeft = 0;
        a = game.getWindow();
        // back of the card
        backImage = new Image[1];
        backImage[0] = a.getCardImage()[52];

        // Iterate over ranks, suits, and values to create cards
        for (int i = 0; i < suits.length; i++){
                // String suit : suits) {
            for (int j = 0; j< values.length; j++) {
                // Create a Card with the correct rank, suit, and value
                // image the correct image of the card

                int k = 4 * (values[j] - 1) + i;
                image = a.getCardImage()[k];
                Card card = new Card(rank[values[j]-1], suits[i], values[j], a, image);
                cards.add(card);
                cardsLeft++;
            }
        }
    }
// isEmpty - This method should return true when the number of cards left in the deck is 0

    public boolean isEmpty(){
        if (cardsLeft == 0){
            return true;
        }
        return false;
    }
    // getCardsLeft — This method returns the number of cards in the deck that are left to be dealt
    public int getCardsLeft() {

        return cardsLeft;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    // deal — This method “deals” a card by selecting a card from the deck and returning it.
    public Card deal(){
        if (isEmpty()){
            return null;
        }
        cardsLeft--;
        return cards.get(cardsLeft);
    }
    public void shuffle() {
        // For i = last index of the deck down to 0
        for (int i = cards.size() - 1; i>0; i--){
            // Can use Math class, especially Math.random()
            int random = (int)(Math.random() * i);
            // Exchange cards[i] and cards[r]
            Card temp = cards.get(i);
            cards.set(i, cards.get(random));
            cards.set(random, temp);
        }
    }
    public void draw(Graphics g){
        // draw the deck which is faced down
//        g.drawImage(backImage[0], 150, 400, 100, 150, a);
//        g.drawImage(backImage[0], 500, 400, 100, 150, a);
//

    }
}
