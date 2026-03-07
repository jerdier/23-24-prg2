import java.util.Random;

public class Cajeros {
    public static void main(String[] args) {
        int[] clientesAtendidos = {0, 0, 0, 0};
        int[] objetosAtendidos = {0, 0, 0, 0};
        boolean[] cajerosLibres = {true, true, true, true};
        int clientesEnCola = 0;
        final int minutosEnUnDia = 12 * 60;
        int minutosSinCola = 0;
        int totalObjetos = 0;
        Random aleatorio = new Random();

        // Bucle tiempo
        for (int tiempo = 1; tiempo < minutosEnUnDia; tiempo++) {
            if (tiempo > 100) {
                break;
            }
            
            boolean nuevoCliente = false;

            if (Math.random() * 100 < 40) {
                nuevoCliente = true;
                clientesEnCola++;

                for (int i = 0; i < 4; i++) {
                    if (cajerosLibres[i]) {
                        clientesAtendidos[i]++;
                        cajerosLibres[i] = false;
                        objetosAtendidos[i] = aleatorio.nextInt(11) + 5;
                        totalObjetos += objetosAtendidos[i];
                        clientesEnCola--;
                        break;
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                if (objetosAtendidos[i] > 0) {
                    objetosAtendidos[i]--;
                    if (objetosAtendidos[i] == 0) {
                        cajerosLibres[i] = true;
                    }
                }
            }
            
            if (clientesEnCola == 0) {
                minutosSinCola++;
            }
            
            System.out.println("--------------------------------------------------------------");
            System.out.print("MINUTO " + tiempo);

            if (nuevoCliente) {
                System.out.println(" - Llega 1 persona - En cola: " + clientesEnCola);
                nuevoCliente = false;
            } else {
                System.out.println(" - Llega 0 persona - En cola: " + clientesEnCola);
            }

            for (int i = 0; i < 4; i++) {
                System.out.print(" Caja" + (i + 1) + ":[" + objetosAtendidos[i] + "] ");
            }
            
            System.out.println();

            if (clientesEnCola >= 15) {
            } else {
            }
        }

        for (int i = 0; i < clientesAtendidos.length; i++) {
            System.out.println("Clientes totales que pasaron por la caja " + (i + 1) + ": " + clientesAtendidos[i]);
        }

        int total = 0;

        for (int i = 0; i < clientesAtendidos.length; i++) {
            total += clientesAtendidos[i];
        }

        System.out.println("Personas que han pasado por la tienda: " + total);
        System.out.println("Hoy se han vendido " + totalObjetos + " productos");
        System.out.println("La cola estuvo vacía durante " + minutosSinCola);
    }
}




    

