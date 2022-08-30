package Controlador;

import Clases.Plan;
import Modelo.Consultas;
import java.util.LinkedList;

public class CCPlan {

    Consultas c;

    public CCPlan() {
        this.c = new Consultas();
    }

    public boolean crearPlan(Plan p) {
        try {
            String insertarPlan = String.format("INSERT INTO plan (codigo, nombre, valor ) VALUES ('%s', '%s', '%d')",
                    p.getCodigo(), p.getNombre(), p.getPrecio());
            System.out.println(insertarPlan);
            var result = c.ejecutarSentencia(insertarPlan);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }

    public LinkedList<Plan> listarPlanes() {

        LinkedList<Plan> listap = null;

        try {
            var consulta = "SELECT  *  FROM plan";
            listap= c.consultarRegistros(consulta, "Plan");
            return listap; 
        } catch (Exception e) {
        }
        return listap;
    }
}
