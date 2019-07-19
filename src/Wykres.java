import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Wykres {
	private static JTextField rownanie;
	private static JTextField minX;
	private static JTextField maxX;
	private static JTextField minY;
	private static JTextField maxY;
	
//	private static int minXint=1;
//	private static int maxXint=100;
//	private static int minYint=1;
//	private static int maxYint=4000;
	
	public static int getMinXint() {
		return Integer.parseInt(minX.getText());
	}

	public static int getMaxXint() {
		return Integer.parseInt(maxX.getText());
	}

	public static int getMinYint() {
		return -Integer.parseInt(minY.getText());
	}

	public static int getMaxYint() {
		return -Integer.parseInt(maxY.getText());
	}


	public Wykres() {
		JFrame okienko = new JFrame("wykres");
		rownanie = new JTextField("X^3-7X^2-28X-20");
		
//		JLabel minXl = new JLabel("min x");
//		JLabel maxXl = new JLabel("max x");
//		JLabel minYl = new JLabel("min y");
//		JLabel maxYl = new JLabel("max y");
		
		minX= new JTextField("-100");
		maxX= new JTextField("100");
		minY= new JTextField("300");
		maxY= new JTextField("-250");
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 4));
		
		JPanel wiekszyPanel = new JPanel();
		wiekszyPanel.setLayout(new GridLayout(2, 1));
		
		wiekszyPanel.add(panel);
		wiekszyPanel.add(rownanie);
//		panel.add(minXl);
//		panel.add(maxXl);
//		panel.add(minYl);
//		panel.add(maxYl);
//		
		
		panel.add(minX);
		panel.add(maxX);
		panel.add(maxY);
		panel.add(minY);
		
		
		JButton ok = new JButton("ok");
		
		Plutno plutno = new Plutno();
		
//		okienko.add(ok,BorderLayout.WEST);
		okienko.add(wiekszyPanel,BorderLayout.SOUTH);
		okienko.add(plutno,BorderLayout.CENTER);
//		okienko.add(rownanie,BorderLayout.SOUTH);
		okienko.setVisible(true);
		okienko.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okienko.setSize(600, 400);
		okienko.setLocationRelativeTo(null);
		
//		ok.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				minXint = Integer.parseInt(minX.getText());
//				maxXint = Integer.parseInt(maxX.getText());
//				minYint = Integer.parseInt(minY.getText());
//				maxYint = Integer.parseInt(maxY.getText());
//				plutno.repaint();
//			}
//		});
	}
	
	public static JTextField getRownanie() {
		return rownanie;
	}

	public static void setRownanie(JTextField rownanie) {
		Wykres.rownanie = rownanie;
	}

	public static int obliczRownanie(String rownanie,int x) {
		int y=0;
		rownanie = rownanie.replaceAll("-", "+-");
		String wyrazy[] = rownanie.split("\\+");
		int i=0;
		if (wyrazy[0].equals("")) i=1;
		for (;i<wyrazy.length;i++) {
			if (wyrazy[i].endsWith("X")) {
				wyrazy[i]+="^1";
			}
			String[] tmp2 = wyrazy[i].split("X\\^");
			if (tmp2.length==1) {
				String pre = tmp2[0];
				tmp2 = new String[2];
				tmp2[0]=pre;
				tmp2[1]="0";
			}
			if (tmp2[0].equals(""))  tmp2[0]="1";
			if (tmp2[0].equals("-")) tmp2[0]="-1";
			
			int a = Integer.parseInt(tmp2[0]);
			int wykladnik = Integer.parseInt(tmp2[1]);
			y+=a*Math.pow(x, wykladnik);
			
		}
		return y;
	}
	
	public static Point wspolrzxedneMyszy(int x1,int y1,int x2,int y2,int myszX, int myszY) {
		if ((myszY - y1)*(x2-x1)-(y2-y1)*(myszX-x1)==0) {
			return new Point(myszX,myszY);
		}
		return null;
	}
}
