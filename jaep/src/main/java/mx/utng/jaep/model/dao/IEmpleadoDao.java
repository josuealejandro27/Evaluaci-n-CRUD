package mx.utng.jaep.model.dao;

import java.util.List;

import mx.utng.jaep.model.entity.Empleado;


public interface IEmpleadoDao {
    //Estos metodos son abstractos no tienen cuerpo
    
    //Listar estudiantes
    List<Empleado> list();

    //Guardar un estudiante
    void save(Empleado empleado);

    //Obterner un estudiante en especifico a partir del id
    Empleado getById(Long id);

    //Eliminar un estudiante por el id
    void delete(Long id);
}
