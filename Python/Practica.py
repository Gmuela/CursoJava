# -*- coding: utf-8 -*-

import math


class Operaciones():
    lista_numeros = list()

    def __init__(self, lista_numeros):
        self.lista_numeros = lista_numeros

    def maximo(self):
        return max(self.lista_numeros)

    def suma(self):
        return sum(self.lista_numeros)

    def media(self):
        return self.suma() / float(len(self.lista_numeros))


def insertar_numeros():
    lista_numeros = list()
    nuevo_num = 0

    while float(nuevo_num) != -1:
        nuevo_num = raw_input("Introduce el valor(-1 para salir): ")
        if nuevo_num.isdigit() and float(nuevo_num) >= 0:
            lista_numeros.append(float(nuevo_num))
        else:
            print "Número erróneo"
    return lista_numeros


lista_numeros = insertar_numeros()
operacion = Operaciones(lista_numeros)
print "El número máximo es ->", operacion.maximo()
print "La suma de todos los números es ->", operacion.suma()
print "La media es -> ", operacion.media()
