package winter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.lang.Math.*;

import javax.swing.*;
class moved extends JLabel implements ActionListener,KeyListener,MouseMotionListener,MouseListener
{

	Point prevPoint;
	Point curPoint;
	boolean polygonclose;
	Point trackPoint=new Point();
	Graphics2D g2;
	
	int x,y;
	int z=0;
	int tempx1,tempy1;

	ArrayList points=new ArrayList();
	ArrayList lines=new ArrayList();
	
	
	Timer timer=new Timer(10,this);
	int x1=0,y1=0,velx=0,vely=0;
	public moved()
	{
		super();
		timer.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		addMouseMotionListener(this);
		addMouseListener(this);
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);

		Image image1=new ImageIcon("C:/Users/suraj/workspace/coen/src/winter/dot.png").getImage();
	
		Image image=new ImageIcon("C:/Users/suraj/workspace/coen/src/winter/sf.jpg").getImage();
		g.drawImage(image,0,0,this);
		//g.setColor(Color.RED);
		//g.fillOval(x,y,50,30);
		g.drawImage(image1,x1,y1,this);
	
	
		Polygon poly=new Polygon();
		super.paintComponent(g);
		int numpoints=points.size();
		g.setColor(Color.red);
		g.fillRect(x-4, y-4, 8, 8);
		if(numpoints==0)
		{
			return;
		}
	
		prevPoint=(Point) points.get(0);
		//poly.addPoint(prevPoint.x, prevPoint.y);
	
		Iterator it=points.iterator();
		
		int p=points.size();
		for(int k=0;k<p;k++)
		{	
			if((Point)points.get(k)!=null)
			{
				/*	prevPoint=(Point)points.get(++k);
					curPoint=(Point)points.get(++k);
				}*/
				//prevPoint=(Point)points.get(k);
				curPoint=(Point)points.get(k);
				g.setColor(Color.red);
				g.fillRect(prevPoint.x-4, prevPoint.y-4, 8, 8);
				g.fillRect(curPoint.x-4, curPoint.y-4, 8, 8);
				g2=(Graphics2D)g;
				Line2D l;
				//g2.setStroke(new BasicStroke(20));
				//if(Math.abs(prevPoint.x-curPoint.x)>Math.abs(prevPoint.y-curPoint.y))
					l=new Line2D.Float(prevPoint.x,prevPoint.y,curPoint.x,curPoint.y);
				
				g2.draw(l);
				lines.add(l);
				prevPoint=curPoint;
				//poly.addPoint(prevPoint.x, prevPoint.y);
			}
			else
			{
				if(k+1<points.size())
					{
					prevPoint=(Point)points.get(k+1);
					//z=1;
					}
			}
		
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent event) 
	{
		if(x1<0)
		{
			velx=0;
			x1=0;
		}
		
		if(x1>1300)
		{
			velx=0;
			x1=1300;
		}
		
			
		
		if(y1<0) 
		{
			vely=0;
			y1=0;
		}
		if(y1>700) 
		{
			vely=0;
			y1=700;
		}
		if (!(collision(lines,new Rectangle(x1,y1,150,150))))
		{
			tempx1=x1;
			tempy1=y1;
		}
		if(x1>tempx1 && (collision(lines,new Rectangle(x1,y1,150,150))))
		{
			
			velx=0;
			x1=tempx1;
			/*if(velx>0)
			{
				velx=velx-9;
			}
			else
				velx=velx+9;*/
		}

		else if(x1<tempx1 && (collision(lines,new Rectangle(x1,y1,150,150))))
		{
			
			velx=0;
			x1=tempx1;
			/*if(velx>0)
			{
				velx=velx-9;
			}
			else
				velx=velx+9;*/
		}
		
		else if(y1<tempy1 && (collision(lines,new Rectangle(x1,y1,150,150))))
		{	
			vely=0;
			y1=tempy1;
			/*if(vely>0)
			{
				vely=vely-9;
			}
			else
				vely=vely+9;*/
			
		}
		else if(y1>tempy1 && (collision(lines,new Rectangle(x1,y1,150,150))))
		{	
			vely=0;
			y1=tempy1;
			/*if(vely>0)
			{
				vely=vely-9;
			}
			else
				vely=vely+9;*/
			
		}
		x1=x1+velx;
		y1=y1+vely;
		repaint();
		
		//System.out.println("ffff");
	}

