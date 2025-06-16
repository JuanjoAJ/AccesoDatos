package Ejercicio4;

import java.rmi.server.UID;
import java.util.List;
import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        EmpleadoDAO empleadoDAO=new EmpleadoDAO();
        boolean loop=true;
        int action;
        System.out.println("Introduce tu correo");
        String correo= sc.nextLine();
        if(empleadoDAO.loginCorrecto(correo))
        {
        do{
            System.out.println("""
                    Bienvenido, tienes las siguientes opciones:
                    1 - Listar empleados
                    2 - Agregar empleado
                    3 - Salir
                    Introduzca numero""");
            action= sc.nextInt();
            switch (action)
            {
                case 1:
                  List<Empleado> empleadoList=  empleadoDAO.listarEmpleados();
                    for (Empleado empleado:empleadoList) {
                        System.out.println(empleado);
                    }
                    break;
                case 2:
                    System.out.println("Introduce id");
                    int id= sc.nextInt();
                    System.out.println("Introduce nombre");
                    String nombre=sc.nextLine();
                    System.out.println("Introduce sueldo");
                    double sueldo= sc.nextDouble();

                    empleadoDAO.agregarEmpleado(new Empleado(id,nombre, sueldo));
                    break;
                default:
                    loop=false;
                    break;
            }


        }while (loop);
        }
    }
}
