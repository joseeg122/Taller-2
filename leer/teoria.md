# Pregunta de teoría — Tipos de datos primitivos en Java


## Pregunta

¿Qué son los tipos de datos primitivos en Java, cuáles existen, y por qué es importante elegir el tipo correcto al declarar una variable?

## Respuesta

En Java, un **tipo de dato primitivo** es la forma más básica de almacenar información en una variable. A diferencia de los objetos (como `String` o `ArrayList`), los tipos primitivos **no son clases**, no tienen métodos propios, y representan directamente un valor simple: un número, un carácter o un verdadero/falso.

Java tiene **8 tipos primitivos**, divididos en categorías:

### Números enteros
- `byte` — números pequeños (-128 a 127). Ocupa 1 byte de memoria.
- `short` — números medianos (-32,768 a 32,767). Ocupa 2 bytes.
- `int` — el más usado, para números enteros comunes. Ocupa 4 bytes.
- `long` — para números enteros muy grandes. Ocupa 8 bytes. Requiere el sufijo `L` al final del número (ej: `1234567890123L`), porque Java asume por defecto que un número entero literal es `int`, y si es demasiado grande para caber en un `int`, hay que avisarle explícitamente que es `long`.

### Números decimales
- `float` — decimales con menos precisión. Requiere el sufijo `f` (ej: `25.5f`), porque Java asume por defecto que un decimal literal es `double`.
- `double` — decimales con más precisión, el más usado para decimales.

### Otros
- `char` — un solo carácter, entre comillas simples (ej: `'A'`).
- `boolean` — solo puede ser `true` o `false`.

## ¿Por qué importa elegir el tipo correcto?

1. **Uso eficiente de memoria:** cada tipo reserva una cantidad distinta de espacio. Usar `long` para guardar la edad de una persona (que nunca pasará de unos 120) desperdicia memoria innecesariamente comparado con usar `byte`.

2. **Evitar errores de compilación:** Java es un lenguaje **fuertemente tipado**, lo que significa que revisa en tiempo de compilación que el valor que le estás dando a una variable sea compatible con su tipo. Por ejemplo, intentar guardar un número decimal en una variable `int` genera un error, porque `int` no puede representar decimales.

3. **Evitar comportamientos inesperados en tiempo de ejecución:** por ejemplo, dividir dos números `int` en Java hace una **división entera** (descarta los decimales), mientras que dividir dos `double` sí conserva los decimales. Si no eliges el tipo correcto, el resultado de un cálculo puede ser incorrecto sin que el programa marque ningún error.

## Ejemplo de nuestro propio proyecto

En `Variables.java`, usamos varios tipos primitivos según lo que representaba cada dato:

```java
byte edad = 12;                 // numero pequeño, no necesita mas espacio
long numeroCuentaBancaria = 1234567890123L;  // numero muy grande, necesita long
double pi = 3.14159265358979;   // decimal con precision
boolean esEstudiante = true;    // solo puede ser verdadero o falso
```

Elegir el tipo correcto no solo evita errores, también hace que el código sea más claro: con solo ver el tipo de una variable, cualquiera que lea el código entiende qué clase de dato espera guardar.
