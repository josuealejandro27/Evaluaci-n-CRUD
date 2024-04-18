package mx.utng.jaep.model.service;

import java.util.List;

import mx.utng.jaep.model.entity.Estudio;


public interface IEstudioService {
    List<Estudio> list();
    void save(Estudio estudio);
    Estudio getById(Long id);
    void delete(Long id);
}
