/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author lscar
 */
public class Bean02TablaMultiplicar {
    public String getTablaMultiplicar(int numero) {
        String html = "<table border='1'>";
        html += "<tr><th>Operación</th><th>Resultado</th></tr>";
        for (int i=1; i<=10; i++) {
            String operacion = numero + "*" + i;
            int resultado = numero * i;
            html += "<tr><td>" + operacion + "</td><td>" + resultado + "</td></tr>";
        }
        html += "</table>";
        return html;
    }
}
