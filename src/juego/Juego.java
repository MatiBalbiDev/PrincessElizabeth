package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;
import juego.modelos.BolaFuego;
import juego.modelos.Princesa;

public class Juego extends InterfaceJuego {

	private Entorno entorno;
	private Princesa princesa;
	private Image imgPrincesa;
	private Image fondo;
	private Image suelo;
	private BolaFuego bolaFuego;

	public Juego() {
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Super Elizabeth Sis", 800, 600);
		fondo = Herramientas.cargarImagen("assets/fondo.png");
		suelo = Herramientas.cargarImagen("assets/suelo.png");
		imgPrincesa = Herramientas.cargarImagen("assets/princess_peach.png");
		princesa = new Princesa(entorno.ancho() / 2,
				entorno.alto() - (suelo.getHeight(entorno) / 2) - (imgPrincesa.getHeight(entorno) * 0.2), 0.2);
		bolaFuego = null;
		// Inicia el juego!
		this.entorno.iniciar();

	}

	public void tick() {
		entorno.dibujarImagen(fondo, entorno.ancho() / 2, entorno.alto() / 2, 0, 1);
		entorno.dibujarImagen(suelo, entorno.ancho() / 2, entorno.alto() - suelo.getHeight(entorno) / 2, 0, 1.4);
		princesa.dibujar(entorno);

		if (entorno.estaPresionada(entorno.TECLA_DERECHA)) {
			princesa.moverALaDerecha(entorno);
		}

		if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
			princesa.moverALaIzquierda(entorno);
		}

		if (entorno.sePresiono(entorno.TECLA_ARRIBA)) {
			princesa.saltar();
		}

		if (entorno.sePresiono(entorno.TECLA_ESPACIO)) {
			if (bolaFuego == null || bolaFuego.fueraDePantalla(entorno)) {
				bolaFuego = princesa.lanzarBolaFuego();
			}
		}

		if (bolaFuego != null) {
			bolaFuego.dibujar(entorno);
			bolaFuego.mover();

			if (bolaFuego.fueraDePantalla(entorno)) {
				bolaFuego = null;
			}
		}
		princesa.caer();
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}
}
