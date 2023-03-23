package Esctructura;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Manager {

    private List<Integer> numerosPares;
    private List<Integer> numerosImpares;

    public void guardarEnArchivo(String nombreArchivo, List<Integer> datos) {
    	 try (FileWriter writer = new FileWriter(nombreArchivo)) {
	            for (Integer number : datos) {
	                writer.write(number.toString() + "\n");
	            }
	        } catch (IOException e) {
	            System.err.println("Error al guardar el archivo: " + e.getMessage());
	        }
	    }
    
    public void ejecutar() {
        Fibonacci fibonacci = new Fibonacci();
        List<Integer> secuenciaFibonacci = fibonacci.generarSecuencia(); // Esta línea faltaba

        Splitter splitter = new Splitter();
        numerosPares = splitter.obtenerNumerosPares(secuenciaFibonacci);
        numerosImpares = splitter.obtenerNumerosImpares(secuenciaFibonacci);

        guardarEnArchivo("Nupares.txt", numerosPares);
        guardarEnArchivo("Nuimpares.txt", numerosImpares);
    }
    //EXperimentacion para algo extra en el main, para poder imprimir las listas guardadas en los archivos
    public void imprimirArchivo(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}