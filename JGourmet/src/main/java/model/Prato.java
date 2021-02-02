/**
 * Value Object do Prato
 * 
 * Laboratorio para validacao em aptidao JAVA
 * 
 * 
 * @author Charles Rodrigues
 * @version 1.0, 2/2/2021
 * <pre>
 * https://www.linkedin.com/in/charlesrodrigues/
 * </pre>
 */

package model;

/**
 *
 * @author jonat_000
 */
public class Prato {
    
    private String descricao;
    private String caracteristica;        
    
    public Prato(String descricao, String caracteristica) {
        this.descricao = descricao;
        this.caracteristica = caracteristica;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }
    
}
