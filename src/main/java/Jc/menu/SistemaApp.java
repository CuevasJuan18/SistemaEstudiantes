package Jc.menu;

import Jc.datos.EstudiantesDAO;
import Jc.dominio.Estudiante;
import java.util.Scanner;

public class SistemaApp {
    public static void main(String[] args) {

        var salir = false;
        var teclado = new Scanner(System.in);

        //Se crea una instancia
        var estudianteDao = new EstudiantesDAO();

        while (!salir){
            try {
                mostrarMenu();
                salir = ejecutarOpciones(teclado, estudianteDao);
            }catch (Exception e){
                System.out.println("Error en el menu");
            }
            System.out.println();
        }
    }
    public static void mostrarMenu(){
        System.out.println("""
                --- Menu ---
                1. Listar
                2. Buscar
                3. Modificar
                4. Agregar
                5. Eliminar
                6. Salir
                """);
    }
    private static boolean ejecutarOpciones(Scanner teclado,
                                            EstudiantesDAO estudiantesDAO ){
        var opcion = Integer.parseInt(teclado.nextLine());
        var salir = false;
        switch (opcion){
            case 1 ->{
                //Listar
                System.out.println("Listando...");
                var estudiantes = estudiantesDAO.list();
                estudiantes.forEach(System.out::println);
            }
            case 2 -> {
                //Buscar
                var idEstudiantes = Integer.parseInt(teclado.nextLine());
                var estudiante = new Estudiante(idEstudiantes);
                var encontrado = estudiantesDAO.findById(estudiante);
                if (encontrado){
                    System.out.println("Alumno encontrado en " + estudiante);
                }else {
                    System.out.println("Alumno no enontrado " + estudiante);
                }
            }
            case 3 ->{
                //Modificar
                System.out.println("Modificar estudiante");
                System.out.println("Id estudiante...");
                var idEstudiante = Integer.parseInt(teclado.nextLine());
                System.out.print("Nombre :");
                var nombre = teclado.nextLine();
                System.out.print("Apellido :");
                var apellido = teclado.nextLine();
                System.out.print("Telefono :");
                var telefono = teclado.nextLine();
                System.out.print("Correo :");
                var correo = teclado.nextLine();

                var estudiante = new Estudiante(idEstudiante, nombre, apellido, telefono, correo );
                var agregado = estudiantesDAO.modify(estudiante);
                if (agregado){
                    System.out.println("Alumno modificado: " + estudiante);
                }else {
                    System.out.println("No fue posible modificar el alumno... " + estudiante);
                }
            }
            case 4 -> {
                //Agregar
                System.out.println("Agregar estudiante...");
                System.out.print("Nombre :");
                var nombre = teclado.nextLine();
                System.out.print("Apellido :");
                var apellido = teclado.nextLine();
                System.out.print("Telefono :");
                var telefono = teclado.nextLine();
                System.out.print("Correo :");
                var correo = teclado.nextLine();

                var estudiante = new Estudiante(nombre, apellido, telefono, correo);
                var agregado = estudiantesDAO.addEstudiante(estudiante);
                if (agregado){
                    System.out.println("Alumno agregado: " + estudiante);
                }else {
                    System.out.println("No fue posible agregar al alumno... " + estudiante);
                }
            }
            case 5 ->{
                    //Borrar
                System.out.println("Borrar un estudiante...");
                System.out.println("Proporcione el id");
                var eliminarEstudiante = Integer.parseInt(teclado.nextLine());
                var estudiante = new Estudiante(eliminarEstudiante);
                var eliminado = estudiantesDAO.delete(estudiante);
                if (eliminado){
                    System.out.println("Alumno borrado: " + estudiante);
                }else {
                    System.out.println("No fue posible borrar al alumno... " + estudiante);
                }
            }
            case 6 ->{
                System.out.println("Saliendo del menu...");
                salir = true;
            }
            default -> System.out.println("Opcion no reconocida");
        }
        return salir;
    }
}
