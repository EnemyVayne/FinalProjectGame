
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kylef
 */
public class KeyInput extends KeyAdapter
{
   private Handler handler;
   
   public KeyInput(Handler handler)
   {
      this.handler = handler;
   }
   
   
   
   @Override
   public void keyPressed(KeyEvent e)
   {
      int key = e.getKeyCode();

      for(int i = 0; i < handler.object.size(); i++)
      {
         GameObject tempObject = handler.object.get(i);
         
         if(tempObject.getID() == ID.Player )
         {
            if(key == KeyEvent.VK_W)
            {
               tempObject.setSpeedY(3);
            }
            if(key == KeyEvent.VK_A)
            {
               tempObject.setSpeedX(-3);
            }
            if(key == KeyEvent.VK_S)
            {
               tempObject.setSpeedY(-3);
            }
            if(key == KeyEvent.VK_D)
            {
               tempObject.setSpeedX(3);
            }
            
         }
      }
      
      
   }
   @Override
   public void keyReleased(KeyEvent e)
   {
      
      
   }
   
}
