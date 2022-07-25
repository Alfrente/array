package com.ejemplo;

import java.util.Scanner;

public class ArrayEjemplo {
    public static void main(String[] args) {

        ArrayEjemplo instancia = new ArrayEjemplo();
        int occion, intento = 0;
        do {
            System.out.println("\n*********** MENUEJERCICIOTEMPERATURAS ***********" +
                    "\n           1: Ingresar temperaturas" +
                    "\n  2: Dia con la temperatura mas alta o maxima" +
                    "\n    3: Temperaturas de un dia determinado" +
                    "\n            4: Listar temperaturas" +
                    "\n                  5: Salir\n");
            System.out.print("Ingrese el numero de la opcion: ");
            occion = instancia.getValidarNumero(instancia.teclado.next());
            System.out.println();
            switch (occion) {
                case 1 -> {
                    instancia.setIngresarTemperatura();
                }
                case 2 -> {
                    System.out.println(instancia.getTemperaturaMasAlta());
                }
                case 3 -> {

                    System.out.println(instancia.getTemperaturaPorDia());
                }
                case 4 -> {
                    instancia.getListar();
                }
                case 5 -> {
                    instancia.getSaliendo();
                }

                default -> {
                    System.out.println("\nOpcion no disponible");
                    intento++;
                    if (intento == 3) {
                        occion = 5;
                        System.out.println("Saliendo intente nuevamente");
                    }
                }
            }

        } while (occion != 5);

    }


    private Scanner teclado = new Scanner(System.in);
    private double[][] temperaturas = new double[2][7]; // Primer [] es para las filas y el [] columna/s
    private String[] dias = {"  Lunes  ", "  Martes ", "Miercoles", "  Jueves ", " Viernes ", "  Sabado ", "  Domingo"};
    private int fila = 0, columna = 0;
    private double numero, numMax = 0;

    public String getTemperaturaPorDia() {
        if (fila == 0 && columna == 0) {
            return "\n**** Error, ingrese las temperaturas primero ****\n";
        } else {
            System.out.print("\nIngrese el dia o el nummero del dia: ");
            String dia = teclado.next();
            Integer numDiaDeString = getValidarNumero(dia);

            if (numDiaDeString>0){
                try {
                    return ("\nDia " + dias[numDiaDeString - 1] + "\nTemperatura minima " + temperaturas[0][numDiaDeString-1] + "\nTemperatura maxima " + temperaturas[1][numDiaDeString-1]);
                }catch (Exception e){
                    return "\n**** Error con el dia intente nuevamente **** \n";
                }
            }else {
                int numDia = 0;
                for (int i = 0; i < dias.length; i++) {
                    if (dias[i].equalsIgnoreCase(dia)) {
                        numDia = i;
                    }
                }
                return ("\nDia " + dias[numDia] + "\nTemperatura minima " + temperaturas[0][numDia] + "\nTemperatura maxima " + temperaturas[1][numDia]);
            }
        }
    }

    public void setIngresarTemperatura() {
        //System.out.println("Filas: " + temperaturas.length);
        //System.out.println("Columnas: " + temperaturas[0].length);

        for (int i = 0; i < temperaturas.length; i++) {
            for (int s = 0; s < temperaturas[i].length; s++) { // temperatura[i].length es para calcular el tamana de la columna del array
                if (i == 0) {
                    System.out.println("Ingrese la temperatura minima del dia " + dias[s]);
                } else {
                    System.out.println("Ingrese la temperatura maxima " + dias[s]);
                }

                numero = teclado.nextDouble();
                if (numMax <= numero) {
                    fila = i;
                    columna = s;
                    numMax = numero;
                }
                temperaturas[i][s] = numero;
            }
        }
    }

    public void getListar() {
        // 0 temperatura minima temperatura[0][++]
        // 1 temperatura maxima temperatura[1][++]
        System.out.println();
        boolean satoDeLinea = true;
        if (temperaturas[0][0] > 0) {

            /* // Forma 1 listar
            for (int i = 0; i < temperaturas.length; i++) {
                for (int s = 0; s < temperaturas[i].length; s++) {
                    if (i == 0) {
                        System.out.println("Dia " + dias[s] + "  Temperatura minima " + temperaturas[i][s]);
                    } else {
                        if (satoDeLinea){
                            System.out.println();
                            satoDeLinea=false;
                        }
                        System.out.println("Dia " + dias[s] + "  Temperatura maxima " + temperaturas[i][s]);
                    }
                }
            }
             */

            // Forma 2 listar
            System.out.println("   Dia    Temperatura minima  Temperatura maxima");
            for (int i=0; i<temperaturas[0].length; i++){
                System.out.println(dias[i] + "        " + temperaturas[0][i] + "                 " + temperaturas[1][i]);
            }
        } else {
            System.out.println("\n**** Error, no ha ingresado las temperaturas ****\n");
        }
    }

    public String getTemperaturaMasAlta() {
        if (fila == 0 && columna == 0) {
            return "\n**** Error, ingrese las temperaturas primero ****\n";
        } else {
            return ("\nLa temperatura mas alta fue " + temperaturas[fila][columna] + " °C el dia " + dias[columna] + "\n");
        }
    }

    public void getSaliendo() {
        System.out.println("Saliendo.");
        System.out.println("Saliendo..");
        System.out.println("Saliendo...");
        System.out.println("Saliendo......");
    }

    public Integer getValidarNumero(String s){
        try {
            Integer validar = Integer.parseInt(s);
            return validar;
        }catch (NumberFormatException nfe){
            return 0;
        }
    }

}
