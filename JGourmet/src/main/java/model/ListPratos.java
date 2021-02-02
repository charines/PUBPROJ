
/**
 * Laboratorio para validacao em aptidao JAVA
 * 
 * Listas dos pratos oferecidos 
 * 
 * @author Charles Rodrigues
 * @version 1.0, 2/2/2021
 * <pre>
 * https://www.linkedin.com/in/charlesrodrigues/
 * </pre>
 */

package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jonat_000
 */
public class ListPratos {
    
    private List<Prato> pratos = new ArrayList<>();

    public List<Prato> getPratos() {
        return pratos;
    }

    public void setPratos(List<Prato> pratos) {
        this.pratos = pratos;
    }
    
}
