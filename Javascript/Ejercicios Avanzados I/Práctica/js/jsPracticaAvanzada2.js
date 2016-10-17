var usuariosRegistrados = new Array();

function usuario(nombre, apellidos, fechaNacimiento, nombreUsuario, correo, password) {

    this.nombre = nombre;
    this.apellidos = apellidos;
    this.fechaNacimiento = fechaNacimiento;
    this.nombreUsuario = nombreUsuario;
    this.correo = correo;
    this.password = password;
}

function crearNuevoUsuario() {

    var nombre = document.getElementById("nombre").value.trim();
    var apellidos = document.getElementById("apellidos").value.trim();
    var fechaNac = new Date(document.getElementById("fechaNacimiento").value);
    var nombreUsuario = document.getElementById("nombreUsuario").value.trim();
    var correo = document.getElementById("email").value.trim();
    var password = document.getElementById("pass").value.trim();

    var nuevoUsuario = new usuario(nombre, apellidos, fechaNac, nombreUsuario, correo, password);

    registro(nuevoUsuario);

    mostrarRegistros();

}

function passCheck(){

    var pass = document.getElementById("pass").value;
    var passRepeat = document.getElementById("passRepeat").value;

    if(pass != passRepeat){

        document.getElementById("errorPass").innerHTML = "Las contraseñas no coinciden";

    }
    else{
        document.getElementById("errorPass").innerHTML = "";
    }

}

function registro(nuevoUsuario) {

    usuariosRegistrados.push(nuevoUsuario);
}

function mostrarRegistros() {

    if (usuariosRegistrados.length == 0) {

        document.getElementById("nombreUserReg1").innerHTML = "";
        document.getElementById("apellidosUserReg1").innerHTML = "";
        document.getElementById("edadUserReg1").innerHTML = "";
        document.getElementById("nombreUserReg2").innerHTML = "";
        document.getElementById("apellidosUserReg2").innerHTML = "";
        document.getElementById("edadUserReg2").innerHTML = "";
    }

    document.getElementById("nombreUserReg1").innerHTML = usuariosRegistrados[0].nombre;
    document.getElementById("apellidosUserReg1").innerHTML = usuariosRegistrados[0].apellidos;

    var edadPrimero = calcularTiempo(usuariosRegistrados[0].fechaNacimiento, 1)

    document.getElementById("edadUserReg1").innerHTML = edadPrimero;

    document.getElementById("nombreUserReg2").innerHTML = usuariosRegistrados[usuariosRegistrados.length - 1].nombre;
    document.getElementById("apellidosUserReg2").innerHTML = usuariosRegistrados[usuariosRegistrados.length - 1].apellidos;

    var edadUltimo = calcularTiempo(usuariosRegistrados[usuariosRegistrados.length - 1].fechaNacimiento, 1)

    document.getElementById("edadUserReg2").innerHTML = edadUltimo;

}

function borrarRegistro(id) {

    //TODO

}




function calcularTiempo(fecha, detalle) {

    var tiempoCalculado;

    var fechaActual = (new Date().getTime());

    var fecha = fecha.getTime();

    var milisTotal = fechaActual - fecha;

    var aniosCalculados;

    var aniosCalculados = Math.floor(milisTotal / 1000 / 60 / 60 / 24 / 365.25);

    tiempoCalculado = aniosCalculados + " años";

    return tiempoCalculado;
}
