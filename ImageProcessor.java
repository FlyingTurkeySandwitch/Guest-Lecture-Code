import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageProcessor {

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
                int new_rgb = (rgb & 0xFF000000) | (red << 16) | (green << 8) | blue;
                image.setRGB(x, y, new_rgb);
            }
        }
    }

    // 2. Grayscale (average method)
    static void grayscaleAverage(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int rgb = image.getRGB(x, y);
                int red = (rgb >> 16) & 0xFF;
                int green = (rgb >> 8) & 0xFF;
                int blue = rgb & 0xFF;
                int gray = red / 3 + green / 3 + blue / 3;
                image.setRGB(x, y, new Color(gray, gray, gray).getRGB());
            }
        }
    }

    // 3. Grayscale (weighted formula)
    static void grayscaleWeighted(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int rgb = image.getRGB(x, y);
                int red = (rgb >> 16) & 0xFF;
                int green = (rgb >> 8) & 0xFF;
                int blue = rgb & 0xFF;
                int gray = (int) (0.299 * red + 0.587 * green + 0.114 * blue);
                image.setRGB(x, y, new Color(gray, gray, gray).getRGB());
            }
        }
    }

    // 4. Remove gray component
    static void removeGray(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int rgb = image.getRGB(x, y);
                int red = (rgb >> 16) & 0xFF;
                int green = (rgb >> 8) & 0xFF;
                int blue = rgb & 0xFF;
                int min = Math.min(red, Math.min(green, blue));
                red -= min;
                green -= min;
                blue -= min;
                image.setRGB(x, y, new Color(red, green, blue).getRGB());
            }
        }
    }
}