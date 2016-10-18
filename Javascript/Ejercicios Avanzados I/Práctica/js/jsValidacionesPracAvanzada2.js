/*VALIDACIÓN NOMBRE Y APELLIDOS*/
var regExpNombreCompleto = /^[a-zA-Z ]{2,}$/;

function nombreCompletoCheck(id) {

    var campo = document.getElementById(id).value.trim();

    if (!(regExpNombreCompleto.test(campo))) {

        document.getElementById(id + "Error").innerHTML = campo + " no es válido. Solo se permiten al menos 2 carácteres alfabéticos";

    } else {

        document.getElementById(id + "Error").innerHTML = "";
    }

}

/*VALIDACIÓN FECHA NACIMIENTO*/
function fechaCheck(){

    var fecha = new Date(document.getElementById("fechaNacimiento").value).getTime();



    var fechaActual = (new Date().getTime());

    var milisTotal = fechaActual - fecha;

    var aniosCalculados;

    var aniosCalculados = Math.floor(milisTotal / 1000 / 60 / 60 / 24 / 365.25);

    if(aniosCalculados < 18){

        document.getElementById("fechaError").innerHTML = "La edad mínima para registrarse son 18 años";
    }
    else{
        document.getElementById("fechaError").innerHTML = "";
    }

}

/*VALIDACIÓN NOMRE DE USUARIO*/
var regExpNombreUsuario = /^[a-zA-Z0-9]+$/;

function nombreUsuarioCheck() {

    var campo = document.getElementById("nombreUsuario").value.trim();

    if (!(regExpNombreUsuario.test(campo))) {

        document.getElementById("nombreUsuarioError").innerHTML = campo + " no es válido. Solo se permiten carácteres alfanuméricos";

    } else {

        document.getElementById("nombreUsuarioError").innerHTML = "";
    }

}

/*VALIDACIÓN EMAIL*/
var regExpEmail = /^(\w+\d+|\w+)\@[a-z]+\.com$/;

function emailCheck() {

    var email = document.getElementById("email").value.trim();

    if (!(regExpEmail.test(email))) {

        document.getElementById("emailError").innerHTML = "Email no válido";

    } else {

        document.getElementById("emailError").innerHTML = "";
    }

}


/*VALIDACIÓN EMAIL*/
function passCheck() {

    var pass = document.getElementById("pass").value.trim();
    var passRepeat = document.getElementById("passRepeat").value.trim();

    if (pass != passRepeat && passRepeat != "") {

        document.getElementById("passError").innerHTML = "Las contraseñas no coinciden";

    } else {

        if (pass.length < 6) {

            document.getElementById("passError").innerHTML = "La contraseña necesita mínimo 6 caractéres";
        } else {

            document.getElementById("passError").innerHTML = "";
        }

    }

}
