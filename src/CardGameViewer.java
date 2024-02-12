import javax.swing.*;
import java.awt.*;
public class CardGameViewer extends JFrame{
    public final int WINDOW_WIDTH = 800;
    public final int WINDOW_HEIGHT = 600;

    // width of square and where it is supposed to be

    // images
    private Image[] cardImage;
    private Game t;

    // constructor
    public CardGameViewer(Game a) {
        this.t = a;
        cardImage = new Image[53];
        for (int i = 0; i < cardImage.length-1; i++){
            cardImage[i] = new ImageIcon("Resources/"+ i+1 + ".png").getImage();
        }
        cardImage[52] = new ImageIcon("Resources/back.png").getImage();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Card Game");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }
    public void paint(Graphics g) {
        // TODO: draw instructions
        // if no rounds or beginning
        if (t.getRounds() == 0){
            g.drawString("Instructions: Welcome to War! Each player turns up a card at the same time and the player", 100, 100);
            g.drawString("with the higher card takes both cards and puts them, on the bottom of his stack.", 100, 150);
            g.drawString("If the cards are the same rank, it is War. Each player turns up one card face down and ", 100, 200);
            g.drawString("one card face up. The player with the higher cards takes both piles.", 100, 250);
            g.drawString("If the turned-up cards are again the same rank, each player places another card face down", 100, 300);
            g.drawString("and turns another card face up. The player with the higher card takes all cards, and so on.", 100, 350);
            g.drawString("The game ends when one player has won all the cards. Good luck!", 100, 400);
        }
        // TODO: draw when somone wins
        if (t.isGameOver()){
            // print winner
            g.drawString(t.getWinner() + " wins!", 100, 100);

        }
        // TODO: draw when game in progress

    }
}
