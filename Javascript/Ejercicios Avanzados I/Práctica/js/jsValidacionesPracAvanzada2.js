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
function fechaCheck() {

    var checked = false;

    var fecha = new Date(document.getElementById("fechaNacimiento").value).getTime();

    var fechaActual = (new Date().getTime());

    var milisTotal = fechaActual - fecha;

    var aniosCalculados;

    var aniosCalculados = Math.floor(milisTotal / 1000 / 60 / 60 / 24 / 365.25);

    if (aniosCalculados < 18) {

        document.getElementById("fechaError").innerHTML = "La edad mínima para registrarse son 18 años";

    } else {

        document.getElementById("fechaError").innerHTML = "";
        checked = true;
    }

    return checked;
}

/*VALIDACIÓN NOMRE DE USUARIO*/
var regExpNombreUsuario = /^[a-zA-Z0-9]+$/;

function nombreUsuarioCheck() {

    var checked = false;

    var campo = document.getElementById("nombreUsuario").value.trim();

    if (!(regExpNombreUsuario.test(campo))) {

        document.getElementById("nombreUsuarioError").innerHTML = campo + " no es válido. Solo se permiten carácteres alfanuméricos";

    } else {

        document.getElementById("nombreUsuarioError").innerHTML = "";
        checked = true;
    }

    return checked;
}

/*VALIDACIÓN EMAIL*/
var regExpEmail = /^(\w+\d+|\w+)\@[a-z]+\.([a-z]{2,})$/;

function emailCheck() {

    var checked = false;

    var email = document.getElementById("email").value.trim();

    if (!(regExpEmail.test(email))) {

        document.getElementById("emailError").innerHTML = "Email no válido";

    } else {

        document.getElementById("emailError").innerHTML = "";
        checked = true;
    }

    return checked;
}


/*VALIDACIÓN EMAIL*/
function passCheck() {

    var checked = false;

    var pass = document.getElementById("pass").value.trim();
    var passRepeat = document.getElementById("passRepeat").value.trim();

    if (pass != passRepeat && passRepeat != "") {

        document.getElementById("passError").innerHTML = "Las contraseñas no coinciden";

    } else {

        if (pass.length < 6) {

            document.getElementById("passError").innerHTML = "La contraseña necesita mínimo 6 caractéres";

        } else {

            document.getElementById("passError").innerHTML = "";
            checked = true;
        }

    }

    return checked;
}

/*VALIDACIÓN EXTRA*/
function fieldCheck(nombre, apellidos, nombreUsuario, correo, password) {

    var checked = true;

    if (!(regExpNombreCompleto.test(nombre)) || !(regExpNombreCompleto.test(apellidos))) {

        checked = false;

    } else if (!fechaCheck()) {

        checked = false;

    } else if (!(regExpNombreUsuario.test(nombreUsuario))) {

        checked = false;

    } else if (!(regExpEmail.test(correo))) {

        checked = false;

    } else if (!passCheck()) {

        checked = false;
    }

    return checked;
}
