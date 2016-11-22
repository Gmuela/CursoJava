
public class HolaMundo {

    private Mensajes mensaje;

    public HolaMundo() {
        this.mensaje = new Mensajes();
    }

    public static void main(String[] args){

        HolaMundo holaMundo = new HolaMundo();
        Mensajes holaMundoMensaje = holaMundo.getMensaje();

        String hola_mundo = holaMundoMensaje.getHOLA_MUNDO();
        String hola_otro = holaMundoMensaje.getOTRO_MENSAJE();

        System.out.println(hola_mundo);
        System.out.println(hola_otro);
    }

    public Mensajes getMensaje() {

        return mensaje;
    }

    public void setMensaje(Mensajes mensaje) {
        this.mensaje = mensaje;
    }

}