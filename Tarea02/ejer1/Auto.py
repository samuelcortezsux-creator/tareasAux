class Auto:
    def __init__(self, marca="Generico", gasolina=0, color="Blanco"):
        self.marca = marca
        self.gasolina = gasolina
        self.color = color

    def __pos__(self):
        self.gasolina += 5
        return self

    def __add__(self, nuevo_color):
        if isinstance(nuevo_color, str):
            self.color = nuevo_color
            return self
        return NotImplemented

    def __sub__(self, otro_auto):
        if isinstance(otro_auto, Auto):
            return self.gasolina + otro_auto.gasolina
        return NotImplemented

    def __str__(self):
        return f"Auto {self.marca} | Color: {self.color} | Gasolina: {self.gasolina}L"


auto1 = Auto()  
auto2 = Auto("Toyota", 20, "Rojo")  

print("--- Estado Inicial ---")
print("Auto 1:", auto1)
print("Auto 2:", auto2)

+auto1
print("\n--- Después de +auto1 (incremento de gasolina) ---")
print("Auto 1:", auto1)

auto1 = auto1 + "Azul"
print("\n--- Después de auto1 + 'Azul' ---")
print("Auto 1:", auto1)

gasolina_total = auto1 - auto2
print(f"\nGasolina total entre los 2 autos (usando operador -): {gasolina_total} litros")