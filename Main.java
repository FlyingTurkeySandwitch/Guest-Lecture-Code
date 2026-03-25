
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String inputPath = "/Users/dannykim/Desktop/vscode/COMP131_TA/Guest-Lecture-Code/oxyphoto.jpeg";
        String outputPath = "/Users/dannykim/Desktop/vscode/COMP131_TA/Guest-Lecture-Code/";

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