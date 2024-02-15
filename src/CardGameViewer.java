import javax.swing.*;
import java.awt.*;
public class CardGameViewer extends JFrame{
    public final int WINDOW_WIDTH = 800;
    public final int WINDOW_HEIGHT = 600;

    // width of square and where it is supposed to be

    // images
    private Image[] cardImage;
    private Game t;
    private final int x1 = 200;
    private final int x2 = 400;
    private final int y1 = 200;
    private final int y2 = 200;

    // constructor
    public CardGameViewer(Game a) {
        this.t = a;
        cardImage = new Image[53];
        for (int i = 0; i < cardImage.length-1; i++){
            cardImage[i] = new ImageIcon("Resources/"+ (i+1) + ".png").getImage();
        }
        cardImage[52] = new ImageIcon("Resources/back.png").getImage();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Card Game");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public Image[] getCardImage() {
        return cardImage;
    }

    public void paint(Graphics g) {
        // TODO: draw instructions
        // if no rounds or beginning
        if (t.getRounds() == 0){
            paintIntro(g);
        }
        else {
            // TODO: draw when somone wins
            // clear the window
            clearWindow(g);

            g.setColor(Color.black);
            // title
            g.setFont(new Font("Serif", Font.PLAIN, 70));
            g.drawString("WAR!", 300, 100);
            // draw what each player draws
            if (t.isGameOver()) {
                // print winner
                g.setFont(new Font("Serif", Font.PLAIN, 90));
                if (t.getWinner().equals("Tie!")){
                    g.drawString(t.getWinner(), 300, 300);
               // g.drawString("None", 100, 100);
                // draw who has the most cards, draw the backside
                }else {
                    g.drawString(t.getWinner() + " wins!", 150, 300);
                }

            }else {
                // draw the cards and the backs of each player
                t.getCardPlayer1().draw(g, x1, y1);
                t.getCardPlayer2().draw(g, x2, y2);
                g.drawImage(cardImage[52], 100, 400, 100, 150, this);
                g.drawImage(cardImage[52],500, 400, 100, 150, this );
                // draw the names of each player
                g.setFont(new Font("Serif", Font.PLAIN, 50));
                g.drawString(t.getPlayers().get(0).getName(), 130, 170);
                g.drawString(t.getPlayers().get(1).getName(), 530, 170);

                // if there is a tie
//                if(t.isWarOn()){
//                    for (int i = 0; i < 2; i++) {
//                        int points = t.getPlayers().get(i).getHand().get(1).getPoint();
//                        int suit = t.getPlayers().get(i).getHand().get(1).getIndexSuit(t.getPlayers().get(i).getHand().get(1).getSuit());
//                        int k = 4 * (points - 1) + suit;
//                        t.getCardPlayer1().tieDrawCard(g, 500, y1 + 50, cardImage[k]);
//                    }
//                }
            }

    // t.getPlayers().get(0).draw(g);
                // TODO: draw when game in progress
            }

    }
    public void paintIntro(Graphics g){
        g.drawString("Instructions: Welcome to War! Each player turns up a card at the same time and the player", 100, 100);
        g.drawString("with the higher card takes both cards and puts them, on the bottom of his stack.", 100, 150);
        g.drawString("If the cards are the same rank, it is War. Each player turns up one card face down and ", 100, 200);
        g.drawString("one card face up. The player with the higher cards takes both piles.", 100, 250);
        g.drawString("If the turned-up cards are again the same rank, each player places another card face down", 100, 300);
        g.drawString("and turns another card face up. The player with the higher card takes all cards, and so on.", 100, 350);
        g.drawString("The game ends when one player has won all the cards. Good luck!", 100, 400);
    }
    public void clearWindow(Graphics g){
        g.setColor(Color.white);
        g.drawRect(0,0,WINDOW_WIDTH, WINDOW_HEIGHT);
        g.fillRect(0,0,WINDOW_WIDTH, WINDOW_HEIGHT);
    }

}
