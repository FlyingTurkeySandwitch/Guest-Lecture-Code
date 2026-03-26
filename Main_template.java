
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Main_template {
    public static void main(String[] args) throws IOException {
        String inputPath = "";
        String outputPath = "";

        // Test each function — comment/uncomment as needed
        BufferedImage image;


        image = ImageProcessor.loadImage(inputPath);
        ImageProcessor.invert(image);
        ImageProcessor.saveImage(image, outputPath + "output_invert.jpeg");

        image = ImageProcessor.loadImage(inputPath);
        ImageProcessor.grayscaleAverage(image);
        ImageProcessor.saveImage(image, outputPath + "output_grayscale_avg.jpeg");

        image = ImageProcessor.loadImage(inputPath);
        ImageProcessor.grayscaleWeighted(image);
        ImageProcessor.saveImage(image, outputPath + "output_grayscale_weighted.jpeg");

        image = ImageProcessor.loadImage(inputPath);
        ImageProcessor.removeGray(image);
        ImageProcessor.saveImage(image, outputPath + "output_removegray.jpeg");
    }
}