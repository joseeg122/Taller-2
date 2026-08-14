# Taller 2 - Variables y Condicionales

Proyecto desarrollado en Java que trabaja el manejo de variables de distintos tipos de datos primitivos, su inicialización, reasignación de valores, y la construcción de un programa con menú interactivo que utiliza estructuras condicionales y lectura de datos por consola con `Scanner` para resolver ecuaciones matemáticas.

## Características

- Declaración de 20 variables de diferentes tipos de datos primitivos en Java.
- Inicialización de variables con datos compatibles según su tipo.
- Reasignación de valores: algunas variables toman el valor de otras variables ya existentes, y otras se reasignan con datos nuevos escritos directamente en el código (hardcoded).
- Uso de literales especiales `f` (float), `L` (long) y comillas simples `''` (char).
- Programa de menú interactivo con 3 opciones que permite al usuario resolver una de dos ecuaciones ingresando los valores de `x` y `z`.
- Uso de estructuras condicionales (`if`, `else if`, `switch`) para controlar el flujo del programa.
- Lectura de datos ingresados por el usuario mediante la clase `Scanner`.

## Ejemplo de ejecución

![Ejemplo](evidencias/Funcionando_1.png)

### Consola - Programa de variables

```text
Edad: 20
Cantidad de hermanos: 12
Anio de nacimiento: 2024
...
```
### Consola - Programa de ecuaciones

```text
Seleccione una opción:
1. Solución ecuación 1
2. Solución ecuación 2
3. Salir
Opción: 1
Ingrese el valor de x: 5
Ingrese el valor de z: 3
Resultado: ...
```

---
## Tecnologías utilizadas

- Java
- Scanner (`java.util.Scanner`)
- Git y GitHub para control de versiones

---
## Requisitos

- Java JDK 8 o superior.
- Un IDE como:
  - Visual Studio Code con extensión para Java
  ## Ejecución

### 1. Compilar el programa de variables

```bash
javac Variables.java
```