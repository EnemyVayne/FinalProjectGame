
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
   private boolean wPush = false;
   private boolean sPush = false;
   private boolean aPush = false;
   private boolean dPush = false;

   public KeyInput( Handler handler )
   {
      this.handler = handler;
   }

   @Override
   public void keyPressed( KeyEvent e )
   {
      int key = e.getKeyCode();

      for ( int i = 0 ; i < handler.object.size() ; i++ )
      {
         GameObject tempObject = handler.object.get(i);

         if ( tempObject.getID() == ID.Player )
         {
            if ( key == KeyEvent.VK_W )
            {
               wPush = true;
               tempObject.setSpeedY(-3);
            }
            if ( key == KeyEvent.VK_A )
            {
               aPush = true;
               tempObject.setSpeedX(-3);
            }
            if ( key == KeyEvent.VK_S )
            {
               sPush = true;
               tempObject.setSpeedY(3);
            }
            if ( key == KeyEvent.VK_D )
            {
               dPush = true;
               tempObject.setSpeedX(3);
            }

         }
      }

   }

   @Override
   public void keyReleased( KeyEvent e )
   {

      int key = e.getKeyCode();

      for ( int i = 0 ; i < handler.object.size() ; i++ )
      {
         GameObject tempObject = handler.object.get(i);

         if ( tempObject.getID() == ID.Player )
         {
            if ( key == KeyEvent.VK_W )
            {
               wPush = false;  //new bug was introduced when adding these lines, the enemy moves at the same time as the player moves.
               if ( sPush )
               {
                  tempObject.setSpeedY(3);
               } else
               {
                  tempObject.setSpeedY(0);
               }
            }

         }
         if ( key == KeyEvent.VK_A )
         {
            aPush = false;
            if ( dPush )
            {
               tempObject.setSpeedX(3);;
            } else
            {
               tempObject.setSpeedX(0);
            }
         }
         if ( key == KeyEvent.VK_S )
         {
            sPush = false;
            if ( wPush )
            {
               tempObject.setSpeedY(-3);;
            } else
            {
               tempObject.setSpeedY(0);
            }
         }
         if ( key == KeyEvent.VK_D )
         {
            dPush = false;
            if ( aPush )
            {
               tempObject.setSpeedX(-3);;
            } else
            {
               tempObject.setSpeedX(0);
            }
         }

      }
   }
}

