function casa(precio, direccion, metros, imagen, propietario) {
    this.precio = precio;
    this.direccion = direccion;
    this.metros = metros;
    this.imagen = imagen;
    this.propietario = propietario;
}

function cuentaBancaria(numCuenta, cantidadDinero) {
    this.numCuenta = numCuenta;
    this.cantidadDinero = cantidadDinero;
}

function persona(nombre, apellido, dni, imagen, cuentaBancaria) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.dni = dni;
    this.imagen = imagen;
    this.cuentaBancaria = cuentaBancaria;
}

var cuentaPropietario = new cuentaBancaria(11, 17000);
var personaPropietario = new persona("Juan", "Perez", "0001", "img/propietario.jpg", cuentaPropietario);

var cuentaComprador = new cuentaBancaria(12, 30000);
var personaComprador = new persona("Antonio", "Diaz", "0002", "img/comprador.jpg", cuentaComprador);

var casa = new casa(10000, "Avenida Olmos, Nº14", 140, "img/casa.jpg", personaPropietario);

function mostrarPersona(persona) {

    document.getElementById("nombrePersona").innerHTML = "Nombre: "+ persona.nombre + " " + persona.apellido;
    document.getElementById("dniPersona").innerHTML = "DNI: " + persona.dni;
    document.getElementById("imagenPersona").innerHTML = "<img src=\"" + persona.imagen + "\" />";
    document.getElementById("cuentaPersona").innerHTML = "<p>Número de cuenta: " + persona.cuentaBancaria.numCuenta + "</p><p>Cantidad de dinero: " + persona.cuentaBancaria.cantidadDinero + "€</p>";

}

function mostrarCasa(casa) {

    document.getElementById("precioCasa").innerHTML = "Precio: " + casa.precio + "€";
    document.getElementById("direccionCasa").innerHTML = "Dirección: " + casa.direccion;
    document.getElementById("metrosCasa").innerHTML = "Tamaño: " + casa.metros + "m2";
    document.getElementById("imagenCasa").innerHTML = "<img src=\"" + casa.imagen + "\" />";
    document.getElementById("propietarioCasa").innerHTML = "Propietario: " + casa.propietario.nombre + " " + casa.propietario.apellido;
}

function comprarCasa(casa, comprador) {
    casa.propietario.cuentaBancaria.cantidadDinero += casa.precio;
    casa.propietario = comprador;
    comprador.cuentaBancaria.cantidadDinero -= casa.precio;
    document.getElementById("botonUno").innerHTML = "Mostrar Aniguo Propietario";
    document.getElementById("botonDos").innerHTML = "Mostrar Nuevo Propietario";
    mostrarCasa(casa);
}
