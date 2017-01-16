import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

public class Connection {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPAPrueba");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        Descuento descuento = new Descuento();
        descuento.setValue(50);
        descuento.setFechaFinal(LocalDate.now());

        Pelicula pelicula = new Pelicula();
        pelicula.setTitulo("Peli1");
        pelicula.setDuracion(290);
        pelicula.setDescuento(descuento);

        Pelicula pelicula2 = new Pelicula();
        pelicula2.setTitulo("Peli chula");
        pelicula2.setDuracion(200);
        pelicula2.setDescuento(descuento);

        Pelicula pelicula3 = new Pelicula();
        pelicula3.setTitulo("Peli total");
        pelicula3.setDuracion(60);
        pelicula3.setDescuento(descuento);

        try{
            entityTransaction.begin();
            entityManager.persist(pelicula);
            entityManager.persist(pelicula2);
            entityManager.persist(pelicula3);
            entityTransaction.commit();
        }catch (Exception e){
            entityTransaction.rollback();
            e.printStackTrace();
        }

        String consulta = "SELECT p FROM Pelicula p";
        Query query = entityManager.createQuery(consulta);
        List<Pelicula> pelis = query.getResultList();
        for (Pelicula peli : pelis) {
            System.out.println(peli.getTitulo());
            System.out.println(peli.getDescuento().getValue());
            System.out.println(peli.getDuracion());
        }
        entityManager.close();
        entityManagerFactory.close();
    }
}
