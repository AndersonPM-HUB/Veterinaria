package Controlador;

import Clases.Pago;
import Clases.Plan;
import Modelo.Consultas;
import java.util.LinkedList;

public class CCPago {

    Consultas c;

    public CCPago() {
        this.c = new Consultas();
    }

    public boolean crearPago(Pago pago) {

        try {
            String sentencia = String.format("INSERT INTO pago ( fechaPago, nCuotas, idMascota1, idPlan1) VALUES ('%s' ,'%d', '%d', '%d')",
                    pago.getFechaPago(), pago.getNumeroCuotas(), pago.getIdMascota(), pago.getIdPlan());
            System.out.println(sentencia);

            var rta = c.ejecutarSentencia(sentencia);
            return rta;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }

    public LinkedList infoFactura() {
        LinkedList<Object> reportes = null;
        try {
            String s = ("SELECT pa.idPago, pa.fechaPago, pa.nCuotas, m.codigo, m.nombre, p.nombre, p.valor, c.identificacion,c.nombres from pago as pa join mascota as m  join cliente as c join plan as p\n"
                    + "where pa.idMascota1= m.idMascota && pa.idPlan1 = p.idPlan && m.idCliente =c.id");
            reportes = c.consultarRegistros(s, "Pago");
            System.out.println(reportes.size());
            return reportes;

        } catch (Exception e) {
            System.out.println(e);
        }
        return reportes;
    }

}
