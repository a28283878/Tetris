package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class TetrisPanel extends JPanel{
	final int PanelWidth = 10;
	final int PanelHeight = 20;
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);		
		DrawOutLine(g);
	}

	private void DrawOutLine(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(new Color(230,230,230));
		//g.drawLine(0, 0, 0, getHeight());//left
		g.drawLine(0, 0, getWidth()/3*2, 0);//up
		//g.drawLine(getWidth(), 0, getWidth(), getHeight());//right
		g.drawLine(getWidth()/3*2, getHeight()-1, 0, getHeight()-1);//down
		
		for(int i = 0; i <= 10;i++){
			g.drawLine(getWidth()/30*2*i, 0, getWidth()/30*2*i, getHeight());
		}
		
		for(int i = 0 ; i <= 20 ; i++){
			g.drawLine(0, (getHeight()-50)/20*i, getWidth()/3*2, (getHeight()-50)/20*i);
		}
	}
	
	
}
