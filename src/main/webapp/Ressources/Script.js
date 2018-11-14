/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var table = document.getElementById('database-table');
for (var i = 1; i < table.rows.length; i++) {
    table.rows[i].onclick = function () {
        document.getElementById("productid").value = this.cells[0].innerHTML;
        document.getElementById("name-field").value = this.cells[1].innerHTML;
        document.getElementById("price-field").value = this.cells[2].innerHTML;
        document.getElementById("desc-field").value = this.cells[3].innerHTML;
        document.getElementById("length-field").value = this.cells[4].innerHTML;
        document.getElementById("unit-field").value = this.cells[5].innerHTML;
        document.getElementById("type-field").value = this.cells[6].innerHTML;
        console.log(document.getElementById("productid").value);
    };
}

function clearTextfields() {
    document.getElementById("productid").value = "";
    document.getElementById("name-field").value = "";
    document.getElementById("price-field").value = "";
    document.getElementById("desc-field").value = "";
    document.getElementById("length-field").value = "";
    document.getElementById("unit-field").value = "";
    document.getElementById("type-field").value = "";
}