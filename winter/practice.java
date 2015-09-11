package winter;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton; 
import javax.swing.JFrame;
import javax.swing.JPanel;

public class practice implements ActionListener,KeyListener,MouseListener {
	JPanel panel2;
	JButton button2;
	JButton button1;
	JButton button3;
	public practice(){
	JFrame frame2 =new JFrame();
	 button2=new JButton();	
	 panel2=new JPanel();
	button2.addActionListener(this);
	button2.addKeyListener(this);
	button2.addMouseListener(this);
	
	button2.setText("button is open")	;
	panel2.add(button2);
	frame2.setContentPane(panel2);
	frame2.setVisible(true);
	
	
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	 button1=new JButton();
	button2.add(button1);
	button1.setText("u clicked on the button");
	System.out.println("action performed");
	}

	public static void main(String args[]){
		practice prac=new practice();
		System.out.println("hello");
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int c=e.getKeyCode();
		if(c==KeyEvent.VK_LEFT){
			 button3=new JButton();
			button2.add(button3);
			button3.setText("u clicked on the button 2nd time");	// TODO Auto-generated method stub
			System.out.println("key pressed");
		}
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	//	 button3=new JButton();
	//		button2.add(button3);
		//	button3.setText("u clicked on the button 2nd time using mouse");	// TODO Auto-generated method stub
		//	System.out.println("mouse entered ");// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
