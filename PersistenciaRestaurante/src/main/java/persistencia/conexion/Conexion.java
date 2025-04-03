package persistencia.conexion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Jesus Osuna 240549
 */
public class Conexion {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");


    public static EntityManager crearConexion() {
        return emf.createEntityManager();
    }
    public static void cerrar() {
        if (emf.isOpen()) {
            emf.close();
        }
    }

}

