package juego.modelos;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class BolaFuego extends Ataque{

	private double x, y, velocidad;
	private Image img;
	
	public BolaFuego(double x, double y, double velocidad) {
		super(x, y, velocidad);
		this.x = x;
		this.y = y;
		this.velocidad = velocidad;
		this.img = Herramientas.cargarImagen("assets/bolaFuego.png");
	}

	@Override
	public void mover() {
		this.x += this.velocidad;
	}

	@Override
	public void dibujar(Entorno entorno) {
		entorno.dibujarImagen(this.img, this.x, this.y, 0, 0.05);
	}
	
	public boolean fueraDePantalla(Entorno entorno) {
        return x < 0 || x > entorno.ancho();
    }
	
	public boolean colisionaConSoldado(Soldado soldado) {
	    
	    double bolaFuegoIzquierda = this.x;
	    double bolaFuegoDerecha = this.x + this.getAncho();
	    double bolaFuegoArriba = this.y;
	    double bolaFuegoAbajo = this.y + this.getAlto();

	    
	    double soldadoIzquierda = soldado.getX();
	    double soldadoDerecha = soldado.getX() + soldado.getAncho();
	    double soldadoArriba = soldado.getY();
	    double soldadoAbajo = soldado.getY() + soldado.getAlto();

	   
	    return bolaFuegoDerecha > soldadoIzquierda &&
	           bolaFuegoIzquierda < soldadoDerecha &&
	           bolaFuegoAbajo > soldadoArriba &&
	           bolaFuegoArriba < soldadoAbajo;
	}

	
	private double getAncho() {
	    return this.img.getWidth(null) * 0.05;
	}

	private double getAlto() {
	    return this.img.getHeight(null) * 0.05;
	}

}
