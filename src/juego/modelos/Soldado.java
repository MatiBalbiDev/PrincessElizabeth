package juego.modelos;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Soldado {

	private double x, xInicial;
	private double y;
	private double velocidad;
	private double escala;
	private Image img;
	public Soldado(double x, double y, double velocidad, double escala) {
		this.x = x;
		this.y = y;
		this.xInicial = x;
		this.velocidad = velocidad;
		this.escala = escala;
		this.img = Herramientas.cargarImagen("assets/soldado.png");
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}

	public double getEscala() {
		return escala;
	}

	public void setEscala(double escala) {
		this.escala = escala;
	}
	
	public void dibujar(Entorno entorno) {
		entorno.dibujarImagen(img, x, y, 0, escala);
	}

	public Image getImg() {
		return img;
	}
	
	public double getAncho() {
	    return this.img.getWidth(null) * this.escala;
	}

	public double getAlto() {
	    return this.img.getHeight(null) * this.escala;
	}
	
	public void reposicionar() {
		this.x = this.xInicial;
	}
	
	public void mover() {
		this.x -= 0.8;
	}

}
