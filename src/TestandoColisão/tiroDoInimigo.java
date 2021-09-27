package TestandoColisão;

import java.awt.Image;

import javax.swing.ImageIcon;



public class tiroDoInimigo {
	private int xTiro, yTiro;
	private int stopTiro;
	private inimigo inimigo;
	private Jogador jogador;
	private Image imgTiro;
	private ImageIcon iconTiro;
	private int largura, altura;	
	private String tiroImg = "tiro.png";

	
	
	public int getStopTiro() {
		return stopTiro;
	}

	public void setStopTiro(int stopTiro) {
		this.stopTiro = stopTiro;
	}

	public tiroDoInimigo() {

		new tiroReload().start();

	}
	
	public void carregarComponents() {

		iconTiro = new ImageIcon(tiroImg);
		imgTiro = iconTiro.getImage();
		inimigo = new inimigo();
		jogador = new Jogador();
		xTiro = inimigo.getX() ;
		yTiro = inimigo.getY();

	
	
				
	}
	
	public void atualizar() {
		xTiro = xTiro;
		yTiro = yTiro;
		

	}
	

	 public class tiroReload extends Thread {
	    	public void run() {
	    		while (true) {
	    			for(int i = 0; i < 390; i++) {
		    			//System.out.println("Contagem"+i);
						try {
							xTiro -=10;
							sleep(20);
							if(xTiro == 10) {
							    xTiro = inimigo.getX();
							    yTiro = inimigo.getY();   
							}

						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}


		    		}
	    			
	    			stopTiro =1;
		    		for(int z = 0; z < 50;z++) {
		    			try {
		    				z +=10;
							sleep(500);
						} catch (Exception e) {
							// TODO: handle exception
						}
		    		}
		    		stopTiro = 0;
		    		xTiro = inimigo.getX();
		    		yTiro = inimigo.getY();
	    		}
	  	
	    	}

	    }
	    
		public Image getImgTiro() {
			return imgTiro;
		}
	 
		public int getXtiro() {
			return xTiro;
		}
		
		public int getYtiro() {
			return yTiro;
		}
		
		public void setXtiro(int X) {
			this.xTiro = X;
		}

		public void setYtiro(int Y) {
			this.yTiro = Y;
		}
	
}
