package Clases;

public class Cliente {

    private int idPk;
    private String idenctificacion;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String telefono;

    private Mascota m; //relacion de asociacion 

    public Cliente(String idenctificacion, String nombres, String apellidos, String direccion, String telefono) {
        this.idenctificacion = idenctificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    /**
     * @return the idenctificacion
     */
    public String getIdenctificacion() {
        return idenctificacion;
    }

    /**
     * @param idenctificacion the idenctificacion to set
     */
    public void setIdenctificacion(String idenctificacion) {
        this.idenctificacion = idenctificacion;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdPk() {
        return idPk;
    }

    public void setIdPk(int idPk) {
        this.idPk = idPk;
    }

    public Mascota getM() {
        return m;
    }

    public void setM(Mascota m) {
        this.m = m;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente{");
        sb.append("idenctificacion=").append(idenctificacion);
        sb.append(", nombres=").append(nombres);
        sb.append(", apellidos=").append(apellidos);
        sb.append(", direccion=").append(direccion);
        sb.append(", telefono=").append(telefono);
        sb.append(", mascota=").append(m);
        sb.append('}');
        return sb.toString();
    }

}
