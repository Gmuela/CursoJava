# -*- coding: utf-8 -*-


class Dog():

    __name = ''

    def __init__(self, name):
        self.name = name

    def bark(self):
        print "{}, miau... yo quería ser gato".format(self.name)

    @property
    def name(self):
        return self.name

    @name.setter
    def name(self, name):
        self.name = name


nombre = "Yo soy tu pápa"
perro1 = Dog(nombre)
perro1.bark()
