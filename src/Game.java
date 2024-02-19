// Sofia Aguilar 2/16/24
// this program is the back end of my card game
// this game has the instructions to the game and the code to the card game war
// Has coded saying the players card and having he case of having war
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    // instance varaibles
    private ArrayList<Player> players;
    // tells if the game is over
    private boolean gameOver;
    private Deck deck;
    // calculate the number of rounds
    private int rounds;
    private CardGameViewer window;
    private String winner;
    // the cards of each of the players
    private Card cardPlayer1;
    private Card cardPlayer2;
    // if there is a war in the game
    private boolean warOn;
    // the next cards that the player will put down during war
    private Card warCardP1;
    private Card warCardP2;

    public Game(){
        // inizalizng the instancer varables
        window = new CardGameViewer(this);
        gameOver = false;
        warOn = true;
        rounds = 0;
        this.winner = "-";

        // hardcoding filling out the values, suits, etc for deck
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

        // add these hardcoding to the deck
        deck = new Deck(ranks, suits, values, this);

        // create the array list of players
        players = new ArrayList<>();

        // ask user 1 for name
        Scanner user1 = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter name for player 1: ");
        String userName = user1.nextLine();
        players.add(new Player(userName));

        // ask user 2 for name
        System.out.println("Enter name for player 2: ");
        String userN = user1.nextLine();
        players.add(new Player(userN));

        // deal the card deck to each of the players hand
        deck.shuffle(); // Shuffle the deck before dealing
        for (Player player : players) {
            for (int j = 0; j < 26; j++) {
                Card deck = this.deck.deal();
                // deal til no more cards left
                if (deck != null) {
                    // Add points to each card in the player's hand
                    player.addCard(deck);
                    player.addPoints(deck.getPoint());
                }
            }
        }
    }
    // getters of the insatcne varables
    public boolean isGameOver() {
        return gameOver;
    }
    public int getRounds(){
        return rounds;
    }
    public String getWinner(){
        return winner;
    }

    public Deck getDeck() {
        return deck;
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

    public Card getWarCardP1() {
        return warCardP1;
    }

    public Card getWarCardP2() {
        return warCardP2;
    }

    // print instructions
    public static void printInstructions(){
        System.out.println("Instructions: Welcome to War! Each player turns up a card at the same time and " +
                "the player with the higher card takes both cards and puts them, on the bottom of his stack.\n" +
                "If the cards are the same rank, it is War. Each player turns up one card face down and one " +
                "card face up. The player with the higher cards takes both piles. If the turned-up cards are " +
                "again the same rank, each player places another card face down and turns another card face up. " +
                "The player with the higher card takes all cards, and so on.\n" + "The game ends when one player " +
                "has won all the cards. Good luck!");
    }
    public void playGame(){
        // game keeps running until one gets all 52 cards or user doean't want to play anymore
        while (!gameOver) {
            // Each player draws a card
            Scanner user1 = new Scanner(System.in);
            System.out.println("Continue playing?(yes/no) ");
            String answer = user1.nextLine();

            // counting the amount if a war goes on
            // tells is there is a war
            int countWar = 0;

            // if user wants to continue playing
            if (answer.equals("yes")) {
                // define the card of Player 1 and Player 2
                cardPlayer1 = players.get(0).getHand().get(0);
                cardPlayer2 = players.get(1).getHand().get(0);

                // start and count the number of rounds has happened in the game
                rounds++;

                // Display the drawn cards
                System.out.println(players.get(0).getName() + " draws: " + cardPlayer1.toString());
                System.out.println(players.get(1).getName() + " draws: " + cardPlayer2.toString());

                // Compare the ranks of the drawn cards
                int result = cardPlayer1.getPoint() - cardPlayer2.getPoint();

                // repaint the window
                window.repaint();

                // if player 1 card greater in value then players 2 card the positve result
                if (result > 0) {
                    PlayerOneWinsRound();
                    //repaint the window
                    window.repaint();
                } else if (result < 0) {
                    PlayerTwoWinsRound();
                    window.repaint();
                }
                // else its 0 then a tie
                else {
                    countWar++;
                    warOn();
                    window.repaint();

                }
                // Remove the drawn cards from players' hands
                players.get(0).getHand().remove(cardPlayer1);
                players.get(1).getHand().remove(cardPlayer2);
                // if a war happend set it equal to true so the front end can draw
                if (countWar > 0) {
                    warOn = true;
                }
                // loop until someone wins
                if (players.get(0).getHand().size() == 52 || players.get(1).getHand().size() == 52) {
                    gameOver = true;
                }
            }
            // if user says no and wants to go out
            if (answer.equals("no")){
                // print who has the most or if a tie
                gameOver = true;
                printWinner();
                window.repaint();
                break;
            }

        }
    }
    public void PlayerTwoWinsRound(){
        warOn = false;
        // Player 2 wins the round, add both cards to their hand
        players.get(1).addCard(cardPlayer1);
        players.get(1).addCard(cardPlayer2);
        // say player 2 won
        System.out.println(players.get(1).getName() + " wins the round!");

        // add points to player 2
        players.get(1).addPoints(1);
    }
    public void PlayerOneWinsRound(){
        // say that there is no tie
        warOn = false;

        // Player 1 wins the round, add both cards to their hand
        players.get(0).addCard(cardPlayer1);
        players.get(0).addCard(cardPlayer2);

        // say player 1 won
        System.out.println(players.get(0).getName() + " wins the round!");

        // add the point to the player 1 who won
        players.get(0).addPoints(1);
    }
  public void printWinner(){
      // if player 1 has a bigger size hand then they win the game
        if (players.get(0).getHand().size() > players.get(1).getHand().size()) {
          winner = players.get(0).getName();
          System.out.println(winner + " wins the game!");
      }
        // if player 2 has a bigger size hand than they win the game
        else if (players.get(1).getHand().size() > players.get(0).getHand().size()){
          winner = players.get(1).getName();
          System.out.println(winner + " wins the game!");
      }
        // else a tie
      else{
          winner = "Tie!";
      }
  }
    public void warOn(){
        // It's a tie, go to war and print out
        System.out.println("It's a tie! Going to war...");

        // Temporary storage for cards in war
        ArrayList<Card> warCards = new ArrayList<>();

        // Add the tied cards to the warCards list
        warCards.add(cardPlayer1);
        warCards.add(cardPlayer2);

        // a war going on so set to true
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

            // set the war cards to the next card
            warCardP1 = players.get(0).getHand().get(1);
            warCardP2 = players.get(1).getHand().get(1);

            // Display the drawn cards
            System.out.println(players.get(0).getName() + " draws: " + warCards.get(warCards.size() - 2).toString());
            System.out.println(players.get(1).getName() + " draws: " + warCards.get(warCards.size() - 1).toString());

            // Compare the ranks of the drawn cards
            int warResult = warCards.get(warCards.size() - 2).getPoint() - warCards.get(warCards.size() - 1).getPoint();

            // when player 1 wins war, remove the cards and add the warCards array to player 1
            if (warResult > 0) {
                // remove the card if player 2 loosed
                players.get(0).getHand().remove(players.get(0).getHand().get(1));
                players.get(1).getHand().remove(players.get(1).getHand().get(1));

                // Player 1 wins the war, add all war cards to their hands
                for (int i = 0; i < warCards.size(); i++) {
                    players.get(0).getHand().add(warCards.get(i));
                }

                players.get(0).addPoints(1);

                System.out.println(players.get(0).getName() + " wins the war!");
                // End the war
                warOn = false;
            }
            // when player 2 wins the war remove the cards and add the warCards array to player 2
            else if (warResult < 0) {
                players.get(0).getHand().remove(players.get(0).getHand().get(1));
                players.get(1).getHand().remove(players.get(1).getHand().get(1));

                for (int i = 0; i < warCards.size(); i++) {
                    players.get(1).getHand().add(warCards.get(i));
                }
                players.get(0).getHand().remove(cardPlayer1);
                players.get(1).addPoints(1);
                System.out.println(players.get(1).getName() + " wins the war!");
                // End the war
                warOn = false;
            }
            // Another tie, continue the war by drawing more cards
            else {
                System.out.println("It's a tie! Going to war...");

                for (Player player : players) {
                    player.getHand().remove(cardPlayer1);
                    player.getHand().remove(cardPlayer2);
                    for (Card warCard : warCards) {
                        player.getHand().remove(warCard);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Game game = new Game();
        game.printInstructions();
        game.playGame();

    }
}
