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
	Integer curdir;
	ArrayList points=new ArrayList();
	ArrayList lines=new ArrayList();
	ArrayList<Rectangle> bullets=new ArrayList<Rectangle>();
	ArrayList<Integer> bulletsdir=new ArrayList<Integer>();
	ArrayList<Point> bulletlocation=new ArrayList<Point>();
	ArrayList border=new ArrayList();
		
	Timer timer=new Timer(1,this);
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
	
		prevPoint=(Point)points.get(0);
		//poly.addPoint(prevPoint.x, prevPoint.y);
	
		Iterator it=points.iterator();
		
		int p=points.size();
		for(int k=0;k<p;k++)
		{	
				/*if((Point)points.get(points.size()-1)!=null && points.size()>1)
				{
					p=p-1;
				
					if((Point)points.get(points.size()-2)!=null)
					{
						p=p-2;
					}
				}*/	
					//poly.addPoint(prevPoint.x, prevPoint.y);
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
				g2.setStroke(new BasicStroke(10));
				//if(Math.abs(prevPoint.x-curPoint.x)>Math.abs(prevPoint.y-curPoint.y))
					l=new Line2D.Float(prevPoint.x,prevPoint.y,curPoint.x,curPoint.y);
				//else
				//	l=new Line2D.Float(prevPoint.x,prevPoint.y,prevPoint.x,curPoint.y);
				/*if(Math.abs(prevPoint.x-curPoint.x)>Math.abs(prevPoint.y-curPoint.y))
				{
					l=new Line2D.Float(prevPoint.x,prevPoint.y,curPoint.x,prevPoint.y);
					//points.remove(points.size()-1);
					//points.add(curPoint.x,prevPoint.y);
				}
				else
				{
					l=new Line2D.Float(prevPoint.x,prevPoint.y,prevPoint.x,curPoint.y);
					points.remove(points.size()-1);
					points.add(prevPoint.x,curPoint.y);
				}*/
				//Line2D l=new Line2D.Float(prevPoint.x,prevPoint.y,curPoint.x,curPoint.y);
				//g2.drawLine(prevPoint.x,prevPoint.y,curPoint.x,curPoint.y);
				g2.draw(l);
				lines.add(l);
				prevPoint=curPoint;
				//poly.addPoint(prevPoint.x, prevPoint.y);
			}
			//else
			{
				//if(k+1<points.size())
					{
					//prevPoint=(Point)points.get(k+1);
					//z=1;
					}
			}
			/*if(polygonclose)
			{
				//g.drawLine(prevPoint.x,prevPoint.y,((Point)points.get(0)).x,((Point)points.get(0)).y);
				//g.drawPolygon(poly);
			}	
			else
			{
				//g.drawLine(prevPoint.x,prevPoint.y,trackPoint.x,trackPoint.y);
				g.fillRect(trackPoint.x-4,trackPoint.y-4,8,8);
			}*/
			
		}
		if(bullets.size()!=0)
		{
			border.add(new Line2D.Float(0,0,1300,0));
			border.add(new Line2D.Float(1300,0,1300,700));
			border.add(new Line2D.Float(1300,700,0,700));
			border.add(new Line2D.Float(0,700,0,0));

			for(int j=0;j<bullets.size();j++)
			{
				if(collision(lines,bullets.get(j)) || collision(border,bullets.get(j)))
				{
					bulletlocation.remove(j);
					bullets.remove(j);
					bulletsdir.remove(j);
				}
				
			}
			border.clear();
			for(int i=0;i<bullets.size();i++)
			{
				
				if(bulletsdir.get(i)==-1)
				{
					bulletlocation.get(i).x=bulletlocation.get(i).x-4;
					bulletlocation.get(i).y=bulletlocation.get(i).y;
					(bullets.get(i)).setLocation(bulletlocation.get(i));
					((Graphics2D)g).fill((Rectangle)(bullets.get(i)));
				}
				else if(bulletsdir.get(i)==1)
				{
					bulletlocation.get(i).x=bulletlocation.get(i).x+4;
					bulletlocation.get(i).y=bulletlocation.get(i).y;
					(bullets.get(i)).setLocation(bulletlocation.get(i));
					((Graphics2D)g).fill((Rectangle)(bullets.get(i)));
				}
				else if(bulletsdir.get(i)==-2)
				{
					bulletlocation.get(i).x=bulletlocation.get(i).x;
					bulletlocation.get(i).y=bulletlocation.get(i).y-4;
					(bullets.get(i)).setLocation(bulletlocation.get(i));
					((Graphics2D)g).fill((Rectangle)(bullets.get(i)));
				}
				else if(bulletsdir.get(i)==2)
				{
					bulletlocation.get(i).x=bulletlocation.get(i).x;
					bulletlocation.get(i).y=bulletlocation.get(i).y+4;
					(bullets.get(i)).setLocation(bulletlocation.get(i));
					((Graphics2D)g).fill((Rectangle)(bullets.get(i)));
				}
			}
		}
		g.setColor(Color.black);
		g.fillRect(0, 0, (x1-75), 850);
		g.fillRect(x1+225, 0, 1300, 850);
		g.fillRect(x1-75, 0, 300, y1-75);
		g.fillRect(x1-75, y1+225, 300, 850-y1+75);
		
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
			velx=-3;
			vely=0;
			curdir=-1;
		}
		if(c==KeyEvent.VK_RIGHT)
		{
			velx=3;
			vely=0;
			curdir=1;
		}
		if(c==KeyEvent.VK_UP)
		{
			velx=0;
			vely=-3;
			curdir=-2;
		}
		if(c==KeyEvent.VK_DOWN)
		{
			velx=0;
			vely=3;
			curdir=2;
		}
		if(c==KeyEvent.VK_SPACE)
		{
			Rectangle r=new Rectangle(x1+50,y1+50,50,50);
			bullets.add(r);
			bulletsdir.add(curdir);
			bulletlocation.add(new Point(x1+50,y1+50));
			//repaint();
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
		/*int c=event.getKeyCode();
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
		if(c==KeyEvent.VK_DOWN){
			velx=0;
			vely=10;
		}*/
		
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
				//lines.clear();
				//points.clear();
				//points.add(null);
				//polygonclose=false;
				
		//	}
		//	else
		//		{
		//		points.add(null);
		//		repaint();
		//		}
			//if(points.size()==0)
			//{	
			//	points.add(new Point(x,y));
			//	repaint();
			//}
			/*else if (Math.abs(x-prevPoint.x)>Math.abs(prevPoint.y-y))
			{
				points.add(new Point(x,prevPoint.y));
				repaint();
			}
			else
			{
				points.add(new Point(prevPoint.x,y));
				repaint();
			}*/
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
		
		/*for(int i=0;i<lines1.size();i++)
		{
			System.out.println((((Line2D)(lines1.get(i))).getX1()+" "+(((Line2D)(lines1.get(i))).getX2())));
			//System.out.println("Entered Loop");
			if((int)(((Line2D)(lines1.get(i))).getX1())==((int)(((Line2D)(lines1.get(i))).getX2())))
				{
				System.out.println("");
				dist=Math.abs((int)((Line2D)(lines1.get(i))).getX1()-p1.x);
				System.out.println(dist);
				}
			else if((int)(((Line2D)(lines1.get(i))).getY1())==((int)(((Line2D)(lines1.get(i))).getY2())))
				{
				System.out.println(dist);
				dist=Math.abs((int)((Line2D)(lines1.get(i))).getY1()-p1.y);
				}
			
		
			if(dist<160)
				{
				b1=false;
				break;
				}
			else
				b1=true;
		}*/	
		
		//return true;
	}

}	
	
public class move
{
	public static void main(String args[]){
		
		
		JFrame frame=new JFrame();
		JPanel p2=new JPanel(); 
		JLabel mov2=new moved();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//ImageIcon image=new ImageIcon("C:/Users/suraj/workspace/coen/src/winter/car.jpg"); 
		//JLabel label=new JLabel(image);
		//mov.add(label);
		//frame.setContentPane(label);
		
		
		p2.add(mov2);
		frame.setContentPane(mov2);
		//mov.add(label);
		
		//frame.add(mov);
		frame.setSize(1000,768);
		frame.setVisible(true);
		
	}
		
}
