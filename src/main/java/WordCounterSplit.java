import java.io.*;

public class WordCounterSplit {
    public static void main(String args[]) {

        if (args.length == 0) {
            System.out.println("Falta el nombre del archivo");
            System.exit(1);
        }

        String fileName = args[0];

        FileReader fileReader = null;

        try {
            fileReader = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("El nombre del archivo no se encuentra");
            System.exit(2);
        }

       BufferedReader in = new BufferedReader(fileReader);

        String textLine = null;
        int contadorPalabras = 0;
        int contadorLineas = 0;
        String linea;

        // tiempo al inicio
        long start = System.currentTimeMillis();
        try {
            while ((linea = in.readLine()) !=null){
                String[] palabras = linea.split("\\s+");
                contadorPalabras = contadorPalabras + palabras.length;
                contadorLineas++;
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de entrada");
            System.exit(3);
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // tiempo de procesamiento
        long time = System.currentTimeMillis() - start;

        System.out.printf("El archivo %s tiene %,7d palabras. " , fileName, contadorPalabras);
        System.out.printf(" Numero de lineas: %,6d%n", contadorLineas);
        System.out.printf("Tiempo procesamiento (milisegundos): %d %n" , time);
    }
}
