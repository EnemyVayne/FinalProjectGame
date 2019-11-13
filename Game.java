
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kylef
 */
public class Game extends Canvas implements Runnable
{

   public static final int WIDTH = 1000;
   public static final int HEIGHT = 1440;

   private Thread thread;
   private boolean running = false;
   
   private Handler handler;

   Game()
   {
      handler = new Handler();
      this.addKeyListener(new KeyInput(handler));
      
      new Window(HEIGHT, WIDTH, "FinalProject", this);
      
      handler.addObject(new Player(100, 100, ID.Player));
      handler.addObject(new Player(200, 100, ID.Player));
      
   }

   public synchronized void start()
   {
      thread = new Thread(this);
      thread.start();
      running = true;
   }

   public synchronized void stop()
   {
      try
      {
         thread.join();
         running = false;
      } catch ( Exception e )
      {
         e.printStackTrace();
      }
   }

   public void run()
   {
      long lastTime = System.nanoTime();
      double amountOfTicks = 60.0;
      double ns = 1000000000 / amountOfTicks;
      double delta = 0;
      long timer = System.currentTimeMillis();
      int frames = 0;
      while ( running )
      {
         long now = System.nanoTime();
         delta += (now - lastTime) / ns;
         lastTime = now;
         while ( delta >= 1 )
         {
            tick();
            delta--;
         }
         if ( running )
         {
            render();
         }
         frames++;

         if ( System.currentTimeMillis() - timer > 1000 )
         {
            timer += 1000;
            System.out.println("FPS: " + frames);
            frames = 0;
         }
      }
      stop();
   }
   
   private void tick()
   {
      handler.tick();
   }
   
   private void render()
   {
      BufferStrategy bs = this.getBufferStrategy();
      if(bs == null)
      {
         this.createBufferStrategy(3);
         return;
      }
      Graphics g = bs.getDrawGraphics();
      

      
      g.setColor(Color.white);
      g.fillRect(0, 0, HEIGHT, WIDTH);
      
      handler.render(g); 
            
      g.dispose();
      bs.show();
   }

   public static void main( String args[] )
   {
      new Game();
   }

}
