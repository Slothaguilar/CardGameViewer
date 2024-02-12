import java.util.ArrayList;
import java.lang.Math;

public class Deck {
    // Instance variables for the ArrayList of cards and the number of cardsLeft
    // Can write a class containing instance variables, constructors, and methods, using access modifiers (private vs public) appropriately.
    private ArrayList<Card> cards;
    private int cardsLeft;

    //2. Deck constructor
    // ["A", "Hearts", 1], ["2", "Hearts", 2], ["3", "Hearts",
    //3],["A", "Clubs", 1], ["2", "Clubs", 2], ["3", "Clubs", 3]
    public Deck(String[] rank, String[] suits, int[] values){
//        cards = new ArrayList<>();
        cards = new ArrayList<>();
        cardsLeft = 0;

        // Iterate over ranks, suits, and values to create cards
        for (String suit : suits) {
            for (int value : values) {
                for (String ranks : rank) {
                    // Create a Card with the correct rank, suit, and value
                    Card card = new Card(ranks, suit, value);
                    cards.add(card);
                    cardsLeft++;
                }
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
        //○ Generate a random integer r (using Math.random) between 0
        //and i, inclusive;
        //○ Exchange cards[i] and cards[r]
    }
}
