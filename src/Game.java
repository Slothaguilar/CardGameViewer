import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private ArrayList<Player> players;
    // an arraylist players
    private Deck card;
    //2. Constructor
//a. Initialize your Deck class and players here
//b. You may need to ask for user input to get the player name
//c. Don’t forget to give your player a hand of cards if you need to
    public Game(){
        // hardcoding filling out the values, suits, etc for deck
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        String[] suits = {"Hearts", "Clubs", "Spades", "Diamonds"};
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        // add these hardcoding to the deck
        card = new Deck(ranks, suits, values);
        card.shuffle();  // Shuffle the deck before dealing
        // create the array list of players
        players = new ArrayList<>();
        // ask user 1 for name
        Scanner user1 = new Scanner(System.in);  // Create a Scanner object
//        System.out.println("Enter name for player 1: ");
//         String userName = user1.nextLine();  // Read user input
//        players.add(new Player(String userName = user1.nextLine()));
        System.out.println("Enter name for player 1: ");
        String userName = user1.nextLine();
        players.add(new Player(userName));
        // ask user 2 for name
        System.out.println("Enter name for player 2: ");
        String userN = user1.nextLine();
        players.add(new Player(userN));


        // deal the card deck to the each of the players hand
        // Understand how to use nesting to embed loops and conditionals inside of other loops and conditionals.
        for (Player player : players) {
            for (int j = 0; j < 26; j++) {
                Card deck = card.deal();
                // deal til no more cards left
                if (deck != null) {
                    // Add points to each card in the player's hand
                    player.addCard(deck);
                    player.addPoints(deck.getPoint());
                }
            }
        }
    }
    //3. printInstructions - This method should print the instructions for your game. Be
//sure to call it before you begin playing or within the playGame function.
    // Understands how the keyword static affects methods and variables
    public static void printInstructions(){

        System.out.println("Instructions: Welcome to War! Each player turns up a card at the same time and the player with the higher card takes both cards and puts them, on the bottom of his stack.\n" +
                "\n" +
                "If the cards are the same rank, it is War. Each player turns up one card face down and one card face up. The player with the higher cards takes both piles. If the turned-up cards are again the same rank, each player places another card face down and turns another card face up. The player with the higher card takes all cards, and so on.\n" +
                "\n" +
                "The game ends when one player has won all the cards. Good luck!");
    }
    //4. playGame - This method should contain the logic to run your game. For example, if
