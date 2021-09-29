package TestandoColisão;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class labirintoPuzzleRed extends JPanel implements ActionListener{
	private Image[] labirintoImage = new Image[9];
	private Image[] wall = new Image[20];
	private Image bau, fonte,lava;
	private ImageIcon[] fundo = new ImageIcon[9]; 
	private ImageIcon[] wall1 = new ImageIcon[20];
	private Jogador jogador;
	private inimigo inimigo;
	private tiroDoInimigo tiro;
	private int larguraFrame = 600, alturaFrame = 310;
	private int[] wallLagura = new int[9];	
	private int[] wallY = new int[9];	
	private Timer timer;
	private int locarizacao = 4,locarizacaoWall = 1,wallInicio= 1,wallInicioY =1;
    
	
	public labirintoPuzzleRed() {
		// TODO Auto-generated constructor stub
		setFocusable(true);
		setDoubleBuffered(true);
 		
 		
		for(int i=1; i < labirintoImage.length;i++) {
			fundo[i] = new ImageIcon("res/labirintoPuzzleRedImg/00"+i+".png");
			labirintoImage[i] = fundo[i].getImage();
		}
		
		jogador = new Jogador();
		jogador.carregar();
		jogador.setX(270);
		jogador.setY(220);
		
		inimigo = new inimigo();
		inimigo.carregar();
		
		tiro = new tiroDoInimigo();
		tiro.carregarComponents();
		
		ImageIcon bauImg = new ImageIcon("bauOpen.png");
		bau = bauImg.getImage();
		
		ImageIcon fonte1 = new ImageIcon("res/labirintoPuzzleRedImg/Fonte.png");
		fonte = fonte1.getImage();
		
		ImageIcon lava1 = new ImageIcon("res/labirintoPuzzleRedImg/ChaoLava01.gif");
		lava = lava1.getImage();
		
		
		for(int i=1; i < wall.length;i++) {
			wall1[i] = new ImageIcon("res/labirintoPuzzleRedImg/blue.png");
			wall[i] = wall1[i].getImage();
		}
		
		wallLagura[1] = 186;
		wallY[1] = 175;
		addKeyListener(new Teclado());
		timer = new Timer(5, this);
		timer.start();
	
	}
	
	public void paint(Graphics g) {
		Graphics desenha = (Graphics2D) g;
		desenha.drawImage(labirintoImage[locarizacao],0,0,larguraFrame-16,alturaFrame-38,this);
		desenha.drawImage(jogador.getImgPlayer(),jogador.getX(),jogador.getY(),jogador.getLargura(),jogador.getAltura(),this);
		if(locarizacao == 1) {
			desenha.drawImage(wall[1],0,175,185,100,this);
			desenha.drawImage(wall[2],400,175,185,100,this);
			desenha.drawImage(wall[3],0,0,185,18,this);
			desenha.drawImage(wall[4],400,0,185,18,this);
			desenha.drawImage(fonte,243,60,100, 100, this);
			wall(100,243,60,125);
			wall(185,0,175,100);
			wall(185,400,175,100);
			wall(185,0,0,50);
			wall(185,400,0,50);
		}else if(locarizacao == 2) {
			//desenha.drawImage(wall[11],0,175,600,85,this);
			desenha.drawImage(wall[3],0,0,185,18,this);
			desenha.drawImage(wall[4],400,0,185,18,this);
			wall(600,0,179,88);
			wall(185,0,0,40);
			wall(185,400,0,40);
		}else if (locarizacao == 4) {
			//desenha.drawImage(wall[5],0,178,600,100,this);
			//desenha.drawImage(wall[6],0,0,80,180,this);
			//desenha.drawImage(wall[7],0,0,600,18,this);
			for(int i=20,j = 10;i<90;i++,j++) {
				desenha.drawImage(wall[9],420-i-j,0+i,10,10,this);
				wall(10,420-i-j,0+i,10);
		    }
		
			wall(600,0,178,100);
			wall(58,0,0,180);
			wall(600,0,0,27);
			wall(220,30,0,109);
		}
		
		
		else if (locarizacao == 5 ) {
//			desenha.drawImage(wall[5],0,178,600,100,this);
//			desenha.drawImage(wall[6],526,0,80,180,this);
//			desenha.drawImage(wall[7],0,0,600,18,this);
//			desenha.drawImage(wall[8],320,0,220,95,this);
			desenha.drawImage(lava,370,100,140,75,this);
			for(int i=20,j = 10;i<90;i++,j++) {
					//desenha.drawImage(wall[9],150+i+j,0+i,10,10,this);
					wall(10,150+i+j,0+i,10);
			}
			


			wall(600,0,178,100);
			wall(50,526,0,180);
			wall(600,0,0,27);
			wall(220,320,0,109);
		}
		
		
	}
	
	
	public boolean direito() {
		if (jogador.getX() + jogador.getLargura() >= larguraFrame - 14) {
			if(locarizacao == 1) {
				jogador.setX(20);
	            locarizacao = 5;
//	            wallLagura[5] = 600;
//                wallY[5] = 175;
//                wallInicio = 5;
//                wallInicioY= 5;
	            return true;
			}else if(locarizacao == 2) {
				jogador.setX(20);
	            locarizacao = 1;
//	            wallLagura[1] = 186;
//	            wallY[1] = 175;
//                wallInicio = 1;
//                wallInicioY= 1;
	            return true;
			}else if(locarizacao == 4) {
				jogador.setX(20);
	            locarizacao = 2;
	            return true;
			}else if(locarizacao == 6) {
				jogador.setX(20);
	            locarizacao = 8;
			}
			return false;
		}
		return false;
	}
	
	public boolean esquerdo() {
		 if (jogador.getX() <= 0) {
				if(locarizacao == 5) {
					jogador.setX(530);
		            locarizacao = 1;
//		            wallLagura[1] = 186;
//		            wallY[1] = 175;
//	                wallInicio = 1;
//	                wallInicioY= 1;
				    return true;
				    
				}else if(locarizacao == 1) {
					jogador.setX(530);
		            locarizacao = 2;
//		            wallLagura[5] = 600;
//                    wallY[5] = 175;
//                    wallInicio = 5;
//                    wallInicioY= 5;
				    return true;
				}else if(locarizacao == 2) {
					jogador.setX(530);
		            locarizacao = 4;
				    return true;
				}else if(locarizacao == 8) {
					jogador.setX(530);
		            locarizacao = 6;
				    return true;
				}
				return false;
	     }
		 return false;
	}
	
	public boolean cima() {
		 if (jogador.getY() <= 0) {
			 if(locarizacao == 1) {
				 jogador.setX(300);
				 jogador.setY(220);
		         locarizacao = 6;
			     return true;
			 }else if(locarizacao == 6) {
				 jogador.setX(300);
				 jogador.setY(220);
		         locarizacao = 7;
			     return true;
			 }else if(locarizacao == 2) {
				 jogador.setX(300);
				 jogador.setY(220);
		         locarizacao = 3;
			     return true;
			 }
			 return false;
		 }
		 return false;
	
	}
	
	public boolean baixo() {
		 if (jogador.getY() + jogador.getLargura() >= alturaFrame - 36) {
			    if(locarizacao == 6) {
					 jogador.setX(300);
					 jogador.setY(50);
			         locarizacao = 1;
				     return true;
			    }else if(locarizacao == 7) {
					 jogador.setX(300);
					 jogador.setY(50);
			         locarizacao = 6;
				     return true;
			    }else if(locarizacao == 3) {
					 jogador.setX(300);
					 jogador.setY(50);
			         locarizacao = 2;
				     return true;
			    }
			    return false;
			 }
		 return false;
	}
    
	
	public void wall(int largura, int x , int y, int altura) {
		 int wallX = x;
		 int wallY = y;
		 int ladoDireitoWall = wallX + largura;
		 int ladoEsquerdoWall = wallX;
		 int ladoBaixoWall = wallY + altura;
		 int ladoCimaWall = wallY;
		 colisao(ladoDireitoWall, ladoEsquerdoWall,ladoCimaWall, ladoBaixoWall);
	}

	
	
	public void colisao(int ladoDireitoWall, int ladoEsquerdoWall,int ladoCimaWall,int ladoBaixoWall) {
		// COLISAO COM O BAU
		 int aX = jogador.getX();
		 int aY = jogador.getY();
		 int ladoDireitoJogador = aX + jogador.getLargura() - 12;
		 int ladoEsquerdoJogador = aX + 12;
		 int ladoBaixoJogador = aY + jogador.getAltura() - 2;
		 int ladoCimaJogador = aY + 35;
		 
		if (ladoDireitoJogador >= ladoEsquerdoWall && ladoDireitoJogador < ladoEsquerdoWall + 2 && ladoBaixoJogador >= ladoCimaWall
				&& ladoCimaJogador <= ladoBaixoWall) {
			jogador.setX(jogador.getX() - 2);
		}else if (ladoEsquerdoJogador >= ladoDireitoWall - 2 && ladoEsquerdoJogador <= ladoDireitoWall && ladoBaixoJogador >= ladoCimaWall
				&& ladoCimaJogador <= ladoBaixoWall) {
			jogador.setX(jogador.getX() + 2);
		}else if (ladoDireitoJogador >= ladoEsquerdoWall && ladoEsquerdoJogador <= ladoDireitoWall && ladoBaixoJogador >= ladoCimaWall
				&& ladoBaixoJogador <= ladoBaixoWall) {
			jogador.setY(jogador.getY() - 2);
		}else if (ladoEsquerdoJogador <= ladoDireitoWall && ladoDireitoJogador >= ladoEsquerdoWall && ladoCimaJogador >= ladoBaixoWall - 2 
				&& ladoCimaJogador <= ladoBaixoWall) {
			jogador.setY(jogador.getY() + 2);
		}
	 
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// JOGADOR -- Código para não atravessar o JFrame
		 direito();
		 esquerdo();
		 cima();
		 baixo();

		 
		 
		
		 

	
		 

		 
		 


	    
        
		jogador.atualizar();
		repaint();

		
	}
	
	private class Teclado extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			jogador.keyPressed(e);
		}

		public void keyReleased(KeyEvent e) {
			jogador.keyReleased(e);
		}
	}
	

}
