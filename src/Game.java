import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private ArrayList<Player> players;
    // an arraylist players
    private boolean gameOver;
    private Deck card;
    // calculate the number of rounds
    private int rounds;
    private CardGameViewer window;
    private String winner;
    private Card cardPlayer1;
    private Card cardPlayer2;
    private boolean warOn;
    //2. Constructor
//a. Initialize your Deck class and players here
//b. You may need to ask for user input to get the player name
//c. Don’t forget to give your player a hand of cards if you need to
    public Game(){
        // hardcoding filling out the values, suits, etc for deck
        window = new CardGameViewer(this);
        gameOver = false;
        rounds = 0;
        this.winner = "-";
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        // add these hardcoding to the deck
        card = new Deck(ranks, suits, values, this);
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

    public boolean isGameOver() {
        return gameOver;
    }
    public int getRounds(){
        return rounds;
    }
    public String getWinner(){
        return winner;
    }

    public Deck getCard() {
        return card;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public CardGameViewer getWindow() {
        return window;
    }

    public Card getCardPlayer1() {
        return cardPlayer1;
    }

    public Card getCardPlayer2() {
        return cardPlayer2;
    }

    public boolean isWarOn() {
        return warOn;
    }


    //3. printInstructions - This method should print the instructions for your game. Be
//sure to call it before you begin playing or within the playGame function.
    // Understands how the keyword static affects methods and variables
    public static void printInstructions(){

        System.out.println("Instructions: Welcome to War! Each player turns up a card at the same time and the player with the higher card takes both cards and puts them, on the bottom of his stack.\n" + "If the cards are the same rank, it is War. Each player turns up one card face down and one card face up. The player with the higher cards takes both piles. If the turned-up cards are again the same rank, each player places another card face down and turns another card face up. The player with the higher card takes all cards, and so on.\n" + "The game ends when one player has won all the cards. Good luck!");
    }
    //4. playGame - This method should contain the logic to run your game. For example, if
//your game were BlackJack, the player would continuously draw cards from the deck until
//they reached 21, forfeit, or hit a number higher than 21.
    public void playGame(){
        // game keeps running until one gets all 52 cards

        while (!gameOver) {
            // Each player draws a card
            Scanner user1 = new Scanner(System.in);
            System.out.println("Continue playing? ");
            String answer = user1.nextLine();
            cardPlayer1 = players.get(0).getHand().get(0);
            cardPlayer2 = players.get(1).getHand().get(0);
            boolean ti = true;
            // sets the value of the card of the first player
            // Can use and apply SLICE String Methods

            if (answer.equals("yes")) {
                // Display the drawn cards
                rounds++;
                window.repaint();
                System.out.println(players.get(0).getName() + " draws: " + cardPlayer1.toString());
                System.out.println(players.get(1).getName() + " draws: " + cardPlayer2.toString());
                window.repaint();

                // Compare the ranks of the drawn cards
                int result = cardPlayer1.getPoint() - cardPlayer2.getPoint();

                // if player 1 card greater in value then players 2 card the positve result
                if (result > 0) {
                    // Player 1 wins the round, add both cards to their hand
                    players.get(0).addCard(cardPlayer1);
                    players.get(0).addCard(cardPlayer2);
                    // say player 1 won
                    System.out.println(players.get(0).getName() + " wins the round!");
                    window.repaint();
                } else if (result < 0) {
                    // Player 2 wins the round, add both cards to their hand
                    players.get(1).addCard(cardPlayer1);
                    players.get(1).addCard(cardPlayer2);
                    // say player 2 won
                    System.out.println(players.get(1).getName() + " wins the round!");
                    window.repaint();
                }
                // else its 0 then a tie
                else {
                    // It's a tie, go to war and print out
                    System.out.println("It's a tie! Going to war...");

                    // Temporary storage for cards in war
                    ArrayList<Card> warCards = new ArrayList<>();

                    // Add the tied cards to the warCards list
                    warCards.add(cardPlayer1);
                    warCards.add(cardPlayer2);

                    // Continue drawing additional cards for the war
                    warOn = true;
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
                        window.repaint();

                        // Display the drawn cards
                        System.out.println(players.get(0).getName() + " draws: " + warCards.get(warCards.size() - 2).toString());
                        System.out.println(players.get(1).getName() + " draws: " + warCards.get(warCards.size() - 1).toString());

                        // Compare the ranks of the drawn cards
                        int warResult = warCards.get(warCards.size() - 2).getPoint() - warCards.get(warCards.size() - 1).getPoint();

                        if (warResult > 0) {
                           // remove the card if player 2 loosed
                            players.get(0).getHand().remove(players.get(0).getHand().get(1));
                            players.get(1).getHand().remove(players.get(1).getHand().get(1));

                            // Player 1 wins the war, add all war cards to their hands
                            // Understand how to use nesting to embed loops and conditionals inside of other loops and conditionals.
                            for (int i = 0; i < warCards.size(); i++){
                                players.get(0).getHand().add(warCards.get(i));
                            }


                            System.out.println(players.get(0).getName() + " wins the war!");
                            // End the war
                            warOn = false;
                        } else if (warResult < 0) {
                            players.get(0).getHand().remove(players.get(0).getHand().get(1));
                            players.get(1).getHand().remove(players.get(0).getHand().get(1));
                            // Player 2 wins the war, add all war cards to their hands
                            // Understand how to use nesting to embed loops and conditionals inside of other loops and conditionals.
                            // Can write algorithms to traverse and modify Arrays and ArrayLists.
//                            for (Card warCard : warCards) {
//                                players.get(1).addCard(warCard);
//                            }
                            for (int i = 0; i < warCards.size(); i++){
                                players.get(1).getHand().add(warCards.get(i));
                            }
                            players.get(0).getHand().remove(cardPlayer1);
                            System.out.println(players.get(1).getName() + " wins the war!");
                            // End the war
                            warOn = false;
                        } else {
                            // Another tie, continue the war by drawing more cards
                            System.out.println("It's a tie! Going to war...");
                            // Understand how to use nesting to embed loops and conditionals inside of other loops and conditionals.
                            // Can write algorithms to traverse and modify Arrays and ArrayLists.
                            for (Player player : players) {
                                player.getHand().remove(cardPlayer1);
                                player.getHand().remove(cardPlayer2);
                                for (Card warCard : warCards) {
                                    player.getHand().remove(warCard);
                                }
                            }
                        }
                    }
                    // remove the tied cards
                    players.get(0).getHand().remove(cardPlayer1);
                    players.get(1).getHand().remove(cardPlayer2);
                }

                // Remove the drawn cards from players' hands
                players.get(0).getHand().remove(cardPlayer1);
                players.get(1).getHand().remove(cardPlayer2);
                // loop until someone wins
                if (players.get(0).getHand().size() == 52 || players.get(1).getHand().size() == 52) {
                    gameOver = true;
                }
            }

            // Display the winner
            if (players.get(0).getHand().size() == 52 && players.get(1).getHand().isEmpty()) {
                winner = players.get(0).getName();
                System.out.println(winner + " wins the game!");
            } else if (players.get(1).getHand().size() == 52 && players.get(0).getHand().isEmpty()){
                winner = players.get(1).getName();
                System.out.println(winner + " wins the game!");
            }
            if (answer.equals("no")){
                // print who has the most or if a tie
                gameOver = true;
                if (players.get(0).getHand().size() > players.get(1).getHand().size()) {
                    winner = players.get(0).getName();
                    System.out.println(winner + " wins the game!");
                } else if (players.get(1).getHand().size() > players.get(0).getHand().size()){
                    winner = players.get(1).getName();
                    System.out.println(winner + " wins the game!");
                }else{
                    winner = "Tie!";
                }
                window.repaint();
                break;
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
