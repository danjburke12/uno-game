import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.apache.batik.swing.JSVGCanvas;

public class PerceptionEngine {
    JFrame f = new JFrame("SVG Demo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 // Create a JSVGCanvas.
 JSVGCanvas svgCanvas = new JSVGCanvas();

 // Set the SVG document for the JSVGCanvas.
 svgCanvas.setDocument(new File("my-svg-file.svg"));
}