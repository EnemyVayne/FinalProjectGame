
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kylef
 */
public class Window extends Canvas
{
   public Window(int width, int height, String title, Game game){
      
      JFrame frame = new JFrame(title);
   
      frame.setPreferredSize(new Dimension(width,height));
      frame.setMaximumSize(new Dimension(width,height));
      frame.setMinimumSize(new Dimension(width,height));
      
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setResizable(false);
      frame.setLocationRelativeTo(null);
      frame.add(game);
      frame.setVisible(true);
      game.start();
   }
   
}
