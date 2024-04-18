package mx.utng.jaep.model.service;

import java.util.List;

import mx.utng.jaep.model.entity.Professor;


public interface IProfessorService {
    List<Professor> list();
    void save(Professor professor);
    Professor getById(Long id);
    void delete(Long id);
}
