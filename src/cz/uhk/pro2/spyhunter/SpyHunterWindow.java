package cz.uhk.pro2.spyhunter;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import cz.uhk.pro2.spyhunter.model.GameBoard;
import cz.uhk.pro2.spyhunter.service.CsvGameBoardLoader;

public class SpyHunterWindow extends JFrame {
	private GameBoard gb;
	private BoardPanel p = new BoardPanel();

	class BoardPanel extends JPanel {
		public void paint(Graphics g) {
			super.paint(g);
			// g.drawLine(0, 0, 10, 100);
			gb.draw(g);
		}

	}

	public SpyHunterWindow() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("SPYHUNTER");
		
		

		CsvGameBoardLoader loader = new CsvGameBoardLoader();
		gb = loader.loadGameBoard();
		
		p.setPreferredSize(new Dimension(300, gb.getPixelHeight()));// preferovany rozmer herni plochy Dimension-> v pixelech
		add(p, BorderLayout.CENTER);
		pack();
		// sekunda nejaky listener
		Timer t = new Timer(10, e -> tick());
		// nezapomenou timer nastartovat
		t.start();
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
			
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_LEFT)
				{
					gb.rideLeft();
					
				}else if(e.getKeyCode()==KeyEvent.VK_RIGHT)
				{
					gb.rideRight();
				}
				
				
			}
		});

	}

	public void tick() {
		gb.tick(); // rict gameboardu, ze ubehehl dalsi casovy okamzik
		p.repaint();// prekresleni
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(() -> {
			SpyHunterWindow w = new SpyHunterWindow();
			w.setVisible(true);
		});
	}

}
