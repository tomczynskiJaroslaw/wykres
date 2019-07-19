import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class Plutno extends JPanel{
	Point mysz=new Point(0, 0);
	
	public Plutno() {
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				super.mouseMoved(e);
				mysz = e.getPoint();
				repaint();
				System.out.println("x");
				
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int x2=0;
		int y2=0;
		
		int b = -getWidth()*Wykres.getMinXint()/(Wykres.getMaxXint()-Wykres.getMinXint());
		g.drawLine(b, 0, b, getHeight());
		
		int a = -getHeight()*Wykres.getMinYint()/(Wykres.getMaxYint()-Wykres.getMinYint());
		g.drawLine(0, a, getWidth(), a);
		
		for (int i=-1000;i<1000;i++) {
			
			int x=0;
			x=i-Wykres.getMinXint();
			x= x*getWidth()/(Wykres.getMaxXint()-Wykres.getMinXint());

			int y= -Wykres.obliczRownanie(Wykres.getRownanie().getText(), i);
			y-=Wykres.getMinYint();
			y= y*getHeight()/(Wykres.getMaxYint()-Wykres.getMinYint());
			
			g.fillRect(x, y, 2, 2);
			g.drawLine(x, y, x2, y2);
			
			if(Wykres.wspolrzxedneMyszy(x, y, x2, y2, mysz.x, mysz.y)!=null) {
				int mX = mysz.x*(Wykres.getMaxXint()-Wykres.getMinXint())/getWidth()+Wykres.getMinXint();
				int mY = -(mysz.y*(Wykres.getMaxYint()-Wykres.getMinYint())/getHeight()+Wykres.getMinYint());
				g.drawLine(mysz.x, mysz.y, b, mysz.y);
				g.drawLine(mysz.x, a, mysz.x, mysz.y);
				g.drawString(mX+" "+mY, mysz.x, mysz.y);
			}
			x2=x;
			y2=y;
			
			
		}
		
		
		
		
		
		
	}
	
	public void mysz(Graphics g) {
		
	}
}
