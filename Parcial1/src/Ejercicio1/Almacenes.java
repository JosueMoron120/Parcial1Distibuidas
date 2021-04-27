package Ejercicio1;

public class Almacenes {
	private int numProductos;
    public Almacenes(int nProductos){
            this.numProductos=nProductos;
    }
    public boolean cogerProducto(){
            if (this.numProductos>0){
                    this.numProductos--;
                    return true;
            }
            return false;
    }

}
