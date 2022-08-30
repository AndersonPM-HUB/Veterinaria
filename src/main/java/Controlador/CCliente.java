package Controlador;

import Clases.*;
import Modelo.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

public class CCliente {

    Consultas c;

    public CCliente() {
        this.c = new Consultas();

    }

    public boolean crearCliente(Cliente cliente) {
        try {

            //query o sentencia 
            String query = String.format("INSERT INTO cliente (identificacion,nombres,apellidos,direccion,telefono) VALUES ('%s','%s','%s','%s','%s')",
                    cliente.getIdenctificacion(), cliente.getNombres(), cliente.getApellidos(), cliente.getDireccion(), cliente.getTelefono());

            var rta = c.ejecutarSentencia(query);
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public LinkedList<Cliente> listarClientes() {

        LinkedList<Cliente> listaClientes = new LinkedList<>();
        try {
            String consulta = "SELECT * FROM cliente";
            String clase = "Cliente";
            listaClientes = c.consultarRegistros(consulta, clase);
            System.out.println(listaClientes.size());
            return listaClientes;
        } catch (Exception e) {
            System.out.println(e);
        }
        return listaClientes;
    }

    public boolean editar(Cliente cliente) {
        try {
            String sentencia = String.format("UPDATE cliente SET nombres = '%s', apellidos = '%s', direccion = '%s', telefono = '%s' WHERE identificacion = '%s'",
                    cliente.getNombres(), cliente.getApellidos(), cliente.getDireccion(), cliente.getTelefono(), cliente.getIdenctificacion());
            var rta = c.ejecutarSentencia(sentencia);
            return rta;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean borrarCliente(String cc) {
        try {
            String sentencia = String.format("DELETE FROM cliente WHERE identificacion= '%s'", cc);
            var rta = c.ejecutarSentencia(sentencia);
            return rta;
        } catch (Exception e) {
            return false;
        }

    }
    
    public String buscarCliente(String cc){
        String  info = null; 
        try {
            String consulta = String.format("SELECT * FROM cliente  WHERE identificacion = '%s'", cc);
            var data = c.consultarRegistros(consulta, "Cliente");
            info = data.get(0).toString(); 
            return info; 
        } catch (Exception e) {
        }
    return info; 
    
    
    }
}
