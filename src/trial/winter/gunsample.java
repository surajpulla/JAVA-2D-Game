package winter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class gunsample {
	//static int x=0;

  public static void main(String[] args) {
	  ImageIcon image1=new ImageIcon("C:/Users/suraj/workspace/coen/src/winter/hqdefault.jpg");
	  
	    JFrame frame1=new JFrame();
	    JLabel label1=new JLabel(image1);
	    JLabel label2=new JLabel(image1);
	    JPanel panel1=new JPanel();
	   
	    frame1.setLayout(null);
	    panel1.setLayout(null); 
	    panel1.add(label1);
	    panel1.add(label2);
	   // label1.setBounds(0,0,150,150);
	    frame1.setContentPane(panel1);
	    frame1.setVisible(true);
	    frame1.setSize(1000,1000);
	    frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Timer timer = new Timer(100, new MyTimerActionListener(label1,label2));
    
    timer.start();
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
    }
    timer.stop();
  }

}

 class MyTimerActionListener implements ActionListener {
	JLabel l;
	JLabel ll;
	static int x=0;
	//static int y=0;
	public MyTimerActionListener(JLabel l1)
	{
		l=l1;
	}
	public MyTimerActionListener(JLabel l1,JLabel l2)
	{
		l=l1;
		ll=l2;
	}
  public void actionPerformed(ActionEvent e) {
	  x+=10;
	 //  y=y+10;
	l.setBounds(x,0,500,75);
	 if(ll!=null)
	  ll.setBounds(x,75,500,75);
    System.out.println("asdf");

  }
}