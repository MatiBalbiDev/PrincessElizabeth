package juego.modelos;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Princesa {
	
	private double x, y, xInicial, yInicial, escala, velocidadVertical;
	private boolean estaSaltando;
    private final double gravedad = 0.5;
    private final double fuerzaSalto = -13;
	private Image img;
	
	
	public Princesa(double x, double y, double escala) {
		this.x = x;
		this.xInicial = x;
		this.y = y;
		this.yInicial = y;
		this.escala = escala;
		this.estaSaltando = false;
        this.velocidadVertical = 0;
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
		if (!estaSaltando) {
            estaSaltando = true;
            velocidadVertical = fuerzaSalto;
        }
	}

	public void caer() {
		if (estaSaltando) {
            y += velocidadVertical;
            velocidadVertical += gravedad;
            
            if (y >= yInicial) {
                y = yInicial;
                estaSaltando = false;
                velocidadVertical = 0;
            }
        }
	}
}
