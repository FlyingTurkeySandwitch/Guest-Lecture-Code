import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageProcessor_template {

    // Helper to load image
    static BufferedImage loadImage(String path) throws IOException {
        return ImageIO.read(new File(path));
    }

    // Helper to save image
    static void saveImage(BufferedImage image, String path) throws IOException {
        ImageIO.write(image, "jpeg", new File(path));
    }

    // 1. Invert
    static void invert(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int rgb = image.getRGB(x, y);
                int red = (rgb >> 16) & 0xFF;
                int green = (rgb >> 8) & 0xFF;
                int blue = rgb & 0xFF;

                red = 255 - red;
                green = 255 - green;
                blue = 255 - blue;
                image.setRGB(x, y, new Color(red, green, blue).getRGB());
            }
        }
    }

    // 2. Grayscale (average method)
    static void grayscaleAverage(BufferedImage image) {
        
    }

    // 3. Grayscale (weighted formula)
    static void grayscaleWeighted(BufferedImage image) {
        
    }

    // 4. Remove gray component
    static void removeGray(BufferedImage image) {
        
    }
}