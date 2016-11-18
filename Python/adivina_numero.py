# -*- coding: utf-8 -*-

import random


def definir_random():

    return random.randint(0, 100)


def verificar_numero(num, random):
    if num < random:
        resultado = (False, "Baja")
        return resultado
    elif num > random:
        resultado = (False, "Alta")
        return resultado
    else:
        resultado = (True, "")
        return resultado


def mostrar_mensaje(usuario, resultado):
    if resultado[0]:
        print "¡Excelente trabajo {}, tú ganas!".format(usuario)
    else:
        print "Lo siento {}, tu elección fue {}".format(usuario, resultado[1])


def jugar():
    usuario = pedir_nombre_usuario()
    aleatorio = definir_random()
    intentos = 0
    num = input("El número secreto ya ha sido establecido, ¿cuál es?:")
    resultado_verificacion = verificar_numero(num, aleatorio)

    while not resultado_verificacion[0]:
        intentos += 1
        mostrar_mensaje(usuario, resultado_verificacion)
        print "Número de intentos: {}".format(intentos)
        num = input("Elige otro número: ")
        resultado_verificacion = verificar_numero(num, aleatorio)

    mostrar_mensaje(usuario, resultado_verificacion)


def pedir_nombre_usuario():
    usuario = raw_input("Escribe tu nombre de usuario: ")
    while not usuario.isalpha():
        usuario = raw_input("Eso no es un nombre, vuelve a escribirlo:")

    return usuario


jugar()
