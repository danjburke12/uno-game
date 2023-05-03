package src;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import Cards.Card;
import java.io.File;
import javax.swing.ImageIcon;

/* ***********************************************
*  This class handles all the graphic processing
*  for the cards in the current players hand. 
*  Think of this as the visual game board.
* ***********************************************/
public class PerceptionEngine {

    /* ***********************************************
     *  variable declaration
     * ***********************************************/
    JFrame frame = new JFrame("Cards In Hand");
    ResizableImagePanel p1 = new ResizableImagePanel();
    ResizableImagePanel p = new ResizableImagePanel();
    int dividerSize;
    Dimension screenSize;
    JScrollPane scrollPane = new JScrollPane(p1);
    /* ***********************************************
     *  constructor
     * ***********************************************/
    public PerceptionEngine() {
     WindowHandler();
    }

    /* ***********************************************
     *  Dispalys the current players card
     * ***********************************************/
    public void WindowHandler() {
        // Create a JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        
        // get screen size
         screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // This sets the divider to split between the current card played 
        // and the cards in the current player's hand.
        dividerSize = (int)(screenSize.width*(80.0f/100.0f));

        // This using the flowlayout for the left container panel and sets the default dimensions
        p1.setLayout((new FlowLayout(FlowLayout.LEFT)));
        //p1.setPreferredSize(new Dimension(3800, 300));

        // using JScroll in conjunction with JPanel to dislplay the scroll bar. 
        System.out.println("**********************************************" );
    
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        //scrollPane.setPreferredSize(new Dimension(300,320));
  
        // create a splitpane
        JSplitPane sl = new JSplitPane(SwingConstants.VERTICAL, scrollPane, p);
        sl.setDividerLocation(dividerSize);

        // Set the JFrame size and make it visible
        frame.add(sl);
        frame.setSize(screenSize.width, 400);
        frame.setVisible(true);
        frame.setAlwaysOnTop (true);
        
    }

    /* ***********************************************
     *  Displays the current card to be matched
     * ***********************************************/
    public void DisplayCard(Card nextCard) {
      
        try {

            // nc is the next card played
            String nc = nextCard.toString();
        

            // dynamically get the folder structure 
            File currentDir = new File("");

            // concatinate the current application directory with the asset location 
            String folderPath = currentDir.getAbsolutePath() + "//Assets/Cards/";

            // handlers the current card being played.
            String fileName;
            if (nc.contains("Wild")) {
                fileName = "Wild.png";
            }else if (nc.contains("Draw")) {
                String number = nc.substring(0, nc.indexOf("(") - 1);
                String color = nc.substring(nc.indexOf("(") + 1, nc.indexOf(")"));
                fileName = color + "-" + number.replace(" ","") + ".png";
            }else{
                String number = nc.substring(0, nc.indexOf(" "));
                String color = nc.substring(nc.indexOf("(") + 1, nc.indexOf(")"));
                fileName = color + "-" + number + ".png";
            }
            
            BufferedImage image = ImageIO.read(new File(folderPath + fileName));
            JLabel label = new JLabel(new ImageIcon(resize(image, screenSize.width - dividerSize - 40, 350)));
            p.removeAll();
            p.add(label);

            // repaint the containers (the Jpanel)
            SwingUtilities.updateComponentTreeUI(frame);
        } catch(IOException ie) {
            ie.printStackTrace();
        }   
       
    }

    /* ***********************************************
     *  Cleans up the current players cards.
     * ***********************************************/
    public void DisplayCurrentPlayerReset(){
        p1.removeAll();
    }

    /* ***********************************************
     *  Dispalys the current players card
     * ***********************************************/
    public void DisplayCurrentPlayer(String currentCard, int idx) {

        // try catch handles the io exception in the even the file cannot be found.
        try {

            // This section matches the player card with the image file
            String fileName;
            if (currentCard.contains("Wild")) {
                fileName = "Wild.png";
            }else if (currentCard.contains("Draw")) {
                String number = currentCard.substring(0, currentCard.indexOf("(") - 1);
                String color = currentCard.substring(currentCard.indexOf("(") + 1, currentCard.indexOf(")"));
                fileName = color + "-" + number.replace(" ","") + ".png";
            }else{
                String number = currentCard.substring(0, currentCard.indexOf("(") - 1);
                String color = currentCard.substring(currentCard.indexOf("(") + 1, currentCard.indexOf(")"));
                fileName = color + "-" + number + ".png";
            }

            // dynamically get the folder structure 
            File currentDir = new File("");

            // concatinate the current application directory with the asset location 
            String folderPath = currentDir.getAbsolutePath() + "//Assets/Cards/";

            // buffer in the image
            BufferedImage image = ImageIO.read(new File(folderPath + fileName));

            // use the JLabel control to append an image icon
            JLabel label = new JLabel(new ImageIcon(resize(image, screenSize.width - dividerSize - 40, 350)));

            // add the image icon to the container. In this case it will be panel 1
            // use the second parameter to indicate an index on the panel for each image.
            // we use -2 because of the 0 based indices and the current index for the menu starts
            // with [0] being 'UNO' Violation and [1] being Draw Card
            p1.add(label, idx-2);

            // dynamically repaint the UI
            SwingUtilities.updateComponentTreeUI(frame);

        } catch(IOException ie) {
            System.out.println("File IO Error ------ " + currentCard);
            ie.printStackTrace();
        }   
        
    }

    /* ***********************************************
     *  This method resizes the buffered image. 
     * ***********************************************/
    public static BufferedImage resize(BufferedImage img, int newW, int newH) { 
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);
    
        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
    
        return dimg;
    }  

}




