package Modelo;

import Clases.Cliente;
import Clases.Mascota;
import Clases.Plan;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

public class Consultas {

    private ConexionBD bd;

    public Consultas() {
        this.bd = new ConexionBD();
    }

    public boolean ejecutarSentencia(String sentencia) {

        try ( Connection conn = DriverManager.getConnection(bd.getUrl(), bd.getUser(), bd.getPassword())) {
            PreparedStatement ps = conn.prepareStatement(sentencia);
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false; //retorno falso para validar en las otras capas 
        }

    }

    //metodo de consultar SELECT
    public LinkedList consultarRegistros(String sentencia, String clase) {

        LinkedList<Object> lista = new LinkedList<>();
        LinkedList<Object> listam = new LinkedList<>();
        LinkedList<Object> listap = new LinkedList<>();
        LinkedList<Object> reporte = new LinkedList<>();
        try ( Connection conn = DriverManager.getConnection(bd.getUrl(), bd.getUser(), bd.getPassword())) {
            //obtener la info 
            PreparedStatement ps = conn.prepareStatement(sentencia, Statement.RETURN_GENERATED_KEYS);
            ResultSet rta = ps.executeQuery();

            if (clase.equals("Cliente")) {

                while (rta.next()) {
                    int id = rta.getInt("id");
                    String identificacion = rta.getString("identificacion");
                    String nombres = rta.getString("nombres");
                    String apellidos = rta.getString("apellidos");
                    String direccion = rta.getString("direccion");
                    String telefono = rta.getString("telefono");

                    Cliente c = new Cliente(identificacion, nombres, apellidos, direccion, telefono);
                    c.setIdPk(id);
                    lista.add(c);
                }
                return lista;
            } else if (clase.equals("Mascota")) {
                while (rta.next()) {
                    int idm = rta.getInt("idMascota");
                    var codigo = rta.getString("codigo");
                    var nombrepet = rta.getString("nombre");
                    var fecha = rta.getInt("fechaN");
                    var peso = rta.getInt("peso");
                    var especie = rta.getString("especie");
                    var idcliente = rta.getInt("idCliente");
                    var nombrecli = rta.getString("nombres");

                    Mascota m = new Mascota(codigo, nombrepet, fecha, peso, especie, idcliente);
                    m.setIdPk(idm);

                    m.setNombreCliente(nombrecli);
                    listam.add(m);
                }
                return listam;
            } else if (clase.equals("Plan")) {
                while (rta.next()) {

                    int idPk = rta.getInt("idPlan");
                    var codigo = rta.getString("codigo");
                    var nombre = rta.getString("nombre");
                    var precio = rta.getInt("valor");

                    Plan p = new Plan(codigo, nombre, precio);
                    p.setIdPk(idPk);
                    listap.add(p);

                }
                return listap;

            }
            else if (clase.equals("Pago")) {
                while (rta.next()) {

                    String f = rta.getInt("idPago") +"|"+ rta.getString("fechaPago") +"|"+ rta.getString("nCuotas") +"|"+ rta.getString("codigo") 
                             +"|"+ rta.getString("nombre") +"|"+ rta.getString("valor") +"|"+ rta.getString("identificacion") +"|"+ rta.getString("nombres"); 
                    System.out.println(f);
                    reporte.add(f);

                }
                return reporte;

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return lista;
    }

}
