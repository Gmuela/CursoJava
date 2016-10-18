var usuariosRegistrados = new Array();

function usuario(nombre, apellidos, fechaNacimiento, nombreUsuario, correo, password) {

    this.nombre = nombre;
    this.apellidos = apellidos;
    this.fechaNacimiento = fechaNacimiento;
    this.nombreUsuario = nombreUsuario;
    this.correo = correo;
    this.password = password;
}

function allowRegister() {

    var allowed = true;

    var nombre = document.getElementById("nombre").value.trim();
    var apellidos = document.getElementById("apellidos").value.trim();
    var fechaNac = document.getElementById("fechaNacimiento").value;
    var nombreUsuario = document.getElementById("nombreUsuario").value.trim();
    var correo = document.getElementById("email").value.trim();
    var password = document.getElementById("pass").value.trim();
    var repeatPassword = document.getElementById("passRepeat").value.trim();

    if (nombre == "" || apellidos == "" || fechaNac == "" || nombreUsuario == "" || correo == "" || password == "" || repeatPassword == "") {

        allowed = false;

    }

    if (password != repeatPassword) {

        allowed = false;

    }

    if(!fieldCheck(nombre,apellidos, nombreUsuario, correo, password)){

        allowed = false;

    }

    for (var i = 0; i <= usuariosRegistrados.length - 1; i++) {

        if (usuariosRegistrados[i].nombreUsuario == nombreUsuario || usuariosRegistrados[i].correo == correo) {

            allowed = false;

        }
    }

    return allowed;
}

function crearNuevoUsuario() {

    if (allowRegister()) {
        var nombre = document.getElementById("nombre").value.trim();
        var apellidos = document.getElementById("apellidos").value.trim();
        var fechaNac = document.getElementById("fechaNacimiento").value;
        var nombreUsuario = document.getElementById("nombreUsuario").value.trim();
        var correo = document.getElementById("email").value.trim();
        var password = document.getElementById("pass").value.trim();

        var nuevoUsuario = new usuario(nombre, apellidos, fechaNac, nombreUsuario, correo, password);

        registro(nuevoUsuario);

        mostrarRegistros();

        limpiarFormulario();

    } else {

        document.getElementById("registerError").innerHTML = "Usuario no registrado. Campos vacíos/erróneos o nombre de usuario/correo ya existentes.";
    }
}

function registro(nuevoUsuario) {

    usuariosRegistrados.push(nuevoUsuario);
}

function mostrarRegistros() {

    var salida = "<tr><th>Nombre de usuario</th><th>Nombre</th><th>Edad</th><th>Correo eletrónico</th><th>Eliminar usuario</th><th>Modificar usuario</th></tr>";

    for (var i = 0; i <= usuariosRegistrados.length - 1; i++) {

        salida += "<tr><td>" + usuariosRegistrados[i].nombreUsuario + "</td>" + "<td>" + usuariosRegistrados[i].nombre + "</td>" + "<td>" + calcularTiempo(usuariosRegistrados[i].fechaNacimiento) + "</td>" + "<td>" + usuariosRegistrados[i].correo + "</td>" + "<td><button class='myDelButton' onclick='eliminarRegistro(" + i + ")'>Eliminar</button>" + "<td><button class='myUpdButton' onclick='modificarRegistro(" + i + ")'>Modificar</button></tr>";

    }

    document.getElementById("tablaUsuarios").innerHTML = salida;

}

function limpiarFormulario() {
    document.getElementById("nombre").value = "";
    document.getElementById("apellidos").value = "";
    document.getElementById("fechaNacimiento").value = "";
    document.getElementById("nombreUsuario").value = "";
    document.getElementById("email").value = "";
    document.getElementById("pass").value = "";
    document.getElementById("passRepeat").value = "";
    document.getElementById("registerError").innerHTML = "";
}

function eliminarRegistro(index) {

    usuariosRegistrados.splice(index, 1);

    mostrarRegistros();

    document.getElementById("tablaUsuarios").innerHTML = "";

}

function modificarRegistro(index) {

    document.getElementById("nombre").value = usuariosRegistrados[index].nombre;
    document.getElementById("apellidos").value = usuariosRegistrados[index].apellidos;
    document.getElementById("fechaNacimiento").value = usuariosRegistrados[index].fechaNacimiento;
    document.getElementById("nombreUsuario").value = usuariosRegistrados[index].nombreUsuario;
    document.getElementById("email").value = usuariosRegistrados[index].correo;
    document.getElementById("pass").value = "";
    document.getElementById("passRepeat").value = "";

    document.getElementById("botonFormulario").innerHTML = "<button class='myButton' id='modificar' onclick='modificarUsuario(" + index + ")'>Modificar</button>"
    document.getElementById("labelPass").innerHTML = "Nueva contraseña";
    document.getElementById("labelRepeatPass").innerHTML = "Repite la nueva contraseña";

}

function modificarUsuario(index) {

    if (allowRegister()) {
        var nombre = document.getElementById("nombre").value.trim();
        var apellidos = document.getElementById("apellidos").value.trim();
        var fechaNac = document.getElementById("fechaNacimiento").value;
        var nombreUsuario = document.getElementById("nombreUsuario").value.trim();
        var correo = document.getElementById("email").value.trim();
        var password = document.getElementById("pass").value.trim();

        usuariosRegistrados[index].nombre = nombre;
        usuariosRegistrados[index].apellidos = apellidos;
        usuariosRegistrados[index].fechaNacimiento = fechaNac;
        usuariosRegistrados[index].nombreUsuario = nombreUsuario;
        usuariosRegistrados[index].correo = correo;
        usuariosRegistrados[index].password = password;

        mostrarRegistros();

        limpiarFormulario();

        document.getElementById("botonFormulario").innerHTML = "<button class='myButton' id='registro' onclick='crearNuevoUsuario()'>Registrarse</button>";
        document.getElementById("labelPass").innerHTML = "Contraseña";
        document.getElementById("labelRepeatPass").innerHTML = "Repite la contraseña";

    } else {
        document.getElementById("registerError").innerHTML = "Usuario no modificado. Campos vacíos/erróneos o nombre de usuario/correo ya existentes.";
    }
}


function calcularTiempo(fecha) {

    var tiempoCalculado;

    var fechaActual = (new Date().getTime());

    var fecha = new Date(fecha).getTime();

    var milisTotal = fechaActual - fecha;

    var aniosCalculados;

    var aniosCalculados = Math.floor(milisTotal / 1000 / 60 / 60 / 24 / 365.25);

    tiempoCalculado = aniosCalculados + " años";

    return tiempoCalculado;
}
