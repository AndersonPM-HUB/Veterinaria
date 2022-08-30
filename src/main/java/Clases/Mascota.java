
package Clases;


public class Mascota {

    private int IdPk;
    private String nombreCliente; 
    private String codigo;
    private String nombre;
    private int annioNac;
    private int peso;
    private String especie;
    private int idCliente;

    public Mascota(String codigo, String nombre, int annioNac, int peso, String especie, int idCliente) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.annioNac = annioNac;
        this.peso = peso;
        this.especie = especie;
        this.idCliente = idCliente;
    }

    
    
    /**
     * @return the idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the annioNac
     */
    public int getAnnioNac() {
        return annioNac;
    }

    /**
     * @param annioNac the annioNac to set
     */
    public void setAnnioNac(int annioNac) {
        this.annioNac = annioNac;
    }

    /**
     * @return the peso
     */
    public int getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(int peso) {
        this.peso = peso;
    }

    /**
     * @return the especie
     */
    public String getEspecie() {
        return especie;
    }

    /**
     * @param especie the especie to set
     */
    public void setEspecie(String especie) {
        this.especie = especie;
    }

    /**
     * @return the IdPk
     */
    public int getIdPk() {
        return IdPk;
    }

    /**
     * @param IdPk the IdPk to set
     */
    public void setIdPk(int IdPk) {
        this.IdPk = IdPk;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Mascota{");
        sb.append("IdPk=").append(IdPk);
        sb.append(", nombreCliente=").append(nombreCliente);
        sb.append(", codigo=").append(codigo);
        sb.append(", nombre=").append(nombre);
        sb.append(", annioNac=").append(annioNac);
        sb.append(", peso=").append(peso);
        sb.append(", especie=").append(especie);
        sb.append(", idCliente=").append(idCliente);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
