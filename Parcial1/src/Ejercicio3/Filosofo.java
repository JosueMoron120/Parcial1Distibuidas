package Ejercicio3;
import java.util.Random;
public class Filosofo implements Runnable {
	
        GestorPalillos gestorPalillos;
        int posPalilloIzq,posPalilloDer;
        public Filosofo(GestorPalillos g, int pIzq, int pDer){
                this.gestorPalillos=g;
                this.posPalilloDer=pDer;
                this.posPalilloIzq=pIzq;
        }
        public void run() {
        	String miNombre=Thread.currentThread().getName();
            Random generador=new Random();
                while (true){
                	System.out.println(miNombre+" comiendo...");
                    int milisegs=(1+generador.nextInt(5))*1000;
                    esperarTiempoAzar1(miNombre, milisegs);
                    /* Pensando...*/
                    //Recordemos soltar los palillos
                    System.out.println(miNombre+"  pensando...");                           milisegs=(1+generador.nextInt(5))*1000;
                    esperarTiempoAzar1(miNombre, milisegs);
                        boolean palillosCogidos;
                        palillosCogidos=
                          this.gestorPalillos.intentarCogerPalillos(
                                          posPalilloIzq, posPalilloDer);
                        if (palillosCogidos){
                                comer();
                                this.gestorPalillos.liberarPalillos(
                                                posPalilloIzq,
                                                posPalilloDer);
                                dormir();
                        } //Fin del if
                } //Fin del while true
        } //Fin del run()

        private void comer() {
                System.out.println("Filosofo "+
                                Thread.currentThread().getName()+
                                " comiendo");
                esperarTiempoAzar();
        }
        private void esperarTiempoAzar() {
                Random generador=new Random();
                int msAzar=generador.nextInt(3);
                try {
                        Thread.sleep(msAzar);
                } catch (InterruptedException ex) {
                        System.out.println("Fallo la espera");
                }
        }
        private void dormir(){
                System.out.println("Filosofo "+
                                Thread.currentThread().getName()+
                                " durmiendo (zzzzzz)");
                esperarTiempoAzar();
        }
        private void esperarTiempoAzar1(String miNombre, int milisegs) {
            try {
                    Thread.sleep(milisegs);
            } catch (InterruptedException e) {
                    System.out.println(
                            miNombre+" interrumpido!!. Saliendo...");
                    return ;
            }
    }

	}

