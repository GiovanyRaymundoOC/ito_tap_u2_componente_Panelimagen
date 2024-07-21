package panelpng;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GuardarPanelComoImagen {
    
    public static void guardarPanelComoImagen(JPanel panel) {
        
        BufferedImage imagen = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = imagen.createGraphics();
        panel.paint(g2);
        g2.dispose();
        JFileChooser selectorArchivo = new JFileChooser();
        if (selectorArchivo.showSaveDialog(panel) == JFileChooser.APPROVE_OPTION) {
            File archivo = selectorArchivo.getSelectedFile();
            if (!archivo.getAbsolutePath().endsWith(".png")) {
                archivo = new File(archivo + ".png");
            }
            try {
                ImageIO.write(imagen, "png", archivo);
                JOptionPane.showMessageDialog(panel, "Imagen guardada con éxito.");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(panel, "Error al guardar la imagen: " + ex.getMessage());
            }
        }
    }
}