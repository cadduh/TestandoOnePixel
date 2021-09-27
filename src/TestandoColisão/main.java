package TestandoColisão;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class main extends JFrame{
	
	int larguraFrame = 600;
	int alturaFrame = 310;
	
	public main() {
		add(new labirintoPuzzleRed());
		setTitle("Testando Jogo");
		setSize(larguraFrame, alturaFrame);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
	
	public static void main (String args[]) {
		new main();
	}	
	
}
