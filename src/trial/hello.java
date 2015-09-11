package trial;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.lang.Math.*;
import javax.swing.*;

/**
 * 
 * @author suraj,Raja
 *hello1 is the JLabel in which game is run
 */
class hello1 extends JLabel implements ActionListener,KeyListener,MouseMotionListener,MouseListener
{	
	//First 204 lines contain only initializing or declaration of variables
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	int totaltimevar=0;																					//
	long totalstarttime=0;																				//
	long totaltime=0;																					//
																										
	boolean fog=false;
	int numberbullets=15;
	
	int counter=0;
	long winnerstarttime=0;
	long winnertimer=0;
	int directionchanger=0;
	
	long bot1bulletstarttimer=0;
	long bot1bullettimer=0;

	long bot2bulletstarttimer=0;
	long bot2bullettimer=4000;
	
	long bot3bulletstarttimer=0;
	long bot3bullettimer=0;
	
	ArrayList<Image> upimage=new ArrayList<Image>();
	int upimagechanger=0;
	long upstarttime=0;
	long uptimer=0;
	
	ArrayList<Image> downimage=new ArrayList<Image>();
	int downimagechanger=0;
	long downstarttime=0;
	long downtimer=0;
	
	ArrayList<Image> leftimage=new ArrayList<Image>();
	int leftimagechanger=0;
	long leftstarttime=0;
	long lefttimer=0;
	
	ArrayList<Image> rightimage=new ArrayList<Image>();
	int rightimagechanger=0;
	long rightstarttime=0;
	long righttimer=0;
	
	ArrayList<Image> northeastcreepimage=new ArrayList<Image>();
	int northeastcreepimagechanger=0;
	long northeastcreepstarttime=0;
	long northeastcreeptimer=800;

	int northeastcreepimagechanger1=0;
	long northeastcreepstarttime1=0;
	long northeastcreeptimer1=800;
	
	ArrayList<Image> northwestcreepimage=new ArrayList<Image>();
	int northwestcreepimagechanger=0;
	long northwestcreepstarttime=0;
	long northwestcreeptimer=800;

	int northwestcreepimagechanger1=0;
	long northwestcreepstarttime1=0;
	long northwestcreeptimer1=800;

	ArrayList<Image> southeastcreepimage=new ArrayList<Image>();
	int southeastcreepimagechanger=0;
	long southeastcreepstarttime=0;
	long southeastcreeptimer=800;
	
	int southeastcreepimagechanger1=0;
	long southeastcreepstarttime1=0;
	long southeastcreeptimer1=800;
	
	ArrayList<Image> southwestcreepimage=new ArrayList<Image>();
	int southwestcreepimagechanger=0;
	long southwestcreepstarttime=0;
	long southwestcreeptimer=800;
	
	int southwestcreepimagechanger1=0;
	long southwestcreepstarttime1=0;
	long southwestcreeptimer1=800;
	
	ArrayList<Image> northeastbossimage=new ArrayList<Image>();
	int northeastbossimagechanger=0;
	long northeastbossstarttime=0;
	long northeastbosstimer=800;
	
	ArrayList<Image> northwestbossimage=new ArrayList<Image>();
	int northwestbossimagechanger=0;
	long northwestbossstarttime=0;
	long northwestbosstimer=800;

	ArrayList<Image> southeastbossimage=new ArrayList<Image>();
	int southeastbossimagechanger=0;
	long southeastbossstarttime=0;
	long southeastbosstimer=800;

	ArrayList<Image> southwestbossimage=new ArrayList<Image>();
	int southwestbossimagechanger=0;
	long southwestbossstarttime=0;
	long southwestbosstimer=800;
	
	int velocitybotx1=0;
	int velocitybotx2=0;
	int velocitybotx3=0;
	int velocityboty1=0;
	int velocityboty2=0;
	int velocityboty3=0;
		
	long walltime;
	long startTime;
	
	long botTimer1;
	long botStartTimer1;
	
	int randmovement1=30;
	int randmovement2=60;
	int randmovement3=10;
	
	long botTimer2;
	long botStartTimer2;
	
	long botTimer3;
	long botStartTimer3;
	
	int temprandx1,temprandy1=0;
	int temprandx2,temprandy2=0;
	int temprandx3,temprandy3=0;

	int randx1,randy1=2000;
	int randx2,randy2=3000;
	int randx3,randy3=4000;
	Point prevPoint;
	Point curPoint;
	boolean polygonclose;
	Point trackPoint=new Point();
	Graphics2D g2;
	
	Rectangle bot1;
	Rectangle bot2;
	Rectangle bot3;
	
	boolean botcollision1=false;
	boolean botcollision2=false;
	boolean botcollision3=false;
	
	int homescreenchange=1;
	int homescreenx,homescreeny;
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
	Random rand = new Random();
	
	ArrayList<Rectangle> enemybullets=new ArrayList<Rectangle>();
	ArrayList<Integer> enemybulletsdir=new ArrayList<Integer>();
	ArrayList<Point> enemybulletlocation=new ArrayList<Point>();

