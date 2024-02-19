// Sofia Aguilar 2/18/24
// This class is the back end and holds the deck of cards in the game and evenly
// shuffles and deals the cards to each player
import java.awt.*;
import java.util.ArrayList;
import java.lang.Math;

public class Deck {
    // Instance variables for the ArrayList of cards and the number of cardsLeft and having acces to the CardGame Viewer
    // and having access to the card images for the front end
    // Can write a class containing instance variables, constructors, and methods, using access modifiers (private vs public) appropriately.
    private ArrayList<Card> cards;
    private int cardsLeft;
    private CardGameViewer gameViewer;
    private Image image;


    public Deck(String[] rank, String[] suits, int[] values, Game game){
        // inizalize the instance varaibles
        cards = new ArrayList<>();
        cardsLeft = 0;
        gameViewer = game.getWindow();
        // Iterate over suits and values to create cards as value is the same as rank
        for (int i = 0; i < suits.length; i++){
            for (int j = 0; j< values.length; j++) {
                // Create a Card with the correct rank, suit, and value
                // image the correct image of the card
                int cardImageIndex = 4 * (values[j] - 1) + i;
                image = gameViewer.getCardImage()[cardImageIndex];
                // create a new card witha rank, suit, value, and image
                Card card = new Card(rank[values[j]-1], suits[i], values[j], this.gameViewer, image);
                cards.add(card);
                cardsLeft++;
            }
        }
    }
    // getters of the instance varaibles
    public boolean isEmpty(){
        if (cardsLeft == 0){
            return true;
        }
        return false;
    }
    public int getCardsLeft() {

        return cardsLeft;
    }
    // deals off the cards that are left in the deck of cards
    public Card deal(){
        if (isEmpty()){
            return null;
        }
        cardsLeft--;
        // slect a card from the deck and return it
        return cards.get(cardsLeft);
    }
    // shuffles the deck by randomizing the order of the cards
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
}
