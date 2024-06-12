
import java.util.concurrent.ThreadLocalRandom;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Constellation {

    private static final int WINDOW_SIZE = 500;
    private static final int ORIGIN = WINDOW_SIZE / 2;
    private static final int MAX_COORD = WINDOW_SIZE / 2;

    public void drawStars(Graphics sky) throws FileNotFoundException {
        Scanner sfile = new Scanner(new File("stars.txt"));
        double x, y, z, magnitude;
        sky.setColor(Color.white);

        while (sfile.hasNextDouble()) {
            x = sfile.nextDouble();
            y = sfile.nextDouble();
            z = sfile.nextDouble();
            sfile.nextInt();
            magnitude = sfile.nextDouble();
            sfile.nextInt();
            if (z > 0) {
                int px = coord2Pixel(x);
                int py = coord2Pixel(-y); //negate y since screen coordinates and world coordinates work opposite
//System.out.println("x = " + x + ", px = " +px + " y = " + y + ", py = " + py);
                int size = (int) (5.0 - magnitude) + 1;
                sky.fillRect(px, py, size, size);
            }
        }
        sfile.close();
        drawConstellations(sky);
    }

    public void drawConstellations(Graphics sky) throws FileNotFoundException {
        Scanner sfile = new Scanner(new File("constellations.txt"));
        double x1, y1, x2, y2;
        sky.setColor(Color.white);
        while (sfile.hasNextDouble()) {
            x1 = sfile.nextDouble();
            y1 = sfile.nextDouble();
            x2 = sfile.nextDouble();
            y2 = sfile.nextDouble();
            int px1 = coord2Pixel(x1);
            int py1 = coord2Pixel(-y1);
            int px2 = coord2Pixel(x2);
            int py2 = coord2Pixel(-y2);

            sky.drawLine(px1, py1, px2, py2);
        }
        sfile.close();
    }

    private int coord2Pixel(double coord) {
        return (int) (ORIGIN + coord * MAX_COORD);
    }

    public static void main(String[] args) {
        StarFrame window = new StarFrame();
        Stars stars = new Stars();
        try {
            stars.drawStars(window.getGraphics());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
