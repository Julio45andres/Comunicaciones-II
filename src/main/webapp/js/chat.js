/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var chat=document.getElementById("chat");
var msj=document.getElementById("msjChat");
var username=document.getElementById("username");

var nomuser = '';

//Lista de los usuarios conectados
var listaUser=document.getElementById("listaUser");

msj.addEventListener("keypress",function(){
    var evento= event || window.event;
    //Si es enter envia el mensaje
    if(evento.charCode===13){
        enviarMsj();
    }
    
});
function enviarMsj(){    
    chat.innerHTML=chat.innerHTML+"<br/>Yo: "+msj.value;
    chat.scrollTop=chat.scrollHeight;
    var json={
        "msj":msj.value,
        "name":nomuser,
        "accion":"chat"
    };
    /*Limpia la caja de texto, si se hace en javascript estandar no funciona en Chrome,
     *por eso se usa jquery*/
    $('#msjChat').val('');
    sendData(json);
}

//Esta función muestra el pop-up para ingresar el nombre de usuario, cuando
//se carga la página.
$(document).ready(function () {
    $('#popup').modal('show');
    $('body').css('background-color', 'green');
    $('#juego').hide();
});

//Se usa para mostrar el nombre de un jugador a los demas usuarios en el chat.
$('#popup').on('hidden.bs.modal', function(){
    nomuser = $('#username').val();
    $('body').css('background-color', 'white');
    $('#juego').show();
});

/**
 * Funcion que registra los usuarios
 * @returns {undefined}
 */
function registraJugador(){
    var json={
        "name":username.value,
        "accion":"newUser"
    };
    sendData(json);
}

/**
 * Funcion que lista los nuevos usuarios
 * @param {type} arrayUser
 * @returns {undefined}
 */
function listarUsuarios(arrayUser){
    var item;
    //Se limpia la lista
    listaUser.innerHTML="";
    for(var i=0;i<arrayUser.length;i++){
        item=document.createElement("li");
        item.innerHTML=arrayUser[i];        
        listaUser.appendChild(item);
    }
}
