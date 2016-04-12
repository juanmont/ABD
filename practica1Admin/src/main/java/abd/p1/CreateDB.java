package abd.p1;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Crea la base de datos a partir de las anotaciones Hibernate contenidas
 * en el proyecto.
 * 
 * @author Manuel Montenegro (mmontene@ucm.es)
 */
public class CreateDB {

    /*
     * Antes de ejecutar el método main, comprueba que:
     * 
     * - Has añadido las anotaciones <mapping> dentro de hibernate.cfg.xml
     *   donde estén las clases marcadas con @Entity
     * 
     * - Has creado una base de datos vacía con el nombre Practica_XXX, donde
     *   XXX es vuestro número de grupo.
     * 
     * - Has modificado el fichero hibernate.cfg.xml para incluir el nombre
     *   de vuestra base de datos en la opcion 'connection.url'.
     * 
     * - El nombre de usuario de administrador de MySQL es 'root' y su
     *   contraseña es vacía. En caso contrario, modifica los argumentos de
     *   applySetting mostrados en el método.
     */
    
    public static void main(String[] args) {
        SessionFactory sf = null;
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .applySetting("hibernate.hbm2ddl.auto", "create")
                .applySetting("hibernate.connection.username", "root")
                .applySetting("hibernate.connection.password", "")
                .build();
        try {
            sf =  new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        } finally {
            if (sf != null) sf.close();
        }
    }

}
