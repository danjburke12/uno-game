package src;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ResizableImagePanel extends JPanel {

    private Image img;

    public ResizableImagePanel() {
    }

    public void setImage(Image value) {
        
        // if (img != value) {
        //     Image old = img;
        //     this.img = value;
        //     firePropertyChange("image", old, img);
        //     revalidate();
        //     repaint();
            try {
                BufferedImage image = ImageIO.read(new File("C://Users//quinc//OneDrive//Desktop//Test//lib//Blue.png"));
                JLabel label = new JLabel(new ImageIcon(image));
            } catch(IOException ie) {
                ie.printStackTrace();
            }   
        //}
    }
}