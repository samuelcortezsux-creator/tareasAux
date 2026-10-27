class Pantalla:

  def __init__(self, tipo: str, ancho: int, alto: int):
    self.tipo = tipo
    self.ancho = ancho
    self.alto = alto

  def mostrar(self):
    print(
        f"  [Pantalla] Tipo: {self.tipo}, Ancho: {self.ancho}, Alto:"
        f" {self.alto}"
    )


class Aplicacion:

  def __init__(self, nombre: str, tamanio: int):
    self.nombre = nombre
    self.tamanio = tamanio

  def mostrar(self):
    print(f"    [App] Nombre: {self.nombre}, Tamaño: {self.tamanio}")


class Laptop:

  def __init__(self, modelo: str, pantalla: Pantalla):
    self.modelo = modelo
    self.pantalla = pantalla
    self.cantApps = 0
    self.apps = []

  def agregar_aplicacion(self, app: Aplicacion) -> bool:
    if len(self.apps) < 50:
      self.apps.append(app)
      self.cantApps = len(self.apps)
      return True
    return False

  def eliminar_todas_apps(self):
    self.apps.clear()
    self.cantApps = 0

  def ordenar_apps(self):
    # Ordenar de forma decreciente por peso (tamaño). Si hay empate, por nombre (ascendente).
    self.apps.sort(key=lambda app: (-app.tamanio, app.nombre))

  def mostrar(self):
    print(f"Laptop Modelo: {self.modelo}, Cantidad de Apps: {self.cantApps}")
    if self.pantalla:
      self.pantalla.mostrar()
    print("Aplicaciones:")
    for app in self.apps:
      app.mostrar()
    print("-" * 50)


def mostrar_laptop_con_mas_apps(laptops):
  if not laptops:
    return
  max_laptop = laptops[0]
  for laptop in laptops[1:]:
    if laptop.cantApps > max_laptop.cantApps:
      max_laptop = laptop
  print(
      f"-> La laptop con más aplicaciones es el modelo: {max_laptop.modelo}"
      f" con {max_laptop.cantApps} aplicaciones."
  )
  max_laptop.mostrar()


def main():
  # a. Instanciar N objetos Laptop en un vector.
  try:
    n = int(input("Ingrese la cantidad de laptops (N): "))
  except ValueError:
    n = 0

  laptops = []

  for i in range(n):
    print(f"Datos para la Laptop {i + 1}")
    modelo = input("Modelo: ")
    tipo_pantalla = input("Tipo de pantalla (ej. LED, IPS): ")
    try:
      ancho = int(input("Ancho de pantalla: "))
      alto = int(input("Alto de pantalla: "))
    except ValueError:
      ancho, alto = 0, 0

    pantalla = Pantalla(tipo_pantalla, ancho, alto)
    laptop = Laptop(modelo, pantalla)

    try:
      num_apps = int(
          input(
              "¿Cuántas aplicaciones desea agregar inicialmente a esta laptop?"
              " (max 50): "
          )
      )
    except ValueError:
      num_apps = 0

    for j in range(num_apps):
      print(f"  App {j + 1}:")
      nombre_app = input("    Nombre: ")
      try:
        tamanio_app = int(input("    Tamaño (peso): "))
      except ValueError:
        tamanio_app = 0
      laptop.agregar_aplicacion(Aplicacion(nombre_app, tamanio_app))

    laptops.append(laptop)

  print("LISTA DE LAPTOPS INICIALES")
  for lap in laptops:
    lap.mostrar()

  # b. Mostrar a la laptop que tenga más aplicaciones (antes de d)
  mostrar_laptop_con_mas_apps(laptops)

  # c. Agregar una aplicación a la laptop de modelo X.
  modelo_x = input("Ingrese el modelo X de la laptop a buscar: ")
  nuevo_nombre = input("Nombre de la nueva aplicación: ")
  try:
    nuevo_tamanio = int(input("Tamaño de la nueva aplicación: "))
  except ValueError:
    nuevo_tamanio = 0

  encontrada_c = False
  for lap in laptops:
    if lap.modelo.strip().lower() == modelo_x.strip().lower():
      agregado = lap.agregar_aplicacion(Aplicacion(nuevo_nombre, nuevo_tamanio))
      if agregado:
        print(f"¡Aplicación agregada exitosamente a la laptop {lap.modelo}!")
      else:
        print(f"La laptop {lap.modelo} ya alcanzó el límite de 50 aplicaciones.")
      encontrada_c = True
      break

  if not encontrada_c:
    print(f"No se encontró ninguna laptop con el modelo {modelo_x}")

  # d. Eliminar todas las aplicaciones de la laptop con pantalla de ancho Y.
  print("\n[d] Eliminar todas las aplicaciones de la laptop con pantalla de ancho Y:")
  try:
    ancho_y = int(input("Ingrese el ancho Y de la pantalla: "))
  except ValueError:
    ancho_y = -1

  encontrada_d = False
  for lap in laptops:
    if lap.pantalla.ancho == ancho_y:
      lap.eliminar_todas_apps()
      print(
          "Se eliminaron todas las aplicaciones de la laptop modelo:"
          f" {lap.modelo}"
      )
      encontrada_d = True

  if not encontrada_d:
    print(f"No se encontró ninguna laptop con pantalla de ancho {ancho_y}")

  # e. Mostrar a la laptop que tiene más aplicaciones (después de d)
  print("\n[e] Laptop con más aplicaciones (DESPUÉS de eliminar):")
  mostrar_laptop_con_mas_apps(laptops)

  # f. Ordenar de forma decreciente (en cuanto al peso, si hay empate por nombre) las aplicaciones de cada laptop.
  print("\n[f] Ordenando las aplicaciones de cada laptop...")
  for lap in laptops:
    lap.ordenar_apps()

  print("LISTA FINAL DE LAPTOPS")
  for lap in laptops:
    lap.mostrar()


if __name__ == "__main__":
  main()