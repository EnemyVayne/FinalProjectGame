
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
public class Enemy extends GameObject
{
   
   public Enemy( int x, int y, ID id )
   {
      super(x, y, id);
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

      g.setColor(Color.red);
      g.fillRect(x, y, 32, 32);

   }
   
}
