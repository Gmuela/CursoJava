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

var cuentaPropietario = new cuentaBancaria("ES12 2960 4967 09 1058396710", 17000);
var personaPropietario = new persona("Juan", "Pérez", "56789234-T", "img/propietario.jpg", cuentaPropietario);

var cuentaComprador = new cuentaBancaria("ES29 6948 5768 28 3856347183", 30000);
var personaComprador = new persona("Antonio", "Díaz", "02345187-H", "img/comprador.jpg", cuentaComprador);

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
    document.getElementById("botonTres").disabled = true;
    document.getElementById("botonCuatro").disabled = true;
    mostrarCasa(casa);
    mostrarPersona(casa.propietario);
    document.getElementById("precioCasa").innerHTML = "<h3>Vendida</h3>";
}
