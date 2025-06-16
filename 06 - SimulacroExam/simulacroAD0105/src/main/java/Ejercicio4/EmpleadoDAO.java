package Ejercicio4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {
    private Connection connection;
    private ResultSet resultSet;

    public List<Empleado> listarEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        try {
            connection = new ConnectionUtils().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("Select * FROM empleados");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Empleado empleado =
                        new Empleado(resultSet.getInt("id"),
                                resultSet.getString("nombre"),
                                resultSet.getDouble("sueldo"));
                empleados.add(empleado);
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return empleados;
    }

    public void agregarEmpleado(Empleado empleado) {
        try {
        connection= new ConnectionUtils().getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO empleados(id, nombre, sueldo) VALUES (?,?,?)");
            preparedStatement.setString(2, empleado.getNombre());
            preparedStatement.setInt(1, empleado.getId());
            preparedStatement.setDouble(3, empleado.getSueldo());
            boolean ok = preparedStatement.execute();
            if (ok) System.out.println("Empleado insertado correctamente");
            else System.out.println("Empleado no se ha podido insertar");
            preparedStatement.close();
            connection.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public boolean loginCorrecto(String correo) {
        try {
            connection = new ConnectionUtils().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("Select * FROM usuarios WHERE usuarios.correo=?");
            preparedStatement.setString(1, correo);
            resultSet = preparedStatement.executeQuery();
            preparedStatement.close();
            connection.close();
            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
