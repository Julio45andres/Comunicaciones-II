/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var chat=document.getElementById("chat");
var msj=document.getElementById("msjChat");
var username=document.getElementById("username");

var nomuser = '';

function enviarMsj(){    
    chat.innerHTML=chat.innerHTML+"<br/>Yo: "+msj.value;
    chat.value = "";
    var json={
        "msj":msj.value,
        "name":nomuser,
        "accion":"chat"
    };
    sendData(JSON.stringify(json));
}

//Esta función muestra el pop-up para ingresar el nombre de usuario, cuando
//se carga la página.
$(document).ready(function () {
    $('#popup').modal('show');
});

$('#popup').on('hidden.bs.modal', function(){
    nomuser = $('#username').val();
});