package org.example;
import org.example.diemntions.OneDimention;
import org.openimaj.image.DisplayUtilities;
import org.openimaj.image.ImageUtilities;
import org.openimaj.image.MBFImage;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import java.util.logging.Logger;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
        private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args)  {
        try {
                // Read the image from a file
                File imageFile = new File("1d.jpg");

                if (!imageFile.exists()) {
                    LOGGER.log(Level.SEVERE, "Image file not found: " + imageFile.getAbsolutePath());
                    return;
                }
                MBFImage image = ImageUtilities.readMBF(imageFile);
//                Point2d tl = new Point2dImpl(10, 10);
//                Point2d bl = new Point2dImpl(10, image.getHeight() - 10);
//                Point2d br = new Point2dImpl(image.getWidth() - 10, image.getHeight() - 10);
//                Point2d tr = new Point2dImpl(image.getWidth() - 10, 10);
//                            // Display the image
                OneDimention oneDimention = new OneDimention(10, image.getWidth(), image.getHeight());
//                image.drawConnectedPoints(Arrays.asList(tl, bl, br, tr, tl), new Float[] {1f, 0f, 0f});
                DisplayUtilities.display(image);

            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, "Error reading or displaying the image", e);
            }
    }
}