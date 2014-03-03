package model;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class EscaladorThread extends JLabel implements Runnable {
    private Thread escaladorThread = null;
    private int posX;
    private int posY;
  
	private ImageIcon imagem;
 
    public EscaladorThread(String nomeEscalador, ImageIcon img, int posX, int posY){
    super(img);
    this.imagem = img;
    this.posX = posX;
    this.posY = posY;
  
    escaladorThread = new Thread(this, nomeEscalador);
    escaladorThread.start();
    
    }

   
    public void run() {
        posX += new Random().nextInt(3) * 10;
        this.setLocation(posX, posY);
        //imagem.getIconHeight();

        if (posX >= 1280)
            return;

        try {
            Thread.sleep(new Random().nextInt(5) * 10);
            run();
        } catch (Exception e) {
            e.printStackTrace();
        }
   }
}
