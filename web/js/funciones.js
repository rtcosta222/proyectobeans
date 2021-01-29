/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function mostrarPares() {
    var html = "<table border='1'>";
    for (var i = 2; i <= 20; i += 2) {
        html += "<tr>";
        html += "<td>Par</td>";
        html += "<td>" + i + "</td>";
        html += "</tr>";
    }
    html += "</table>";
    var resultado = document.getElementById("resultado");
    resultado.innerHTML = html;
}