//your game were BlackJack, the player would continuously draw cards from the deck until
//they reached 21, forfeit, or hit a number higher than 21.
    public void playGame(){
        boolean bool = true;
        // game keeps running until one gets all 52 cards
        while (bool) {
            // Each player draws a card
            Card card1 = players.get(0).getHand().get(0);
            Card card2 = players.get(1).getHand().get(0);
            boolean ti = true;
            // sets the value of the card of the first player
            // Can use and apply SLICE String Methods
            if (ti) {
                if (card1.getRank().equals("A")) {
                    card1.setPoint(1);
                    ti = false;
                } else if (card1.getRank().equals("2")) {
                    card1.setPoint(2);
                    ti = false;
                } else if (card1.getRank().equals("3")) {
                    card1.setPoint(3);
                    ti = false;
                } else if (card1.getRank().equals("4")) {
                    card1.setPoint(4);
                    ti = false;
                } else if (card1.getRank().equals("5")) {
                    card1.setPoint(5);
                    ti = false;
                } else if (card1.getRank().equals("6")) {
                    card1.setPoint(6);
                    ti = false;
                } else if (card1.getRank().equals("7")) {
                    card1.setPoint(7);
                    ti = false;
                } else if (card1.getRank().equals("8")) {
                    card1.setPoint(8);
                    ti = false;
                } else if (card1.getRank().equals("9")) {
                    card1.setPoint(9);
                    ti = false;
                } else if (card1.getRank().equals("10")) {
                    card1.setPoint(10);
                    ti = false;
                } else if (card1.getRank().equals("Jack")) {
                    card1.setPoint(11);
                    ti = false;
                } else if (card1.getRank().equals("Queen")) {
                    card1.setPoint(12);
                    ti = false;
                } else if (card1.getRank().equals("King")) {
                    card1.setPoint(13);
                    ti = false;
                }
            }
            // sets the value of the card of player 2
            boolean di = true;
            if (di) {
                if (card2.getRank().equals("A")) {
                    card2.setPoint(1);
                    di = false;
                } else if (card2.getRank().equals("2")) {
                    card2.setPoint(2);
                    di = false;
                } else if (card2.getRank().equals("3")) {
                    card2.setPoint(3);
                    di = false;
                } else if (card2.getRank().equals("4")) {
                    card2.setPoint(4);
                    di = false;
                } else if (card2.getRank().equals("5")) {
                    card2.setPoint(5);
                    di = false;
                } else if (card2.getRank().equals("6")) {
                    card2.setPoint(6);
                    di = false;
                } else if (card2.getRank().equals("7")) {
                    card2.setPoint(7);
                    di = false;
                } else if (card2.getRank().equals("8")) {
                    card2.setPoint(8);
                    di = false;
                } else if (card2.getRank().equals("9")) {
                    card2.setPoint(9);
                    di = false;
                } else if (card2.getRank().equals("10")) {
                    card2.setPoint(10);
                    di = false;
                } else if (card2.getRank().equals("Jack")) {
                    card2.setPoint(11);
                    di = false;
                } else if (card2.getRank().equals("Queen")) {
                    card2.setPoint(12);
                    di = false;
                } else if (card2.getRank().equals("King")) {
                    card1.setPoint(13);
                    di = false;
                }
            }
            Scanner user1 = new Scanner(System.in);
            System.out.println("Continue playing? ");
            String answer = user1.nextLine();
            if (answer.equals("yes")) {
                // Display the drawn cards

                System.out.println(players.get(0).getName() + " draws: " + card1.toString());
                System.out.println(players.get(1).getName() + " draws: " + card2.toString());

                // Compare the ranks of the drawn cards
                int result = card1.getPoint() - card2.getPoint();

                // if player 1 card greater in value then players 2 card the positve result
                if (result > 0) {
                    // Player 1 wins the round, add both cards to their hand
                    players.get(0).addCard(card1);
                    players.get(0).addCard(card2);
                    // say player 1 won
                    System.out.println(players.get(0).getName() + " wins the round!");
                } else if (result < 0) {
                    // Player 2 wins the round, add both cards to their hand
                    players.get(1).addCard(card1);
                    players.get(1).addCard(card2);
                    // say player 2 won
                    System.out.println(players.get(1).getName() + " wins the round!");
                }
                // else its 0 then a tie
                else {
                    // It's a tie, go to war and print out
                    System.out.println("It's a tie! Going to war...");

                    // Temporary storage for cards in war
                    ArrayList<Card> warCards = new ArrayList<>();

                    // Add the tied cards to the warCards list
                    warCards.add(card1);
                    warCards.add(card2);

                    // Continue drawing additional cards for the war
                    boolean warOn = true;
                    while (warOn) {
                        // Check if players have enough cards for the war
                        if (players.get(0).getHand().size() < 2 || players.get(1).getHand().size() < 2) {
                            // If not enough cards, end the game
                            warOn = false;
                            break;
                        }

                        // Draw additional cards for the war
                        warCards.add(players.get(0).getHand().get(1));
                        warCards.add(players.get(1).getHand().get(1));

                        // Display the drawn cards
                        System.out.println(players.get(0).getName() + " draws: " + warCards.get(warCards.size() - 2).toString());
                        System.out.println(players.get(1).getName() + " draws: " + warCards.get(warCards.size() - 1).toString());

                        // Compare the ranks of the drawn cards
                        int warResult = warCards.get(warCards.size() - 2).getPoint() - warCards.get(warCards.size() - 1).getPoint();

                        if (warResult > 0) {
                            // Player 1 wins the war, add all war cards to their hands
                            // Understand how to use nesting to embed loops and conditionals inside of other loops and conditionals.
                            for (Card warCard : warCards) {
                                players.get(0).addCard(warCard);
                            }

                            System.out.println(players.get(0).getName() + " wins the war!");
                            // End the war
                            warOn = false;
                        } else if (warResult < 0) {
                            // Player 2 wins the war, add all war cards to their hands
                            // Understand how to use nesting to embed loops and conditionals inside of other loops and conditionals.
                            // Can write algorithms to traverse and modify Arrays and ArrayLists.
                            for (Card warCard : warCards) {
                                players.get(1).addCard(warCard);
                            }
                            System.out.println(players.get(1).getName() + " wins the war!");
                            // End the war
                            warOn = false;
                        } else {
                            // Another tie, continue the war by drawing more cards
                            System.out.println("It's a tie! Going to war...");
                            // Understand how to use nesting to embed loops and conditionals inside of other loops and conditionals.
                            // Can write algorithms to traverse and modify Arrays and ArrayLists.
                            for (Player player : players) {
                                player.getHand().remove(card1);
                                player.getHand().remove(card2);
                                for (Card warCard : warCards) {
                                    player.getHand().remove(warCard);
                                }
                            }
                        }
                    }
                    // remove the tied cards
                    players.get(0).getHand().remove(card1);
                    players.get(1).getHand().remove(card2);
                }

                // Remove the drawn cards from players' hands
                players.get(0).getHand().remove(card1);
                players.get(1).getHand().remove(card2);
                // loop until someone wins
                if (players.get(0).getHand().size() == 52 || players.get(1).getHand().size() == 52) {
                    bool = false;
                }
            }

            if (answer.equals("no")){
                break;
            }
            // Display the winner
            if (players.get(0).getHand().size() == 52) {
                System.out.println(players.get(0).getName() + " wins the game!");
            } else {
                System.out.println(players.get(1).getName() + " wins the game!");
            }

        }
    }
    //5. Main method
//a. You should create a new game object here and call playGame on it
    public static void main(String[] args) {
        Game game = new Game();
        game.printInstructions();
        game.playGame();

    }
}