	ArrayList<Rectangle> bossbullets=new ArrayList<Rectangle>();
	ArrayList<Integer> bossbulletsdir=new ArrayList<Integer>();
	ArrayList<Point> bossbulletlocation=new ArrayList<Point>();

	
	Image bossbullet=new ImageIcon("winter/bossbullet.PNG").getImage();
	Image creepbullet=new ImageIcon("winter/enemybulletgreen.PNG").getImage();
																														//
	Timer timer=new Timer(15,this);																						//
	int x1=0,y1=0,velx=0,vely=0;																						//
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public hello1()
	{
		super();
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		upimage.add(new ImageIcon("winter/upleft1.PNG").getImage());		//Images of Player moving up
		upimage.add(new ImageIcon("winter/upstanding.PNG").getImage());	//
		upimage.add(new ImageIcon("winter/upright.PNG").getImage());		//
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		downimage.add(new ImageIcon("winter/downleft1.PNG").getImage());		//
		downimage.add(new ImageIcon("winter/downstanding.PNG").getImage());	//Images of Player moving down
		downimage.add(new ImageIcon("winter/downright.PNG").getImage());		//
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		leftimage.add(new ImageIcon("winter/leftleft1.PNG").getImage());		//
		leftimage.add(new ImageIcon("winter/leftstanding.PNG").getImage());	//Images of player moving left
		leftimage.add(new ImageIcon("winter/leftright.PNG").getImage());		//
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		rightimage.add(new ImageIcon("winter/rightleft1.PNG").getImage());	//
		rightimage.add(new ImageIcon("winter/rightstanding.PNG").getImage());	//Images of Player moving right
		rightimage.add(new ImageIcon("winter/rightright.PNG").getImage());	//
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		northeastcreepimage.add(new ImageIcon("winter/enemyleftlegupright.PNG").getImage());	//
		northeastcreepimage.add(new ImageIcon("winter/northeaststanding.PNG").getImage());	//Images of alien moving northeast
		northeastcreepimage.add(new ImageIcon("winter/enemyrightlegupright.PNG").getImage());//
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		northwestcreepimage.add(new ImageIcon("winter/enemyleftlegupleft.PNG").getImage());	//
		northwestcreepimage.add(new ImageIcon("winter/northweststanding.PNG").getImage());	//Images of alien moving northwest
		northwestcreepimage.add(new ImageIcon("winter/enemyrightupleft.PNG").getImage());		//
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		southeastcreepimage.add(new ImageIcon("winter/enemyleftlegdownright.PNG").getImage());	//
		southeastcreepimage.add(new ImageIcon("winter/southeaststanding.PNG").getImage());		//Images of alien moving southeast
		southeastcreepimage.add(new ImageIcon("winter/enemyrightdownright.PNG").getImage());		//
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		southwestcreepimage.add(new ImageIcon("winter/enemyleftlegdownleft.PNG").getImage());	//
		southwestcreepimage.add(new ImageIcon("winter/southweststanding.PNG").getImage());	//Images of alien moving southwest
		southwestcreepimage.add(new ImageIcon("winter/enemyrightdownleft.PNG").getImage());	//
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		northeastbossimage.add(new ImageIcon("winter/northeastbossleftleg.PNG").getImage());	//
		northeastbossimage.add(new ImageIcon("winter/northeaststandingboss.PNG").getImage());	//Images of alien boss moving northeast
		northeastbossimage.add(new ImageIcon("winter/northeastbossrightleg.PNG").getImage());	//
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		northwestbossimage.add(new ImageIcon("winter/northwestbossleftleg.PNG").getImage());	//
		northwestbossimage.add(new ImageIcon("winter/northweststandingboss.PNG").getImage());	//Images of alien boss moving northwest
		northwestbossimage.add(new ImageIcon("winter/northwestbossrightleg.PNG").getImage());	//
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		southeastbossimage.add(new ImageIcon("winter/southeastbossleftleg.PNG").getImage());	//
		southeastbossimage.add(new ImageIcon("winter/southeaststandingboss.PNG").getImage());	//Images of alien boss moving southeast
		southeastbossimage.add(new ImageIcon("winter/southeastbossrightleg.PNG").getImage());	//
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		southwestbossimage.add(new ImageIcon("winter/southwestbossleftleg.PNG").getImage());	//
		southwestbossimage.add(new ImageIcon("winter/southweststandingboss.PNG").getImage());	//Images of alien boss moving southwest
		southwestbossimage.add(new ImageIcon("winter/southwestbossrightleg.PNG").getImage());	//
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		timer.start(); //Timer is started so that label is repainted every for maximum 1 millis second
		addKeyListener(this);	//key listener is added to this label
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		addMouseMotionListener(this); //Mouse motion Listener is added
		addMouseListener(this);	//Mouse Listener is added
	}
	/**
	 * This paintcomponent function of hello1 label is repainted when ever repaint() is called 
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/**
		 * when game is over
		 */
		if(homescreenchange==3)
		{
			Image gameover=new ImageIcon("winter/gameover.png").getImage();
			g.drawImage(gameover,-300,-200,this);
		}
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/**
		 * This is when Main Menu is shown
		 */
		if(homescreenchange==1)
		{	Image wallpaper=new ImageIcon("winter/icefire.jpg").getImage();
			Image copwallpaper=new ImageIcon("winter/cop2.PNG").getImage();
			Image axewallpaper=new ImageIcon("winter/axe10.png").getImage();
			Image playiconresize=new ImageIcon("winter/playiconresize.png").getImage();
			Image exiticonresize=new ImageIcon("winter/exiticonresize.png").getImage();
			Image fogimage;
			/**
			 * fog can be selected or deselected here
			 */
			///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			if(fog)
			{
				fogimage=new ImageIcon("winter/fog.png").getImage();
			}
			else
			{
				fogimage=new ImageIcon("winter/nofog.png").getImage();
			}
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			g.drawImage(wallpaper,0,0,this);				//
			g.drawImage(axewallpaper,-100,0,this);			//Initialized Images are drawn here
			g.drawImage(copwallpaper,600,5,this);			//
			g.drawImage(playiconresize,500,625,this);		//
			g.drawImage(exiticonresize,750,625,this);		//
			g.drawImage(fogimage,633,625,this);				//
		}													//
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/**
		 * When game begins
		 */
		if(homescreenchange==2)
		{
			{
				/**
				 * Game is over when 3 bots are dead ie botcollision true when bullet hits bots
				 * Game over screen is brought up by just changing home variable to 3
				 */
				if((botcollision1==true) && (botcollision2==true) && (botcollision3==true))
				{
					homescreenchange=3;
					totaltime=System.currentTimeMillis()-totalstarttime;
					System.out.println(totaltime);
				}
			}

			/////////////////////////////////////////////////////////////////////////////////////////////
			if(walltime<8000)
			{
				walltime=(System.currentTimeMillis()-startTime);
			}
			else
			{
				if(totaltimevar<1)
				{
					totalstarttime=System.currentTimeMillis();
					totaltimevar++;
				}
				walltime=70000;
				
			}
	
		Image image=new ImageIcon("winter/sand.jpeg").getImage();
		g.drawImage(image,0,0,this);//Background image is drawn
		///////////////////////////////////////////////////////////////////////////////////
		if(directionchanger==0)											//Based on direction of soldier image is drawn accordingly
			g.drawImage(upimage.get(upimagechanger),x1,y1,this);		//directionchanger=0 means up
		else if(directionchanger==1)									//
			g.drawImage(downimage.get(downimagechanger),x1,y1,this);	//directionchanger=1 means down
		else if(directionchanger==2)									//
			g.drawImage(leftimage.get(leftimagechanger),x1,y1,this);	//directionchanger=2 means left
		else															//
			g.drawImage(rightimage.get(rightimagechanger),x1,y1,this);	//directionchanger=3 means left
		///////////////////////////////////////////////////////////////////////////////////////
		/**
		 * Next lines till the next javadoc comments will be regarding building of walls
		 */
		Polygon poly=new Polygon();
		super.paintComponent(g);
		int numpoints=points.size();
		g.setColor(Color.red);
		g.fillOval(x-4, y-4, 8, 8);//Mouse pointer is shown with small circle
		if(numpoints==0)//If number of points selected is zero then return
		{
			return;
		}
		prevPoint=(Point)points.get(0);//Initially prevPoint will be the first point of arrayList
		int p=points.size();
		for(int k=0;k<p;k++)
		{	
			if((Point)points.get(k)!=null)
			{
				curPoint=(Point)points.get(k);
				g.setColor(Color.red);
				g.fillRect(prevPoint.x-4, prevPoint.y-4, 8, 8);//points clicked are filled with small rectangle here
				g.fillRect(curPoint.x-4, curPoint.y-4, 8, 8);//points clicked are filled with small rectangle here
				g2=(Graphics2D)g;
				Line2D l;
				g2.setStroke(new BasicStroke(10));
				l=new Line2D.Float(prevPoint.x,prevPoint.y,curPoint.x,curPoint.y);
				if(lineIntersect(lines,l) && longline(lines,l))//since lines should not be added every time we repaint. Ovrlapping lines are not added
				{
					lines.add(l);//lines are added to list of lines here
				}
				prevPoint=curPoint;
				}
			else
			{
				if(k+1<points.size())//if there is right click point is null but there points after this null at list.
				{
					prevPoint=(Point)points.get(k+1);//so to enable drawing next point is selected and gives a like lifting pen and drawing again
				}
			}
			for(int h=0;h<lines.size();h++)
				g2.draw((Line2D)lines.get(h));//all lines in list of drawn lines are added here
		}
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/**
		 * from here bullets of player,alien and bossalien are drawn
		 * functionality of each of them is the same so only one is explained
		 */
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
					bulletlocation.remove(j);	//If collision happens with wall or border bulletlocation is removed from list of bullet location which stores bulletlocation after each repaint
					bullets.remove(j);			//bullet is removed from list of bullets
					bulletsdir.remove(j);		//bullet direction is also removed
				}
				
			}
			border.clear();	//border is cleared here so that everytime you draw
			for(int i=0;i<bullets.size();i++)
			{
				
				if(bulletsdir.get(i)==-1)//if bullet direction is left then bullet is moved to left
				{
					bulletlocation.get(i).x=bulletlocation.get(i).x-4;
					bulletlocation.get(i).y=bulletlocation.get(i).y;
					(bullets.get(i)).setLocation(bulletlocation.get(i));
					g.setColor(Color.darkGray);
					((Graphics2D)g).drawOval((bullets.get(i)).x,(bullets.get(i)).y,8,8);
				}
				else if(bulletsdir.get(i)==1)//if bullet direction is right then bullet is moved to right
				{
					bulletlocation.get(i).x=bulletlocation.get(i).x+4;
					bulletlocation.get(i).y=bulletlocation.get(i).y;
					(bullets.get(i)).setLocation(bulletlocation.get(i));
					g.setColor(Color.darkGray);
					((Graphics2D)g).drawOval((bullets.get(i)).x,(bullets.get(i)).y,8,8);
				}
				else if(bulletsdir.get(i)==-2)//if bullet direction is up then bullet is moved up
				{
					bulletlocation.get(i).x=bulletlocation.get(i).x;
					bulletlocation.get(i).y=bulletlocation.get(i).y-4;
					(bullets.get(i)).setLocation(bulletlocation.get(i));
					g.setColor(Color.darkGray);
					((Graphics2D)g).drawOval((bullets.get(i)).x,(bullets.get(i)).y,8,8);
				}
				else if(bulletsdir.get(i)==2)//if bullet direction is down then bullet is moved down
				{
					bulletlocation.get(i).x=bulletlocation.get(i).x;
					bulletlocation.get(i).y=bulletlocation.get(i).y+4;
					(bullets.get(i)).setLocation(bulletlocation.get(i));
					g.setColor(Color.darkGray);
					((Graphics2D)g).drawOval((bullets.get(i)).x,(bullets.get(i)).y,8,8);
				}
			}
		}
		/**
		 * boss bullet function is same as that of bullet shown above
		 */
		if(bossbullets.size()!=0)
		{
			border.add(new Line2D.Float(0,0,1300,0));
			border.add(new Line2D.Float(1300,0,1300,700));
			border.add(new Line2D.Float(1300,700,0,700));
			border.add(new Line2D.Float(0,700,0,0));

			for(int j=0;j<bossbullets.size();j++)
			{
				if(collision(lines,bossbullets.get(j)) || collision(border,bossbullets.get(j)))
				{
					bossbulletlocation.remove(j);
					bossbullets.remove(j);
					bossbulletsdir.remove(j);
				}
				
			}
			border.clear();
			for(int i=0;i<bossbullets.size();i++)
			{
				
				if(bossbulletsdir.get(i)==-1)
				{
					bossbulletlocation.get(i).x=bossbulletlocation.get(i).x-4;
					bossbulletlocation.get(i).y=bossbulletlocation.get(i).y;
					(bossbullets.get(i)).setLocation(bossbulletlocation.get(i));
					((Graphics2D)g).drawImage(bossbullet,(bossbullets.get(i)).x,(bossbullets.get(i)).y,this);
				}
				else if(bossbulletsdir.get(i)==1)
				{
					bossbulletlocation.get(i).x=bossbulletlocation.get(i).x+4;
					bossbulletlocation.get(i).y=bossbulletlocation.get(i).y;
					(bossbullets.get(i)).setLocation(bossbulletlocation.get(i));
					((Graphics2D)g).drawImage(bossbullet,(bossbullets.get(i)).x,(bossbullets.get(i)).y,this);
				}
				else if(bossbulletsdir.get(i)==-2)
				{
					bossbulletlocation.get(i).x=bossbulletlocation.get(i).x;
					bossbulletlocation.get(i).y=bossbulletlocation.get(i).y-4;
					(bossbullets.get(i)).setLocation(bossbulletlocation.get(i));
					((Graphics2D)g).drawImage(bossbullet,(bossbullets.get(i)).x,(bossbullets.get(i)).y,this);
				}
				else if(bossbulletsdir.get(i)==2)
				{
					bossbulletlocation.get(i).x=bossbulletlocation.get(i).x;
					bossbulletlocation.get(i).y=bossbulletlocation.get(i).y+4;
					(bossbullets.get(i)).setLocation(bossbulletlocation.get(i));
					((Graphics2D)g).drawImage(bossbullet,(bossbullets.get(i)).x,(bossbullets.get(i)).y,this);
				}
			}
		}
		/**
		 * enemy bullet function is same as that of bullet shown above
		 */
		if(enemybullets.size()!=0)
		{
			border.add(new Line2D.Float(0,0,1300,0));
			border.add(new Line2D.Float(1300,0,1300,700));
			border.add(new Line2D.Float(1300,700,0,700));
			border.add(new Line2D.Float(0,700,0,0));

			for(int j=0;j<enemybullets.size();j++)
			{
				if(collision(lines,enemybullets.get(j)) || collision(border,enemybullets.get(j)))
				{
					enemybulletlocation.remove(j);
					enemybullets.remove(j);
					enemybulletsdir.remove(j);
				}
				
			}
			border.clear();
			for(int i=0;i<enemybullets.size();i++)
			{
				
				if(enemybulletsdir.get(i)==-1)
				{
					enemybulletlocation.get(i).x=enemybulletlocation.get(i).x-4;
					enemybulletlocation.get(i).y=enemybulletlocation.get(i).y;
					(enemybullets.get(i)).setLocation(enemybulletlocation.get(i));
					((Graphics2D)g).drawImage(creepbullet,(enemybullets.get(i)).x,(enemybullets.get(i)).y,this);
				}
				else if(enemybulletsdir.get(i)==1)
				{
					enemybulletlocation.get(i).x=enemybulletlocation.get(i).x+4;
					enemybulletlocation.get(i).y=enemybulletlocation.get(i).y;
					(enemybullets.get(i)).setLocation(enemybulletlocation.get(i));
					((Graphics2D)g).drawImage(creepbullet,(enemybullets.get(i)).x,(enemybullets.get(i)).y,this);
				}
				else if(enemybulletsdir.get(i)==-2)
				{
					enemybulletlocation.get(i).x=enemybulletlocation.get(i).x;
					enemybulletlocation.get(i).y=enemybulletlocation.get(i).y-4;
					(enemybullets.get(i)).setLocation(enemybulletlocation.get(i));
					((Graphics2D)g).drawImage(creepbullet,(enemybullets.get(i)).x,(enemybullets.get(i)).y,this);
				}
				else if(enemybulletsdir.get(i)==2)
				{
					enemybulletlocation.get(i).x=enemybulletlocation.get(i).x;
					enemybulletlocation.get(i).y=enemybulletlocation.get(i).y+4;
					(enemybullets.get(i)).setLocation(enemybulletlocation.get(i));
					((Graphics2D)g).drawImage(creepbullet,(enemybullets.get(i)).x,(enemybullets.get(i)).y,this);
				}
			}
		}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/**
		 * Bots are drawn and moved
		 * Functionality of each bot is almost same
		 * So only one bot is explained
		 */
		if(walltime>60000)
		{
			
			botTimer1=System.currentTimeMillis()-botStartTimer1;//timer of teleportation for bot1 is currenttime minus time when timer is restarted
			botTimer2=System.currentTimeMillis()-botStartTimer2;//timer of teleportation for bot2 is currenttime minus time when timer is restarted
			botTimer3=System.currentTimeMillis()-botStartTimer3;//timer of teleportation for bot3 is currenttime minus time when timer is restarted
			
			if(botTimer1>1000)//bot is randomly teleported every second
			{	
				if(!botcollision1)//when it is not hit by bullet
				{
					temprandx1 = rand.nextInt(1100);//random x coordinate of next teleport spot  
					temprandy1 = rand.nextInt(500);//random y coordinate of next teleport spot
					if(!(collision(lines,new Rectangle(temprandx1,temprandy1,150,150)) || 
							(new Rectangle(temprandx1,temprandy1,150,150)).intersects(new Rectangle(x1,y1,150,150)) ||
							(new Rectangle(temprandx1,temprandy1,150,150)).intersects(new Rectangle(randx2,randy2,150,150)) ||
							(new Rectangle(temprandx1,temprandy1,150,150)).intersects(new Rectangle(randx3,randy3,170,170))
							))//teleport happens only if next teleport position does not overlap with other bots and player
					{
						randx1 = temprandx1;
						randy1 = temprandy1;
						bot1=new Rectangle(randx1,randy1,145,145);
						botTimer1=0;//time is set to zero after every
						botStartTimer1=System.currentTimeMillis();//starttime is set to current to get difference from current time at every repaint
					}
					else//if collision happens
					{
						botTimer1=0;//bottimer is set every time it not greater than one sec
						botStartTimer1=System.currentTimeMillis()+999;
					}
				}
			}
			else//bottimer is less than one second
			{

				if(!botcollision1)//if collision does not occur
				{
					if(bot1!=null)
					{
						border.add(new Line2D.Float(0,0,1300,0));
						border.add(new Line2D.Float(1300,0,1300,700));
						border.add(new Line2D.Float(1300,700,0,700));
						border.add(new Line2D.Float(0,700,0,0));
						
						if(collision(lines,bot1) || collision(border,bot1))
						{
							bot1.setLocation((bot1.getLocation()).x-3*velocitybotx1,(bot1.getLocation()).y-3*velocityboty1);
							int rands=rand.nextInt(4);//This allows bot to move randomly in all four directions
							if(rands==0)
							{
								randmovement1=10;
							}
							else if(rands==1)
							{
								randmovement1=30;
							}
							else if(rands==2)
							{
								randmovement1=60;
							}
							else
							{
								randmovement1=80;
							}
						}
						border.clear();
						if(randmovement1<25)
						{
							velocitybotx1=1;//velocity of bot in x direction
							velocityboty1=1;//velocity of bot in y direction
							
						}
						else if(25<randmovement1 && randmovement1<50)
						{
							velocitybotx1=-1;//velocity of bot in x direction
							velocityboty1=1;//velocity of bot in y direction
						}
						else if(50<randmovement1 &&randmovement1<75)
						{
							velocitybotx1=1;//velocity of bot in x direction
							velocityboty1=-1;//velocity of bot in y direction
						}
						else
						{
							velocitybotx1=-1;//velocity of bot in x direction
							velocityboty1=-1;//velocity of bot in y direction
						}
						
						bot1.setLocation((bot1.getLocation()).x+velocitybotx1,(bot1.getLocation()).y+velocityboty1);//bot location is changed based on velocties
						/**
						 * Images of  bot are selected based one the random direction generated
						 */
						if(velocitybotx1==1 &&velocityboty1==-1)
						{
							if(northeastcreeptimer>200)
							{
								if(northeastcreepimagechanger==2)
									northeastcreepimagechanger=0;//imagechanger changes every .2 seconds 
								else
									northeastcreepimagechanger++;
								northeastcreeptimer=0;
								northeastcreepstarttime=System.currentTimeMillis();//starttimer is set to current time
							}
							northeastcreeptimer=System.currentTimeMillis()-northeastcreepstarttime;//total timer is calculated
							g.drawImage(northeastcreepimage.get(northeastcreepimagechanger),(bot1.getLocation()).x,(bot1.getLocation()).y,this);//leftleg,standing and rightleg images are selected based timer on each image
						}
						/**
						 * the following will be the same as the one just shown above
						 */
						else if(velocitybotx1==-1 &&velocityboty1==-1)
						{
							if(northwestcreeptimer>200)
							{
								if(northwestcreepimagechanger==2)
									northwestcreepimagechanger=0;
								else
									northwestcreepimagechanger++;
								northwestcreeptimer=0;
								northwestcreepstarttime=System.currentTimeMillis();
							}
							northwestcreeptimer=System.currentTimeMillis()-northwestcreepstarttime;
							g.drawImage(northwestcreepimage.get(northwestcreepimagechanger),(bot1.getLocation()).x,(bot1.getLocation()).y,this);
						}
						else if(velocitybotx1==1 &&velocityboty1==1)
						{
							if(southeastcreeptimer>200)
							{
								if(southeastcreepimagechanger==2)
									southeastcreepimagechanger=0;
								else
									southeastcreepimagechanger++;
								//System.out.println("The value of image chabger is"+ northeastcreepimagechanger);
								southeastcreeptimer=0;
								southeastcreepstarttime=System.currentTimeMillis();
							}
							southeastcreeptimer=System.currentTimeMillis()-southeastcreepstarttime;
							g.drawImage(southeastcreepimage.get(southeastcreepimagechanger),(bot1.getLocation()).x,(bot1.getLocation()).y,this);
						}
						else if(velocitybotx1==-1 && velocityboty1==1)
						{
							if(southwestcreeptimer>200)
							{
								if(southwestcreepimagechanger==2)
									southwestcreepimagechanger=0;
								else
									southwestcreepimagechanger++;
								//System.out.println("The value of image chabger is"+ northeastcreepimagechanger);
								southwestcreeptimer=0;
								southwestcreepstarttime=System.currentTimeMillis();
							}
							southwestcreeptimer=System.currentTimeMillis()-southwestcreepstarttime;
							g.drawImage(southwestcreepimage.get(southwestcreepimagechanger),(bot1.getLocation()).x,(bot1.getLocation()).y,this);
						}
						
						/**
						 * How bot1 shoots bullets every 3 seconds
						 */
						if(bot1bullettimer>3000)
						{
							bot1bulletstarttimer=System.currentTimeMillis();
							enemybullets.add(new Rectangle((bot1.getLocation()).x,(bot1.getLocation()).y,30,30));
							bot1bullettimer=0;
							int temprandom=rand.nextInt(4);
							/**
							 * based on random direction generated bullet direction is set
							 */
							if(temprandom==0)
							{
								enemybulletsdir.add(-1);
							}
							else if(temprandom==1)
							{
								enemybulletsdir.add(1);
							}
							else if(temprandom==2)
							{
								enemybulletsdir.add(-2);
							}
							else if(temprandom==3)
							{
								enemybulletsdir.add(2);
							}
							enemybulletlocation.add(bot1.getLocation());
						}
						bot1bullettimer=System.currentTimeMillis()-bot1bulletstarttimer;//timer to calculate the 3 seconds
					}
					

					
				}
			}
			/**
			 * bot2 functionality is similar to bot1 functionalty so didnt explain here
			 */
			if(botTimer2>1000)
			{	
				if(!botcollision2)
				{
					temprandx2 = rand.nextInt(1100);
					temprandy2 = rand.nextInt(500);
					if(!(collision(lines,new Rectangle(temprandx2,temprandy2,150,150)) || 
							(new Rectangle(temprandx2,temprandy2,150,150)).intersects(new Rectangle(x1,y1,150,150)) ||
							(new Rectangle(temprandx2,temprandy2,150,150)).intersects(new Rectangle(randx1,randy1,150,150)) ||
							(new Rectangle(temprandx2,temprandy2,150,150)).intersects(new Rectangle(randx3,randy3,150,150))
							))
					{
						randx2 = temprandx2;
						randy2 = temprandy2;
						
						//System.out.println("lines size is "+lines.size());
						bot2=new Rectangle(randx2,randy2,150,150);
						//System.out.println(randx2);
						botTimer2=0;
						botStartTimer2=System.currentTimeMillis();
					}
					else
					{
						botTimer2=0;
						botStartTimer2=System.currentTimeMillis()+999;
					}
				}
			}
			else
			{
				//botTimer=System.currentTimeMillis()-botStartTimer;
				if(!botcollision2)
				{
					if(bot2!=null)
					{
						border.add(new Line2D.Float(0,0,1300,0));
						border.add(new Line2D.Float(1300,0,1300,700));
						border.add(new Line2D.Float(1300,700,0,700));
						border.add(new Line2D.Float(0,700,0,0));
						
						if(collision(lines,bot2) || collision(border,bot2))
						{
							bot2.setLocation((bot2.getLocation()).x-3*velocitybotx2,(bot2.getLocation()).y-3*velocityboty2);
							int rands=rand.nextInt(4);
							if(rands==0)
							{
								randmovement2=10;
							}
							else if(rands==1)
							{
								randmovement2=30;
							}
							else if(rands==2)
							{
								randmovement2=60;
							}
							else
							{
								randmovement2=80;
							}
						}
						border.clear();
						if(randmovement2<25)
						{
							velocitybotx2=1;
							velocityboty2=1;
							
						}
						else if(25<randmovement2 && randmovement2<50)
						{
							velocitybotx2=-1;
							velocityboty2=1;
						}
						else if(50<randmovement2 &&randmovement2<75)
						{
							velocitybotx2=1;
							velocityboty2=-1;
						}
						else
						{
							velocitybotx2=-1;
							velocityboty2=-1;
						}
						bot2.setLocation((bot2.getLocation()).x+velocitybotx2,(bot2.getLocation()).y+velocityboty2);
						/////////////////////////////////////////////////////////////////////////////
						if(velocitybotx2==1 &&velocityboty2==-1)
						{
							if(northeastcreeptimer1>200)
							{
								if(northeastcreepimagechanger1==2)
									northeastcreepimagechanger1=0;
								else
									northeastcreepimagechanger1++;
								System.out.println("The value of image chabger is"+ northeastcreepimagechanger1);
								northeastcreeptimer1=0;
								northeastcreepstarttime1=System.currentTimeMillis();
							}
							northeastcreeptimer1=System.currentTimeMillis()-northeastcreepstarttime1;
							g.drawImage(northeastcreepimage.get(northeastcreepimagechanger1),(bot2.getLocation()).x,(bot2.getLocation()).y,this);
						}
						else if(velocitybotx2==-1 &&velocityboty2==-1)
						{
							if(northwestcreeptimer1>200)
							{
								if(northwestcreepimagechanger1==2)
									northwestcreepimagechanger1=0;
								else
									northwestcreepimagechanger1++;
								//System.out.println("The value of image chabger is"+ northeastcreepimagechanger);
								northwestcreeptimer1=0;
								northwestcreepstarttime1=System.currentTimeMillis();
							}
							northwestcreeptimer1=System.currentTimeMillis()-northwestcreepstarttime1;
							g.drawImage(northwestcreepimage.get(northwestcreepimagechanger1),(bot2.getLocation()).x,(bot2.getLocation()).y,this);
						}
						else if(velocitybotx2==1 &&velocityboty2==1)
						{
							if(southeastcreeptimer1>200)
							{
								if(southeastcreepimagechanger1==2)
									southeastcreepimagechanger1=0;
								else
									southeastcreepimagechanger1++;
								//System.out.println("The value of image chabger is"+ northeastcreepimagechanger);
								southeastcreeptimer1=0;
								southeastcreepstarttime1=System.currentTimeMillis();
							}
							southeastcreeptimer1=System.currentTimeMillis()-southeastcreepstarttime1;
							g.drawImage(southeastcreepimage.get(southeastcreepimagechanger1),(bot2.getLocation()).x,(bot2.getLocation()).y,this);
						}
						else if(velocitybotx2==-1 && velocityboty2==1)
						{
							if(southwestcreeptimer1>200)
							{
								if(southwestcreepimagechanger1==2)
									southwestcreepimagechanger1=0;
								else
									southwestcreepimagechanger1++;
								//System.out.println("The value of image chabger is"+ northeastcreepimagechanger);
								southwestcreeptimer1=0;
								southwestcreepstarttime1=System.currentTimeMillis();
							}
							southwestcreeptimer1=System.currentTimeMillis()-southwestcreepstarttime1;
							g.drawImage(southwestcreepimage.get(southwestcreepimagechanger1),(bot2.getLocation()).x,(bot2.getLocation()).y,this);
						}
						
						///////////////////////////////////////////////////////////////////////////////
						if(bot2bullettimer>3000)
						{
							bot2bulletstarttimer=System.currentTimeMillis();
							enemybullets.add(new Rectangle((bot2.getLocation()).x,(bot2.getLocation()).y,20,20));
							bot2bullettimer=0;
							int temprandom=rand.nextInt(4);
							if(temprandom==0)
							{
								enemybulletsdir.add(-1);
							}
							else if(temprandom==1)
							{
								enemybulletsdir.add(1);
							}
							else if(temprandom==2)
							{
								enemybulletsdir.add(-2);
							}
							else if(temprandom==3)
							{
								enemybulletsdir.add(2);
							}
							enemybulletlocation.add(bot2.getLocation());
						}
						bot2bullettimer=System.currentTimeMillis()-bot2bulletstarttimer;
					}
				}
			}
			/**
			 * bot3 functionality is similar to bot1 so not explained in comments
			 */
			if(botTimer3>1000)
			{	
				if(!botcollision3)
				{
					temprandx3 = rand.nextInt(1100);
					temprandy3 = rand.nextInt(500);
					if(!(collision(lines,new Rectangle(temprandx3,temprandy3,150,150)) || 
							(new Rectangle(temprandx3,temprandy3,150,150)).intersects(new Rectangle(x1,y1,150,150)) ||
							(new Rectangle(temprandx3,temprandy3,150,150)).intersects(new Rectangle(randx1,randy1,150,150)) ||
							(new Rectangle(temprandx3,temprandy3,150,150)).intersects(new Rectangle(randx2,randy2,150,150))
							))
					{
						randx3 = temprandx3;
						randy3 = temprandy3;
						
						//System.out.println("lines size is "+lines.size());
						bot3=new Rectangle(randx3,randy3,150,150);
						//System.out.println(randx2);
						botTimer3=0;
						botStartTimer3=System.currentTimeMillis();
					}
					else
					{
						botTimer3=0;
						botStartTimer3=System.currentTimeMillis()+999;
					}
				}
			}
			else
			{
				//botTimer=System.currentTimeMillis()-botStartTimer;
				if(!botcollision3)
				{
					if(bot3!=null)
					{
						border.add(new Line2D.Float(0,0,1300,0));
						border.add(new Line2D.Float(1300,0,1300,700));
						border.add(new Line2D.Float(1300,700,0,700));
						border.add(new Line2D.Float(0,700,0,0));
						
						if(collision(lines,bot3) || collision(border,bot3))
						{
							bot3.setLocation((bot3.getLocation()).x-3*velocitybotx3,(bot3.getLocation()).y-3*velocityboty3);
							int rands=rand.nextInt(4);
							if(rands==0)
							{
								randmovement3=10;
							}
							else if(rands==1)
							{
								randmovement3=30;
							}
							else if(rands==2)
							{
								randmovement3=60;
							}
							else
							{
								randmovement3=80;
							}
						}
						border.clear();
						if(randmovement3<25)
						{
							velocitybotx3=1;
							velocityboty3=1;
						//	bot3.setLocation((bot3.getLocation()).x+1,(bot3.getLocation()).y+1);
						}
						else if(25<randmovement3 && randmovement3<50)
						{
							velocitybotx3=-1;
							velocityboty3=1;
							//bot3.setLocation((bot3.getLocation()).x-1,(bot3.getLocation()).y+1);
						}
						else if(50<randmovement2 &&randmovement2<75)
						{
							velocitybotx3=-1;
							velocityboty3=-1;
						//	bot3.setLocation((bot3.getLocation()).x+1,(bot3.getLocation()).y-1);
						}
						else
						{
							velocitybotx3=-1;
							velocityboty3=-1;
						//	bot3.setLocation((bot3.getLocation()).x-1,(bot3.getLocation()).y-1);
						}
						bot3.setLocation((bot3.getLocation()).x+velocitybotx3,(bot3.getLocation()).y+velocityboty3);
						if(velocitybotx3==1 &&velocityboty3==-1)
						{
							if(northeastbosstimer>200)
							{
								if(northeastbossimagechanger==2)
									northeastbossimagechanger=0;
								else
									northeastbossimagechanger++;
								System.out.println("The value of image chabger is"+ northeastcreepimagechanger);
								northeastbosstimer=0;
								northeastbossstarttime=System.currentTimeMillis();
							}
							northeastbosstimer=System.currentTimeMillis()-northeastbossstarttime;
							g.drawImage(northeastbossimage.get(northeastbossimagechanger),(bot3.getLocation()).x,(bot3.getLocation()).y,this);
						}
						else if(velocitybotx3==-1 &&velocityboty3==-1)
						{
							if(northwestbosstimer>200)
							{
								if(northwestbossimagechanger==2)
									northwestbossimagechanger=0;
								else
									northwestbossimagechanger++;
								//System.out.println("The value of image chabger is"+ northeastcreepimagechanger);
								northwestbosstimer=0;
								northwestbossstarttime=System.currentTimeMillis();
							}
							northwestbosstimer=System.currentTimeMillis()-northwestbossstarttime;
							g.drawImage(northwestbossimage.get(northwestbossimagechanger),(bot3.getLocation()).x,(bot3.getLocation()).y,this);
						}
						else if(velocitybotx3==1 &&velocityboty3==1)
						{
							if(southeastbosstimer>200)
							{
								if(southeastbossimagechanger==2)
									southeastbossimagechanger=0;
								else
									southeastbossimagechanger++;
								//System.out.println("The value of image chabger is"+ northeastcreepimagechanger);
								southeastbosstimer=0;
								southeastbossstarttime=System.currentTimeMillis();
							}
							southeastbosstimer=System.currentTimeMillis()-southeastbossstarttime;
							g.drawImage(southeastbossimage.get(southeastbossimagechanger),(bot3.getLocation()).x,(bot3.getLocation()).y,this);
						}
						else if(velocitybotx3==-1 && velocityboty3==1)
						{
							if(southwestbosstimer>200)
							{
								if(southwestbossimagechanger==2)
									southwestbossimagechanger=0;
								else
									southwestbossimagechanger++;
								//System.out.println("The value of image chabger is"+ northeastcreepimagechanger);
								southwestbosstimer=0;
								southwestbossstarttime=System.currentTimeMillis();
							}
							southwestbosstimer=System.currentTimeMillis()-southwestbossstarttime;
							g.drawImage(southwestbossimage.get(southwestbossimagechanger),(bot3.getLocation()).x,(bot3.getLocation()).y,this);
						}
						if(bot3bullettimer>3000)
						{
							bot3bulletstarttimer=System.currentTimeMillis();
							bossbullets.add(new Rectangle((bot3.getLocation()).x,(bot3.getLocation()).y,20,20));
							bot3bullettimer=0;
							int temprandom=rand.nextInt(4);
							if(temprandom==0)
							{
								bossbulletsdir.add(-1);
							}
							else if(temprandom==1)
							{
								bossbulletsdir.add(1);
							}
							else if(temprandom==2)
							{
								bossbulletsdir.add(-2);
							}
							else if(temprandom==3)
							{
								bossbulletsdir.add(2);
							}
							bossbulletlocation.add(bot3.getLocation());
						}
						bot3bullettimer=System.currentTimeMillis()-bot3bulletstarttimer;
					
						
					}
				}
			}		
		}
		if(fog)//if fog of war is selcted
		{
			Rectangle r1=new Rectangle(0,0,1300,700);
			//Rectangle r2=new Rectangle(0,0,1300,700);
			g.setColor(Color.black);//small area around him and bot is visible and small part around enemies is visible 
			Area a1=new Area(r1);
			Area a2=new Area(new Ellipse2D.Float(x1-75,y1-75,300,300));
			a1.subtract(a2);//circle around player is subtracted
			if(bot1!=null)
			{
				Area a3=new Area(new Ellipse2D.Float((bot1.getLocation()).x-75,(bot1.getLocation()).y-75,300,300));
				a1.subtract(a3);//circle around bot1 is subtracted
			}
			if(bot2!=null)
			{
				Area a4=new Area(new Ellipse2D.Float((bot2.getLocation()).x-75,(bot2.getLocation()).y-75,300,300));
				a1.subtract(a4);//circle around bot2 is subtracted
			}
			if(bot3!=null)
			{
				Area a5=new Area(new Ellipse2D.Float((bot3.getLocation()).x-75,(bot3.getLocation()).y-75,300,300));
				a1.subtract(a5);//circle around bot3 is subtracted
			}
		
			((Graphics2D) g).fill(a1);//fog is drawn here
		}
	
		/**
		 * when bullet hits bot
		 */
		for(int e=0;e<bullets.size();e++)
		{
			if(bot1!=null)
			{
				
				if(bullets.get(e).intersects(bot1))
				{
					botcollision1=true;
					bullets.remove(e);
					bulletlocation.remove(e);
					bulletsdir.remove(e);
					bot1.setLocation(5000,3000);//if bullet hits bot is moved outside of frame
					break;
				}
			}
		}
		for(int e=0;e<bullets.size();e++)
		{
			if(bot2!=null)
			{
				if(bullets.get(e).intersects(bot2))
				{
					botcollision2=true;
					bullets.remove(e);
					bulletlocation.remove(e);
					bulletsdir.remove(e);
					bot2.setLocation(3000,3000);//if bullet hits bot is moved outside of frame
					break;
				}
			}
		}
		for(int e=0;e<bullets.size();e++)
		{
			if(bot3!=null)
			{
				if(bullets.get(e).intersects(bot3))
				{
					//botcollision3=true;
					bullets.remove(e);
					bulletlocation.remove(e);
					bulletsdir.remove(e);
					if(counter==4)
					{
						botcollision3=true;
						bot3.setLocation(4000,3000);//if bullet hits bot is moved outside of frame
						break;
					}
					counter++;
				}
			}
		}
		/**
		 * when bullet hits hero
		 */
		for(int e=0;e<enemybullets.size();e++)
		{
			if(directionchanger==0 || directionchanger==1)
			{
				if(enemybullets.get(e).intersects(new Rectangle(x1,y1,55,80)))
				{
					homescreenchange=3;//game is over if bullet hits hero
					totaltime=System.currentTimeMillis()-totalstarttime;
					System.out.println(totaltime);
				}
			}
			if(directionchanger==3 || directionchanger==2)
			{
				if(enemybullets.get(e).intersects(new Rectangle(x1,y1,80,50)))
				{
					homescreenchange=3;
					totaltime=System.currentTimeMillis()-totalstarttime;
					System.out.println(totaltime);
				}
			}
		}
		for(int e=0;e<bossbullets.size();e++)
		{
			if(directionchanger==0 || directionchanger==1)
			{
				if(bossbullets.get(e).intersects(new Rectangle(x1,y1,55,80)))
				{
					homescreenchange=3;//game is over if bullet hits hero
					totaltime=System.currentTimeMillis()-totalstarttime;
					System.out.println(totaltime);
				}
			}
			if(directionchanger==3 || directionchanger==2)
			{
				if(bossbullets.get(e).intersects(new Rectangle(x1,y1,80,50)))
				{
					homescreenchange=3;//game is over if bullet hits hero
					totaltime=System.currentTimeMillis()-totalstarttime;
					System.out.println(totaltime);
				}
			}
		}
		/**
		 * when bullets are empty
		 */
		if(numberbullets==0 && bullets.size()==0)
		{
			homescreenchange=3;//game is over even if the bullets are over witout killing all enemies
			totaltime=System.currentTimeMillis()-totalstarttime;
			System.out.println(totaltime);
		}
	}
	}
	private void fill(Area a1) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent event) 
	{
		/////////////////////////////////////////////////////
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
		if(y1>700-65) 
		{
			vely=0;
			y1=700-65;
		}
		/////////////////////////////////////////////////////////////
		/**
		 * tempx1 and tempy1 is cordinate before collision
		 */
		if(directionchanger==0||directionchanger==1)//if moving up or down
		{
			if (!(collision(lines,new Rectangle(x1,y1,55,80))))//if collision with walls
			{
				tempx1=x1;//restored to point before collision
				tempy1=y1;//restored to point before collision
			}
		}
		if(directionchanger==2||directionchanger==3)//if moving left or right
		{
			if (!(collision(lines,new Rectangle(x1,y1,80,55))))
			{
				tempx1=x1;//restored to point before collision
				tempy1=y1;//restored to point before collision
			}
		}
		if(directionchanger==0||directionchanger==1)//when moving up or down
		{
			if(x1>tempx1 && (collision(lines,new Rectangle(x1,y1,55,80))))//collision happens while moving left
			{
			
				velx=0;
				x1=tempx1;
			}
			else if(x1<tempx1 && (collision(lines,new Rectangle(x1,y1,55,80))))//collision happens while moving right
			{
			
				velx=0;
				x1=tempx1;
			
			}
		
			else if(y1<tempy1 && (collision(lines,new Rectangle(x1,y1,55,80))))//collision happens while moving top
			{	
				vely=0;
				y1=tempy1;
			
			
			}
			else if(y1>tempy1 && (collision(lines,new Rectangle(x1,y1,55,80))))//collision happens while moving bot
			{	
				vely=0;
				y1=tempy1;
			
			}
		}
		if(directionchanger==2||directionchanger==3)//when moving left or right or down
		{
			if(x1>tempx1 && (collision(lines,new Rectangle(x1,y1,80,55))))//collision happens while moving right
			{
			
				velx=0;
				x1=tempx1;
			}
			else if(x1<tempx1 && (collision(lines,new Rectangle(x1,y1,80,55))))//collision happens while moving left
			{
			
				velx=0;
				x1=tempx1;
			
			}
		
			else if(y1<tempy1 && (collision(lines,new Rectangle(x1,y1,80,55))))//collision happens while moving top
			{	
				vely=0;
				y1=tempy1;
			}
			else if(y1>tempy1 && (collision(lines,new Rectangle(x1,y1,80,55))))//collision happens while moving bot
			{	
				vely=0;
				y1=tempy1;
			}
		}
		x1=x1+velx;//value of x is updated
		y1=y1+vely;//value of y is updated
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent event) 
	{
		int c=event.getKeyCode();
		if(c==KeyEvent.VK_LEFT)//to move left
		{directionchanger=2;
			velx=-3;
			vely=0;
			curdir=-1;
			
			lefttimer+=System.currentTimeMillis()-leftstarttime;//timer is recorded for long we press to change the image leg positions to animate
			if(lefttimer>125)//leg position changed every .125 seconds
			{
				if(leftimagechanger==2)//images stored in array list are used to retrieve
					leftimagechanger=0;
				else
					leftimagechanger++;
				lefttimer=0;
				leftstarttime=System.currentTimeMillis();//start time is updated after every .125 secs
			}
		}
		if(c==KeyEvent.VK_RIGHT)
		{directionchanger=3;
			velx=3;
			vely=0;
			curdir=1;
			
			righttimer+=System.currentTimeMillis()-rightstarttime;//timer is recorded for long we press to change the image leg positions to animate
			if(righttimer>500)
			{
				if(rightimagechanger==2)//images stored in array list are used to retrieve
					rightimagechanger=0;
				else
					rightimagechanger++;
				righttimer=0;
				rightstarttime=System.currentTimeMillis();//start time is updated after every .125 secs
			}
		}
		if(c==KeyEvent.VK_UP)
		{
			directionchanger=0;
			velx=0;
			vely=-3;
			curdir=-2;
			
			uptimer+=System.currentTimeMillis()-upstarttime;//timer is recorded for long we press to change the image leg positions to animate
			if(uptimer>125)
			{
				if(upimagechanger==2)//images stored in array list are used to retrieve
					upimagechanger=0;
				else
					upimagechanger++;
				uptimer=0;
				upstarttime=System.currentTimeMillis();//start time is updated after every .125 secs
			}
		}
		if(c==KeyEvent.VK_DOWN)
		{
			directionchanger=1;
			velx=0;
			vely=3;
			curdir=2;
			downtimer+=System.currentTimeMillis()-downstarttime;//timer is recorded for long we press to change the image leg positions to animate
			if(downtimer>125)
			{
				if(downimagechanger==2)//images stored in array list are used to retrieve
					downimagechanger=0;
				else
					downimagechanger++;
				downtimer=0;
				downstarttime=System.currentTimeMillis();//start time is updated after every .125 secs
			}
		}
		if(c==KeyEvent.VK_SPACE)
		{
			if(numberbullets>0)//goes in only if number of bullets is greater than zero
			{
				numberbullets--;
				Rectangle r=new Rectangle(x1+50,y1+50,50,50);
				bullets.add(r);//bullet is added
				bulletsdir.add(curdir);//bullet direction is added as direction of hero
				//based on direction of hero start position of bullet is modified
				if(curdir==-1)
					bulletlocation.add(new Point(x1,y1+13));
				else if(curdir==1)
					bulletlocation.add(new Point(x1+80,y1+32));
				else if(curdir==-2)
					bulletlocation.add(new Point(x1+30,y1));
				else if(curdir==2)
					bulletlocation.add(new Point(x1+13,y1+80));
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent event) 
	{
		//When key is released velocities should be made zero
		velx=0;
		vely=0;	
	}

	@Override
	public void keyTyped(KeyEvent event) 
	{
		
		int c=event.getKeyCode();
		if(c==KeyEvent.VK_UP)
		{
			upstarttime=System.currentTimeMillis();//starttimer is initiated
			directionchanger=0;//direction changed to up
		}
		if(c==KeyEvent.VK_DOWN)
		{
			downstarttime=System.currentTimeMillis();//starttimer is initiated
			directionchanger=1;//direction changed to down
		}
		if(c==KeyEvent.VK_LEFT)
		{
			leftstarttime=System.currentTimeMillis();//starttimer is initiated
			directionchanger=2;//direction changed to left
		}
		if(c==KeyEvent.VK_RIGHT)
		{
			rightstarttime=System.currentTimeMillis();//starttimer is initiated
			directionchanger=3;//direction changed to right
		}	
	}
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		/**
		 * In main menu
		 */
		if(homescreenchange==1)
		{
			homescreenx=e.getX();
			homescreeny=e.getY();
			if(SwingUtilities.isLeftMouseButton(e))
			{
				if(homescreenx>= 500 && homescreenx<= 70+500 && homescreeny>= 625 && homescreeny<= 625+ 70)//if clicked on play
				{
					homescreenchange=2;
					startTime=System.currentTimeMillis();//timer to cal
					botStartTimer1=System.currentTimeMillis();
				}
				if(homescreenx>=750 && homescreenx<=70+750 && homescreeny>=625 && homescreeny<=625+70)//if clicked on exit
				{
					System.exit(0);
				}
				if(homescreenx>= 633 && homescreenx<= 633+43 && homescreeny>= 625 && homescreeny<= 625+ 19)//if clicked on fog
				{
					if(fog)
						fog=false;//if fog is true set false
					else
						fog=true;//if fog is false set true
				}
			}
		
		}
		/**
		 * if game started
		 */
		else if(homescreenchange==2)
		{
			//////////////////////////////////////////////////////////////////////////////////////
			/**
			 * hero can draw wall only for eight seconds
			 */
			if(walltime<8000){
			x=e.getX();
			y=e.getY();
			if(SwingUtilities.isLeftMouseButton(e))
			{
				Point tempPoint;
				if(points.size()==0)
				{
					tempPoint=new Point(x,y);
					if((distance(lines,tempPoint)))
					{	
						points.add(new Point(x,y));//pont is added
					}
					repaint();
				}
				else if (z==1)//adding next point after right click
				{
					points.add(new Point(x,y));
					repaint();
					z=0;
				}
				/**
				 * only horizontal lines or vertical are allowed to draw
				 */
				else if (Math.abs(x-prevPoint.x)>Math.abs(prevPoint.y-y))//if horizontal angle less that 45 degrees
				{	
					tempPoint=new Point(x,y);
					if((distance(lines,tempPoint)))
					{
						points.add(new Point(x,prevPoint.y));// point is added
					}
					repaint();
				}
				else//if angle greater than 45 degrees
				{
					tempPoint=new Point(x,y);
					if((distance(lines,tempPoint)))
					{
						points.add(new Point(prevPoint.x,y));//point is added
					}
					repaint();
				
				}
			}	
			else//when right clicked
			{
				points.add(null);
				z=1;
			}
		}

		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		
		x=e.getX();
		y=e.getY();
		repaint();
	}
	/**
	 * collision is detected here between lines and rectangles
	 * @param lin
	 * @param rect
	 * @return
	 */
	public boolean collision(ArrayList lin,Rectangle rect )
	{
		Line2D templine;
		int j=0;
		for(int i=0;i<lin.size();++i)
		{
			templine=(Line2D)lin.get(i);//each line is stored in temp variable
			if(rect.intersectsLine(templine))//if intersects
			{
				j++;
			}
		}
		if(j>0)
			return true;
		else
			return false;
	
	}
	/**
	 * checks intersect of lines
	 * @param a1
	 * @param fnline
	 * @return
	 */
	public boolean lineIntersect(ArrayList<Line2D> a1,Line2D fnline)
	{
		for(int h=0;h<a1.size();h++)
		{
			if((fnline.getX1()==(a1.get(h)).getX1() && fnline.getX2()==(a1.get(h)).getX2() && fnline.getY1()==(a1.get(h)).getY1() && fnline.getY2()==(a1.get(h)).getY2()) || (fnline.getY1()==fnline.getY2() && fnline.getX1()==fnline.getX2()))
			{
				return false;
			}
			
		}
		return true;
	}
	public boolean longline(ArrayList<Line2D> a1,Line2D fnline)
	{
		if(a1.size()>1)
		{	
			for(int h=0;h<a1.size();h++)
			{
				if(fnline.intersectsLine(a1.get(h)) && h!=a1.size()-1) 
					return false;
			}
			return true;
		}
		return true;
	}
	/**
	 * checks distance from border
	 * @param lines1
	 * @param p1
	 * @return
	 */
	public boolean distance(ArrayList lines1,Point p1)
	{
		boolean b1=true;
		//distance from edge should be less than 160.This is used while drawing walls.walls cant be drawn within 160 from border
		if((Math.abs((p1.x)-1300)<160) ||(Math.abs((p1.x)-0)<160)||(Math.abs((p1.y)-700)<160)||(Math.abs((p1.y)-0)<+160))
		{
			b1=false;
			return b1;
		}
		else
			return true;
		}
	
}	
/**
 * 	The class containing main class
 * @author suraj,raja
 *
 */
public class hello
{
	/**
	 * main function
	 * @param args
	 */
	public static void main(String args[])
	{
		JFrame frame=new JFrame(); //frame is created
		JLabel mov1=new hello1();//label of type hello1 is created
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(mov1);//label is set as content pane
		frame.setSize(1368,728);
		frame.setResizable(false);
		frame.setVisible(true);	
	}
		
}
