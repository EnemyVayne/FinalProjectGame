
import java.awt.Color;
import java.awt.Graphics;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kylef
 */
public class Player extends GameObject
{

   public Player( int x, int y, ID id )
   {
      super(x, y, id);
      
      speedX = 1;
   }

   @Override
   public void tick()
   {
      x += speedX;
      y += speedY;
      
   }

   @Override
   public void render( Graphics g )
   {
      if( id == ID.Player)
      {
             g.setColor(Color.blue);       
      }
       g.fillOval(100, 100, 32, 32);

   }
   

}
