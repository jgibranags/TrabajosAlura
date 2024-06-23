import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaAPI consulta = new ConsultaAPI();
        GeneradorDeArchivo generadorDeArchivo = new GeneradorDeArchivo();
        System.out.println("Escribe el numero de pelicula que deseas consultar");

        try {
            var numeroDePelicula = Integer.valueOf(lectura.nextLine());
            Pelicula pelicula = consulta.buscaPelicula(numeroDePelicula);
            System.out.println(pelicula);
            generadorDeArchivo.guardarJson(pelicula);
        } catch (NumberFormatException e){
            System.out.println("Numero no encontrado " + e.getMessage());
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando la aplicacion");
        }
    }
}
