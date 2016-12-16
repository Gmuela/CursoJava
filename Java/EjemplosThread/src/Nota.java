public class Nota extends Thread{
    int valor;

    public Nota(int valor) {
        this.valor = valor;
    }

    public synchronized void esperar(){
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void dar(){
        this.notifyAll();
    }
}
