package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.EscaladorThread;

public class Janela extends JFrame implements ActionListener {

    private JButton btnIniciar;
    private JButton btnCancel;
    private JLabel lblMuro;
    private ImageIcon imgAlpinista1;
    private ImageIcon imgAlpinista2;
    private ImageIcon imgAlpinista3;
    private ImageIcon muro;
    
    
    public Janela() {
        super();
             
        this.setLayout(null);
        this.setSize(1280, 650);
        
        //define o posicionamento da janela.
        this.setLocation(50, 50);
        this.setResizable(false);
        getContentPane().setBackground(Color.white);
        
        this.setTitle("Alpinismo 2014");
        muro = new ImageIcon("./src/imagens/muro.jpg");
        
        this.lblMuro = new JLabel(muro);
        this.lblMuro.setBounds(0, 0, 1280, 650);
        this.add(lblMuro);
        
        //criar uma instancia do botão e dar nome
        this.btnIniciar = new JButton("Iniciar");
        this.btnCancel = new JButton("Parar");
        
        //para posicionar os botões na janela
        this.btnIniciar.setBounds(500, 550, 120, 50);
        this.btnCancel.setBounds(640, 550, 120, 50);
                 
        //instanciar as imagens
        imgAlpinista1 = new ImageIcon("./src/imagens/escalador1.png");
        imgAlpinista2 = new ImageIcon("./src/imagens/spiderman.jpg");
        imgAlpinista3 = new ImageIcon("./src/imagens/batman.jpg");
        
        this.lblMuro.add(btnIniciar);
        this.lblMuro.add(btnCancel);

        this.setVisible(true);

        btnIniciar.addActionListener(this);
        btnCancel.addActionListener(this);

        JPanel jPanel = new JPanel();
        jPanel.setSize(200, 70);
        jPanel.setLayout(null);
        jPanel.setLocation(970, 510);
        jPanel.setVisible(true);

        this.repaint();

    }
  
     public JLabel JLabelEscaladores(String nomeEscalador, ImageIcon img, int posX, int posY) {
        EscaladorThread escalador = new EscaladorThread(nomeEscalador, img, posX, posY);
        escalador.setSize (256 , 141);
        escalador.setVisible(true);
        this.add(escalador);
        return escalador;
    }
      
  
    public void actionPerformed(ActionEvent dispara) {
        if (dispara.getSource() == this.btnIniciar) {
        
            this.lblMuro.add(JLabelEscaladores("Escalador1", imgAlpinista1, 0, 100));
            this.lblMuro.add(JLabelEscaladores("spiderman", imgAlpinista2, 0, 230));
            this.lblMuro.add(JLabelEscaladores("batman", imgAlpinista3, 0, 350));
        }
        if (dispara.getSource() == this.btnCancel) {
            System.exit(0);
        }
    }
}
