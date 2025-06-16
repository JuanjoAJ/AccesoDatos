import database.DBConnection;

import repositories.AlumnoRepository;
import model.*;
import java.sql.Connection;
import java.sql.SQLException;

public class Entrada {
    public static void main(String[] args) {

        AlumnoRepository alumnoRepository =new AlumnoRepository();
        alumnoRepository.insertarAlumno(new Alumno("Angus", "Young", "correo", 1234));



    }
}
