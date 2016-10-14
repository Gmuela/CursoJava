var usuariosRegistrados = new Array();

function usuario(nombre, apellidos, fechaNacimiento, fechaCarnet, fechaEstudios) {

    this.nombre = nombre;
    this.apellidos = apellidos;
    this.fechaNacimiento = fechaNacimiento;
    this.fechaCarnet = fechaCarnet;
    this.fechaEstudios = fechaEstudios;
}

function crearNuevoUsuario() {

    var nombre = document.getElementById("nombre").value.trim();
    var apellidos = document.getElementById("apellidos").value.trim();
    var fechaNac = new Date(document.getElementById("fechaNacimiento").value);
    var fechaCar = new Date(document.getElementById("fechaCarnet").value);
    var fechaEst = new Date(document.getElementById("fechaEstudios").value);

    var nuevoUsuario = new usuario(nombre, apellidos, fechaNac, fechaCar, fechaEst);

    registro(nuevoUsuario);

    mostrarInformacion(nuevoUsuario);

    mostrarRegistros();

}

function registro(nuevoUsuario) {

    usuariosRegistrados.push(nuevoUsuario);
}

function mostrarInformacion(nuevoUsuario) {

    var apellidosSeparados = separarApellidos(nuevoUsuario.apellidos);

    document.getElementById("nombreUser").innerHTML = nuevoUsuario.nombre;
    document.getElementById("apellidoUser").innerHTML = apellidosSeparados[0];

    if (apellidosSeparados[1] == undefined) {

        document.getElementById("segApellidoUser").innerHTML = "";

    } else {
        document.getElementById("segApellidoUser").innerHTML = apellidosSeparados[1];
    }


    var fechaNac = formatoFecha(nuevoUsuario.fechaNacimiento, "/");
    var fechaCar = formatoFecha(nuevoUsuario.fechaCarnet, "/");
    var fechaEs = formatoFecha(nuevoUsuario.fechaEstudios, "/");

    var edad = calcularTiempo(nuevoUsuario.fechaNacimiento, 1);
    var tiempoCarnet = calcularTiempo(nuevoUsuario.fechaCarnet, 1);
    var tiempoEstudios = calcularTiempo(nuevoUsuario.fechaEstudios, 1);

    document.getElementById("fechaNacUser").innerHTML = fechaNac;
    document.getElementById("edadUser").innerHTML = edad;

    document.getElementById("fechaCarUser").innerHTML = fechaCar;
    document.getElementById("tiempoCarUser").innerHTML = tiempoCarnet;

    document.getElementById("fechaEsUser").innerHTML = fechaEs;
    document.getElementById("tiempoEsUser").innerHTML = tiempoEstudios;
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

function borrarUltimoRegistro() {

    usuariosRegistrados.pop();

    mostrarRegistros();

}

function separarApellidos(apellidos) {

    return apellidos.split(" ");

}

function formatoFecha(fecha, formato) {

    var dia = fecha.getDate();
    var mes = fecha.getMonth() + 1;
    var anio = fecha.getFullYear();

    var fechaFormateada;

    if (formato == "-") {

        fechaFormateada = anio + "-" + mes + "-" + dia;

    } else if (formato == "/") {

        fechaFormateada = dia + "/" + mes + "/" + anio;

    }

    return fechaFormateada;
}

function calcularTiempo(fecha, detalle) {

    var tiempoCalculado;

    var diasDeFechaActual = (new Date().getTime()) / (1000 * 60 * 60 * 24);

    var diasFecha = fecha.getTime() / (1000 * 60 * 60 * 24);

    var diasTotal = diasDeFechaActual - diasFecha;

    var diasCalculados = 0;
    var mesesCalculados = 0;
    var aniosCalculados = 0;

    var controlMes = true;
    var controlFebrero = true;

    for (var i = diasTotal; i > 0; i--) {

        diasCalculados++;

        if (controlFebrero) {

            if (diasCalculados > 28) {
                mesesCalculados++;
                diasCalculados = 0;
                controlFebrero = !controlFebrero;
            }
        } else {

            if (controlMes) {

                if (diasCalculados > 30) {
                    mesesCalculados++;
                    diasCalculados = 0;
                    controlMes = !controlMes;

                }
            } else {

                if (diasCalculados > 31) {
                    mesesCalculados++;
                    diasCalculados = 0;
                    controlMes = !controlMes;
                }
            }

            if (mesesCalculados > 12) {
                aniosCalculados++;
                mesesCalculados = 0;
                controlFebrero = !controlFebrero;
            }
        }
    }

    if (detalle == 1) {

        tiempoCalculado = aniosCalculados + " años";

    } else if (detalle == 2) {

        tiempoCalculado = aniosCalculados + " años y " + mesesCalculados + " meses";

    } else if (detalle == 3) {

        tiempoCalculado = aniosCalculados + " años, " + mesesCalculados + " meses y " + diasCalculados + " días";
    }

    return tiempoCalculado;
}

function cambiarDetalle(detalle) {

    var fechaNac = usuariosRegistrados[usuariosRegistrados.length - 1].fechaNacimiento;
    var fechaCar = usuariosRegistrados[usuariosRegistrados.length - 1].fechaCarnet;
    var fechaEs = usuariosRegistrados[usuariosRegistrados.length - 1].fechaEstudios;

    var edad = calcularTiempo(fechaNac, detalle);
    var tiempoCarnet = calcularTiempo(fechaCar, detalle);
    var tiempoEstudios = calcularTiempo(fechaEs, detalle);

    document.getElementById("edadUser").innerHTML = edad;
    document.getElementById("tiempoCarUser").innerHTML = tiempoCarnet;
    document.getElementById("tiempoEsUser").innerHTML = tiempoEstudios;

}

function cambiarFormatoFecha(formato) {

    var fechaNac = usuariosRegistrados[usuariosRegistrados.length - 1].fechaNacimiento;
    var fechaCar = usuariosRegistrados[usuariosRegistrados.length - 1].fechaCarnet;
    var fechaEs = usuariosRegistrados[usuariosRegistrados.length - 1].fechaEstudios;

    var fechaNacFor = formatoFecha(fechaNac, formato);
    var fechaCarFor = formatoFecha(fechaCar, formato);
    var fechaEsFor = formatoFecha(fechaEs, formato);

    document.getElementById("fechaNacUser").innerHTML = fechaNacFor;

    document.getElementById("fechaCarUser").innerHTML = fechaCarFor;

    document.getElementById("fechaEsUser").innerHTML = fechaEsFor;

}
