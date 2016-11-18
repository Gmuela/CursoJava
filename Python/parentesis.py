# -*- coding: utf-8 -*-

import string

parentesis = {"(": ")", "[": "]", "{": "}"}


def check_string_parenthesis(cadena, par_abre, par_cierra):
    count_1 = 0
    count_2 = 0
    for parentesis in cadena:
        if parentesis in string.punctuation:
            if parentesis is par_abre:
                count_1 += 1
            if parentesis is par_cierra:
                count_2 += 1
    return count_1 == count_2


def check_string_parenthesis_in_order(cadena, par_abre, par_cierra):
    count_1 = list()
    count_2 = list()
    for parentesis in cadena:
        if parentesis in string.punctuation:
            if parentesis is par_abre:
                count_1.append("(")
            if parentesis is par_cierra:
                count_2.append(")")
    print count_1
    print count_2
    #return check_lists(list_open, list_close)


def check_lists(list_open, list_close):
    position = 0
    for par_abre, par_cierra in parentesis:
        if list_open[position] is par_abre:
            if not list_close[position] is par_cierra:
                return False


def execute_check(cadena):
    error = False
    for key, value in parentesis.items():
        if not check_string_parenthesis_in_order(cadena, key, value):
            print "{} no válido. Error en los siguientes paréntesis {}{}".format(cadena, key, value)
            error = True
            break
    if not error:
        print "Todo correcto"

cadena = raw_input("Escribe:")
execute_check(cadena)
