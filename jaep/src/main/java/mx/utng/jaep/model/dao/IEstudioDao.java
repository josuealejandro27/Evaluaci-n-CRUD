package mx.utng.jaep.model.dao;

import java.util.List;

import mx.utng.jaep.model.entity.Estudio;


public interface IEstudioDao {
    //Estos metodos son abstractos no tienen cuerpo
    
    //Listar estudiantes
    List<Estudio> list();

    //Guardar un estudiante
    void save(Estudio estudio);

    //Obterner un estudiante en especifico a partir del id
    Estudio getById(Long id);

    //Eliminar un estudiante por el id
    void delete(Long id);
}
