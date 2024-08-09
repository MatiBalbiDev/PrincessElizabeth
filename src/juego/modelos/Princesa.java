package juego.modelos;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Princesa {
	
	private double x;
	private double y;
	private double xInicial;
	private double yInicial;
	private double escala;
	private boolean estaSaltando = false;
	private Image img;
	
	
	public Princesa(double x, double y, double escala) {
		this.x = x;
		this.xInicial = x;
		this.y = y;
		this.yInicial = y;
		this.escala = escala;
		this.img = Herramientas.cargarImagen("assets/princess_peach.png");
	}
	
	public void dibujar(Entorno entorno) {
		entorno.dibujarImagen(img, x, y, 0, escala);
	}

	public void moverALaDerecha() {
		this.x += 5;
	}

	public void moverALaIzquierda() {
		this.x -= 5;
		
	}

	public void saltar() {
	}

	public void caer() {
	}
}
