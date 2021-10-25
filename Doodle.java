import java.awt.*;

public class Doodle {

   public final static DrawingPanel panel = new DrawingPanel(650, 400);
   public final static Graphics g = panel.getGraphics();

   public static void main(String[] args) {
      
      g.setColor(Color.PINK);
      g.fillRect(0, 0, 650, 400);
      g.setColor(Color.WHITE);
      g.drawOval(325, 50, 50, 50);
      g.drawOval(325, 315, 50, 50);
      g.setColor(Color.GREEN);
      g.drawRect(285, 215, 125, 125);
      g.setColor(Color.RED);
      g.drawLine(350, 80, 285, 205);
      g.drawLine(350, 80, 410, 205);
      g.drawLine(285, 205, 410, 205);
      
   }
}
