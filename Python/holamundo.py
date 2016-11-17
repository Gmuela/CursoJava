# -*- coding: utf-8 -*-
def calcular_descuento(cantidad, porcentaje_descuento):

    return (cantidad * porcentaje_descuento) / 100.00


def calcular_iva(cantidad, porcentaje_iva):

    return (cantidad * porcentaje_iva) / 100.00


def calcular_total(cantidad, cantidad_iva):

    return cantidad + cantidad_iva


def solicitar_datos():
    global subtotal, descuento, iva
    subtotal = input("Subtotal:")
    descuento = input("% Descuento:")
    iva = input("Tasa de IVA: ")


def calcular_datos():
    global subtotal_con_descuento, iva_del_descuento, total
    subtotal_con_descuento = calcular_descuento(subtotal, descuento)
    iva_del_descuento = calcular_iva(subtotal_con_descuento, iva)
    total = calcular_total(subtotal_con_descuento, iva_del_descuento)


def mostrar_datos():
    print "Subtotal: ", subtotal, "€"
    print "Descuento: ", descuento, "%"
    print "IVA: ", iva, "%"
    print "========================="
    print "Subtotal: ", subtotal, "€"
    print "Descuento: ", subtotal_con_descuento, "€"
    print "IVA: ", iva_del_descuento, "€"
    print "Total: ", total, "€"

solicitar_datos()
calcular_datos()
mostrar_datos()
