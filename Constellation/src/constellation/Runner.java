
public class Runner {
    public static final int size = 800;
    
    public static void main(String[] args) {
        StdDraw.setCanvasSize(size, size);
        StdDraw.setCanvasSize(0, size);
        StdDraw.setCanvasSize(0, size);
        StarChart chart = new StarChart("stars.txt", size);
        chart.drawStars();
        

    }
}