	@Override
	public void keyPressed(KeyEvent event) 
	{
		int c=event.getKeyCode();
		if(c==KeyEvent.VK_LEFT)
		{
			velx=-10;
			vely=0;
		}
		if(c==KeyEvent.VK_RIGHT)
		{
			velx=10;
			vely=0;
		}
		if(c==KeyEvent.VK_UP)
		{
			velx=0;
			vely=-10;
		}
		if(c==KeyEvent.VK_DOWN)
		{
			velx=0;
			vely=10;
		}
	
	}

	@Override
	public void keyReleased(KeyEvent event) 
	{
		//timer.stop();
		velx=0;
		vely=0;
		
	}

	@Override
	public void keyTyped(KeyEvent event) 
	{
		
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		x=e.getX();
		y=e.getY();
		
		if(SwingUtilities.isLeftMouseButton(e))
		{
			Point tempPoint;
		//	if(polygonclose==true)
		//	{
			if(points.size()==0)
			{
				
				tempPoint=new Point(x,y);
				if((distance(lines,tempPoint)))
				{	
					//System.out.println("Point added");
					points.add(new Point(x,y));
					
				}
				repaint();
			}
			else if (z==1)
			{
				points.add(new Point(x,y));
				repaint();
				z=0;
			}
			else if (Math.abs(x-prevPoint.x)>Math.abs(prevPoint.y-y))
			{	
				tempPoint=new Point(x,y);
				if((distance(lines,tempPoint)))
				{
					//System.out.println("Point added");
					points.add(new Point(x,prevPoint.y));
				}
				repaint();
			}
			else
			{
				tempPoint=new Point(x,y);
				if((distance(lines,tempPoint)))
				{
				//	System.out.println("Point added");
					points.add(new Point(prevPoint.x,y));
				}
				repaint();
				
			}
		}	
		else
		{
			points.add(null);
			z=1;
			//polygonclose=true;
			//repaint();
		}

		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		x=e.getX();
		y=e.getY();
		repaint();
	}
	public boolean collision(ArrayList lin,Rectangle rect )
	{
		Line2D templine;
		int j=0;
		for(int i=0;i<lin.size();++i)
		{
			templine=(Line2D)lin.get(i);
			if(rect.intersectsLine(templine))
			{
				j++;
			}
		}
		if(j>0)
			return true;
		else
			return false;
	
	}
	
	
	public boolean distance(ArrayList lines1,Point p1)
	{
		//int dist=0;
		boolean b1=true;
		//System.out.println("Entered fn");
		if((Math.abs((p1.x)-1300)<160) ||(Math.abs((p1.x)-0)<160)||(Math.abs((p1.y)-700)<160)||(Math.abs((p1.y)-0)<160))
		{
			//System.out.println("Entered If");
			b1=false;
			return b1;
		}
		else
			return true;
		
	
	}

}	
	
public class trial1
{
	public static void main(String args[]){
		
		
		JFrame frame=new JFrame();
		JPanel p2=new JPanel(); 
		JLabel mov=new moved();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//ImageIcon image=new ImageIcon("C:/Users/suraj/workspace/coen/src/winter/car.jpg"); 
		//JLabel label=new JLabel(image);
		//mov.add(label);
		//frame.setContentPane(label);
		
		
		p2.add(mov);
		frame.setContentPane(mov);
		//mov.add(label);
		
		//frame.add(mov);
		frame.setSize(1000,768);
		frame.setVisible(true);
		
	}
		
}
