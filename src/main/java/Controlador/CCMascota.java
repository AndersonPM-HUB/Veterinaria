package Controlador;

import Clases.Mascota;
import Modelo.Consultas;
import java.util.LinkedList;

public class CCMascota {

    Consultas c;

    public CCMascota() {
        this.c = new Consultas();

    }

    public boolean crearMascota(Mascota m) {

        try {
            String sentencia = String.format("INSERT INTO mascota (codigo, nombre, fechaN, peso, especie, idCliente) VALUES ('%s','%s','%d','%d','%s','%d')",
                    m.getCodigo(), m.getNombre(), m.getAnnioNac(), m.getPeso(), m.getEspecie(), m.getIdCliente());

            System.out.println(sentencia);
            var rta = c.ejecutarSentencia(sentencia);
            return rta;
        } catch (Exception e) {
            return false;
        }

    }

    public LinkedList<Mascota> listarMascotas() {

        LinkedList listadom = null;
        try {
            listadom = c.consultarRegistros("SELECT  idMascota, codigo, nombre, fechaN,peso, especie, idCliente ,c.nombres FROM mascota JOIN cliente as c where idCliente= c.id", "Mascota");

            System.out.println(listadom.size());
            return listadom;
        } catch (Exception e) {
            System.out.println(e);
        }
        return listadom;

    }

    public boolean editarMascota(Mascota m) {

        try {
            String sentencia = String.format("UPDATE mascota SET nombre='%s', fechaN='%d', peso='%d', especie='%s', idCliente='%d' WHERE idMascota='%d'",
                    m.getNombre(), m.getAnnioNac(), m.getPeso(), m.getEspecie(), m.getIdCliente(), m.getIdPk());
            var rta = c.ejecutarSentencia(sentencia);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean borrarMascota(String pk) {
        try {
            int id = Integer.parseInt(pk);
            String s = String.format("DELETE FROM mascota WHERE idMascota='%d'", id);
            var rta = c.ejecutarSentencia(s);
            return rta;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }

}
