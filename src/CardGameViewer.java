// Sofia Aguilar 2/18/24
// this program creates a front end or window to my game and draws out the cards, players name, intro, and who wins
import javax.swing.*;
import java.awt.*;
public class CardGameViewer extends JFrame{
    // Instance variables of class
    public final int WINDOW_WIDTH = 800;
    public final int WINDOW_HEIGHT = 600;
    private Image[] cardImage;
    private Game game;
    // coordinates for each card for each player
    private final int xCardPlayer1 = 200;
    private final int xCardPlayer2 = 400;
    private final int yCardPlayer1 = 200;
    private final int yCardPlayer2 = 200;

    // constructor
    public CardGameViewer(Game game) {
        // inizalize the instance varaibles
        this.game = game;

        // set the size for the cardImage array
        cardImage = new Image[53];

        // put the resources images in the array
        for (int i = 0; i < cardImage.length-1; i++){
            cardImage[i] = new ImageIcon("Resources/"+ (i+1) + ".png").getImage();
        }

        // set the backimage into the array
        cardImage[52] = new ImageIcon("Resources/back.png").getImage();

        // the window inizalize
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Card Game");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }
// getter of the cardImage
    public Image[] getCardImage() {
        return cardImage;
    }
    public void paint(Graphics g) {
        // if no rounds or beginning of the program draw the instructions and intro to to the game
        if (game.getRounds() == 0){
            paintIntro(g);
        }
        else {
            // clear the window
            clearWindow(g);

            // draw the Title
            drawTitle(g);

            // if the game is over don't draw any other card and just print the winner
            if (game.isGameOver()) {
                gameOver(g);
            }
            // if the game is not over draw the cards for each player and their names
            else {
                // goes to the method of the game in progress
                gameInProgress(g);

                // if there is a tie draw those cards
                if(game.isWarOn()){
                   warOn(g);
                }
            }
        }
    }
    public void paintIntro(Graphics g){
        // draw the instructions
        g.setFont(new Font("Serif", Font.PLAIN, 20));
        g.drawString("Instructions: Welcome to War! Each player turns up a card at the same time", 25 ,100);
        g.drawString("and the player with the higher card takes both cards and puts them, on the",25,150);
        g.drawString("bottom of his stack. If the cards are the same rank, it is War. Each player ",25,200);
        g.drawString("turns up one card face down and one card face up. The player with the higher ",25,250);
        g.drawString( "cards takes both piles. If the turned-up cards are again the same rank,",25,300);
        g.drawString("each player places another card face down and turns another card face up.",25,350);
        g.drawString("The player with the higher card takes all cards, and so on. The game ends",25,400);
        g.drawString("when one player has won all the cards. Good luck!",25,450);
    }
    public void clearWindow(Graphics g){
        // clear the window
        g.setColor(Color.white);
        g.drawRect(0,0,WINDOW_WIDTH, WINDOW_HEIGHT);
        g.fillRect(0,0,WINDOW_WIDTH, WINDOW_HEIGHT);
    }
    public void gameInProgress(Graphics g){
        // draw the cards for each player with the specific x and y coordinates
        game.getCardPlayer1().draw(g, xCardPlayer1, yCardPlayer1);
        game.getCardPlayer2().draw(g, xCardPlayer2, yCardPlayer2);

        // draw the back images for each player
        g.drawImage(cardImage[52], 100, 400, 100, 150, this);
        g.drawImage(cardImage[52],500, 400, 100, 150, this );

        // draw the names of each player
        g.setFont(new Font("Serif", Font.PLAIN, 50));
        g.drawString(game.getPlayers().get(0).getName(), 130, 170);
        g.drawString(game.getPlayers().get(1).getName(), 530, 170);
    }
    public void drawTitle(Graphics g){
        //draw out the Title of the Game
        g.setColor(Color.black);
        g.setFont(new Font("Serif", Font.PLAIN, 70));
        g.drawString("WAR!", 300, 100);
    }
    public void gameOver(Graphics g){
        g.setFont(new Font("Serif", Font.PLAIN, 90));
        // if the players have the same amount of card then print out tie
        if (game.getWinner().equals("Tie!")){
            g.drawString(game.getWinner(), 300, 300);
        }
        // if one of the players have more cards or wins the game print out that winner
        else {
            g.drawString(game.getWinner() + " wins!", 150, 300);
        }
    }
    public void warOn(Graphics g){
        // draw those cards of the next ones by calling WarCard for each player
        g.setColor(Color.black);
        game.getWarCardP1().draw(g, 200, 300);
        game.getWarCardP2().draw(g, 400, 300);
    }

}
