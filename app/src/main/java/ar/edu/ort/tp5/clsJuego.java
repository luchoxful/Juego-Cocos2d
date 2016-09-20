package ar.edu.ort.tp5;

import android.util.Log;

import org.cocos2d.layers.Layer;
import org.cocos2d.nodes.Director;
import org.cocos2d.nodes.Scene;
import org.cocos2d.nodes.Sprite;
import org.cocos2d.opengl.CCGLSurfaceView;
import org.cocos2d.types.CCSize;

/**
 * Created by 41577163 on 20/9/2016.
 */
public class clsJuego {
    CCGLSurfaceView _VistaDelJuego;
    CCSize PantallaDelDispositivo;
    Sprite NaveJugador;
    public clsJuego(CCGLSurfaceView VistaDelJuego){
        _VistaDelJuego=VistaDelJuego;
    }
    public void ComenzarJuego(){
        Director.sharedDirector().attachInView(_VistaDelJuego);

        PantallaDelDispositivo = Director.sharedDirector().displaySize();
        Log.d("Comenzar", "Pantalla del dispositivo - Ancho:"+PantallaDelDispositivo.width+" - Alto: "+PantallaDelDispositivo.height);

        Director.sharedDirector().runWithScene(EscenaDelJuego());
    }

    private Scene EscenaDelJuego(){
        Scene EscenaADevolver;
        EscenaADevolver=Scene.node();

        CapaDeFondo MiCapaFondo;
        MiCapaFondo =new CapaDeFondo();

        CapaDelFrente MiCapaFrente;
        MiCapaFrente = new CapaDelFrente();

        EscenaADevolver.addChild(MiCapaFondo, -10);
        EscenaADevolver.addChild(MiCapaFrente, 10);

        return EscenaADevolver;

    }

    class CapaDeFondo extends Layer {
        public CapaDeFondo(){
            PonerImagenFondo();
        }
        private void PonerImagenFondo(){
            ImagenFondo = Sprite.sprite("fondo.png");
            ImagenFondo.setPosition(PantallaDelDispositivo.width/2, PantallaDelDispositivo.height/2);
            super.addChild(ImagenFondo);
        }
    }
    class CapaDelFrente extends Layer{
        public CapaDelFrente(){
            PonerNaveJugadorPosicionInicial();
        }

        private void PonerNaveJugadorPosicionInicial(){
            NaveJugador=Sprite.sprite("jugador.png");

            float PosicionInicialX, PosicionInicialY;
            PosicionInicialX=PantallaDelDispositivo.width/2;
            PosicionInicialY=NaveJugador.getHeight()/2;

            NaveJugador.setPosition(PosicionInicialX, PosicionInicialY);
            super.addChild(NaveJugador);
        }


    }
}
