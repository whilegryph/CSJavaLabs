import java.awt.*;

public class CafeWall {

   public final static DrawingPanel panel = new DrawingPanel(650, 400);
   public final static Graphics g = panel.getGraphics();
   public final static int MORTAR = 2;

   public static void main(String[] args) {
      g.setColor(Color.GRAY);
      g.fillRect(0, 0, 650, 400);
      singleRow(0, 0, 4, 20);
      singleRow(50, 70, 5, 30);
      grid(10, 150, 4, 25, 0);
      grid(250, 200, 3, 25, 10);
      grid(425, 180, 5, 20, 10);
      grid(400, 20, 2, 35, 35);
   }
   // prints a row of pairs of 2 different colored squares
   public static void singleRow(int x, int y, int pairsNum, int boxSize) {
      for (int i = 1, side = 0; i <= pairsNum; i++) {
         g.setColor(Color.BLACK);
         g.fillRect(x + side, y, boxSize, boxSize);
         g.setColor(Color.BLUE);
         g.drawLine(x + side + boxSize, y, x + side, y + boxSize);
         g.drawLine(x + side, y, x + side + boxSize, y + boxSize);
         g.setColor(Color.WHITE);
         g.fillRect(x + side + boxSize, y, boxSize, boxSize);
         side += 2*boxSize;
      }
   }
   // prints several single rows of pairs of squares, 
   // with each row being offset from the position of the previous row
   public static void grid(int x, int y, int pairsNum, int boxSize, int offset) {
      for (int i = 1, down = 0; i <= pairsNum; i++) {
         singleRow(x, y + down + (2 * MORTAR * (i - 1)), pairsNum, boxSize);
         singleRow(x + offset, y + boxSize + down + MORTAR + (2 * MORTAR * (i - 1)), pairsNum, boxSize);
         down += 2*boxSize;
      }
   }
}
