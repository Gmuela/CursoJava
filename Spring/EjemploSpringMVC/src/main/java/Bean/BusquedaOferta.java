package Bean;

public class BusquedaOferta {

    private double precio;
    private int numNoches;

    public BusquedaOferta() {
        //Default
    }

    public BusquedaOferta(double precio, int numNoches) {
        this.precio = precio;
        this.numNoches = numNoches;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getNumNoches() {
        return numNoches;
    }

    public void setNumNoches(int numNoches) {
        this.numNoches = numNoches;
    }
}
