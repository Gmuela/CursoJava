package Bean;

public class Oferta {

    private double precio;
    private int numNoches;
    private String hotel;

    public double getPrecio() {
        return precio;
    }

    public Oferta() {
        //Default
    }

    public Oferta(double precio, int numNoches, String hotel) {
        this.precio = precio;
        this.numNoches = numNoches;
        this.hotel = hotel;
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

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }
}
