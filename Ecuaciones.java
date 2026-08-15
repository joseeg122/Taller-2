import java.util.Scanner;
import java.util.Locale;
 
public class Ecuaciones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Forzamos que los decimales se escriban con PUNTO (ej: -0.5)
        // y no con coma, sin importar la configuracion regional del computador.
        sc.useLocale(Locale.US);
        int opcion;
 
        // Bucle principal: se repite hasta que el usuario elija salir (opcion 3)
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Solucion ecuacion 1");
            System.out.println("2. Solucion ecuacion 2");
            System.out.println("3. Salir");
            System.out.print("Elija una opcion: ");

            // Validamos que lo que se escribio sea realmente un numero entero.
            // Si no lo es (por ejemplo texto o una fraccion como "-1/3"),
            // descartamos esa entrada y volvemos a pedirla, en vez de dejar
            // que el programa se caiga con una excepcion.
            while (!sc.hasNextInt()) {
                System.out.println("Error: debe ingresar un numero entero (1, 2 o 3).");
                sc.next(); // descarta lo que se escribio mal
                System.out.print("Elija una opcion: ");
            }
            opcion = sc.nextInt();
 
            if (opcion == 1) {
                resolverEcuacion1(sc);
            } else if (opcion == 2) {
                resolverEcuacion2(sc);
            } else if (opcion == 3) {
                System.out.println("Saliendo del programa...");
            } else {
                System.out.println("Opcion invalida, intente de nuevo.");
            }
 
        } while (opcion != 3);
 
        sc.close();
    }
 
    // ===================================================
    // ECUACION 1:
    // y = ( (3x / (1+3x)) / (3z^2 + 2) ) / ( 1 / ( 1/(1+z) + 3x^2+2z+3 ) )
    // ===================================================
    public static void resolverEcuacion1(Scanner sc) {
        System.out.print("Ingrese el valor de x: ");
        double x = sc.nextDouble();
        System.out.print("Ingrese el valor de z: ");
        double z = sc.nextDouble();
 
        // Validaciones basicas: si x o z causan division entre cero,
        // avisamos y no seguimos con el calculo.
        if (1 + 3 * x == 0) {
            System.out.println("Error: x no puede ser -1/3 (division entre cero).");
            return;
        }
        if (1 + z == 0) {
            System.out.println("Error: z no puede ser -1 (division entre cero).");
            return;
        }
 
        // Nota: (3z^2 + 2) nunca puede ser 0 con numeros reales,
        // porque 3z^2 siempre es >= 0, asi que 3z^2+2 siempre es >= 2.
        // Por eso esa parte no necesita validacion.
 
        // Paso 1: parte de arriba -> 3x / (1+3x)
        double paso1 = (3 * x) / (1 + 3 * x);
 
        // Paso 2: paso1 dividido entre (3z^2 + 2)
        double paso2 = paso1 / (3 * z * z + 2);
 
        // Paso 3: la parte de abajo -> 1/(1+z) + 3x^2 + 2z + 3
        double paso3 = (1.0 / (1 + z)) + (3 * x * x) + (2 * z) + 3;
 
        // Paso 4: como la ultima fraccion es "1 / paso3", dividir por ella
        // equivale a MULTIPLICAR por paso3
        double y = paso2 * paso3;
 
        System.out.println("Resultado de la ecuacion 1: y = " + y);
    }
 
    // ===================================================
    // ECUACION 2 (interpretacion segun la foto a mano):
    // y = (x^2+3z+2) / (2 + 1/(1+2z))
    //     + [ 2/(1+3x^3+3z+2) ] * [ 1/(1+3x) + (3x+1)/(2z + 3/(1+5/z)) ]
    //
    // NOTA: por favor compara esta interpretacion con tu foto original,
    // en especial el termino "3x^3" y el ultimo denominador anidado.
    // ===================================================
    public static void resolverEcuacion2(Scanner sc) {
        System.out.print("Ingrese el valor de x: ");
        double x = sc.nextDouble();
        System.out.print("Ingrese el valor de z: ");
        double z = sc.nextDouble();
 
        // Validaciones basicas: revisamos los denominadores mas directos
        // de la formula. Si alguno da 0, avisamos y no calculamos nada.
        boolean valoresValidos = true;
 
        if (z == 0) {
            System.out.println("Error: z no puede ser 0 (aparece como 5/z).");
            valoresValidos = false;
        }
        if (1 + 2 * z == 0) {
            System.out.println("Error: z no puede ser -0.5 (aparece en 1+2z).");
            valoresValidos = false;
        }
        if (1 + 3 * x == 0) {
            System.out.println("Error: x no puede ser -1/3 (aparece en 1+3x).");
            valoresValidos = false;
        }
 
        // Si algun valor no es valido, no seguimos con el calculo
        if (!valoresValidos) {
            return;
        }
 
        // ---- Primer termino: (x^2+3z+2) / (2 + 1/(1+2z)) ----
        double numTermino1 = (x * x) + (3 * z) + 2;
        double denomTermino1 = 2 + (1.0 / (1 + 2 * z));
        double termino1 = numTermino1 / denomTermino1;
 
        // ---- Segundo termino, parte A: 2 / (1+3x^3+3z+2) ----
        double parteA = 2 / (1 + 3 * Math.pow(x, 3) + 3 * z + 2);
 
        // ---- Segundo termino, parte B: 1/(1+3x) + (3x+1)/(2z + 3/(1+5/z)) ----
        double subDenom = 2 * z + (3 / (1 + 5 / z));
        double parteB = (1.0 / (1 + 3 * x)) + ((3 * x + 1) / subDenom);
 
        // ---- Segundo termino completo = parteA * parteB ----
        double termino2 = parteA * parteB;
 
        // ---- Resultado final ----
        double y = termino1 + termino2;
 
        System.out.println("Resultado de la ecuacion 2: y = " + y);
    }
}