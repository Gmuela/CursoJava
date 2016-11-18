# -*- coding: utf-8 -*-


def calcular_edad(edad):

    if edad == 1:
        return 14

    if edad == 2:
        return 22

    if edad > 2:
        result = 22+(5*(edad-2))
        return result


edad = input("Introduce la edad del perro: ")

print calcular_edad(edad)

