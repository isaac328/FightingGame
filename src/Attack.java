import java.util.Random;

import javax.swing.JOptionPane;

public class Attack {
   // fields
   private static final Random rand = new Random();
   
   // constructors
   
   //methods
   public static void punch(Player p) {
      int punchHitRate = rand.nextInt(100) + 1;
      if(punchHitRate >= 0 && punchHitRate <= 90)
         MainWindow.decreaseHealth(p, 5);
      else
    	  JOptionPane.showMessageDialog(null, "Attack Missed", "Sorry", JOptionPane.PLAIN_MESSAGE);
    	  
   }
   
   public static void kick(Player p) {
      int kickHitRate = rand.nextInt(100) + 1;
      if(kickHitRate >= 0 && kickHitRate <= 70)
         MainWindow.decreaseHealth(p, 15);
      else
    	  JOptionPane.showMessageDialog(null, "Attack Missed", "Sorry", JOptionPane.PLAIN_MESSAGE);
   }
   
   public static void special1(Player p) {
      int special1HitRate = rand.nextInt(100) + 1;
      if(special1HitRate >= 0 && special1HitRate <= 40)
         MainWindow.decreaseHealth(p, 30);
      else
    	  JOptionPane.showMessageDialog(null, "Attack Missed", "Sorry", JOptionPane.PLAIN_MESSAGE);
   }
   
   public static void special2(Player p) {
      int special2HitRate = rand.nextInt(100) + 1;
      if(special2HitRate >= 0 && special2HitRate <= 5)
         MainWindow.decreaseHealth(p, 90);
      else
    	  JOptionPane.showMessageDialog(null, "Attack Missed", "Sorry", JOptionPane.PLAIN_MESSAGE);
   }
}