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
public class Bean02TablaMultiplicarRepaso {

    public String multiplicar(int num) {
        String html = "<table border='1'>";
        html += "<tr><th>Operación</th><th>Resultado</th></tr>";
        for (int i=1; i<=10; i++) {
            html += "<tr><td>" + num + "*" + i +"</td><td>" + num*i + "</td></tr>";
        }
        html += "</table>";
        return html;
    }
}
