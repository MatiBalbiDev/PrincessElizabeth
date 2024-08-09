package juego;


import entorno.Entorno;
import entorno.InterfaceJuego;
import juego.modelos.Princesa;

public class Juego extends InterfaceJuego {
	
	private Entorno entorno;
	private Princesa princesa;
	public Juego() {
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Super Elizabeth Sis", 800, 600);
		princesa = new Princesa(entorno.ancho() / 2, entorno.alto() / 2, 0.15);
		// Inicia el juego!
		this.entorno.iniciar();

	}
	
	
	public void tick() {
		princesa.dibujar(entorno);
		
		if(entorno.estaPresionada(entorno.TECLA_DERECHA)) {
			princesa.moverALaDerecha();
		}
		
		if(entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
			princesa.moverALaIzquierda();
		}
		
		if(entorno.sePresiono(entorno.TECLA_ARRIBA)) {
			princesa.saltar();
		}
		princesa.caer();
	}

	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}
}
