package juego.modelos;

import entorno.Entorno;

public abstract class Ataque {
	
	protected double x, y, velocidad;

	
	public Ataque(double x, double y, double velocidad) {
		this.x = x;
		this.y = y;
		this.velocidad = velocidad;
	}
	
	public abstract void mover();
    public abstract void dibujar(Entorno entorno);

    
    
}
