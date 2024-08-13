package org.example;
import org.example.diemntions.OneDimention;
import org.openimaj.image.DisplayUtilities;
import org.openimaj.image.ImageUtilities;
import org.openimaj.image.MBFImage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
                OneDimention oneDimention = new OneDimention(40, image.getWidth(), image.getHeight());
                ArrayList<Point> points = oneDimention.getPoints();
                for (int i = 0; i < points.size() - 1; i++) {
                    Point p1 = points.get(i);
                    Point p2 = points.get(i + 1);
                    image.drawLine(p1.x, p1.y, p2.x, p2.y, 1, new Float[]{1f, 0f, 0f});
//                    drawSmoothCurve(image, p1, p2);
                }
                DisplayUtilities.display(image);

            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, "Error reading or displaying the image", e);
            }
    }

//   private static void drawSmoothCurve(MBFImage image, Point p1, Point p2) {
//        int steps = 100; // Number of steps for smooth curve
//        for (int i = 0; i < steps; i++) {
//            double t = (double) i / (steps - 1);
//            double x = (1 - t) * p1.x + t * p2.x;
//            double y = (1 - t) * p1.y + t * p2.y + Math.sin(t * Math.PI) * (p2.y - p1.y) / 2; // Adjust the amplitude as needed
//            image.drawPoint(new org.openimaj.math.geometry.point.Point2dImpl((float) x, (float) y), new Float[]{1f, 0f, 0f}, 1);
//        }
//    }
}