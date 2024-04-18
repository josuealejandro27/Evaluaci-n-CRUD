package mx.utng.jaep.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.utng.jaep.model.dao.IProfessorDao;
import mx.utng.jaep.model.entity.Professor;
/*
 * Una clase service, esta basada en el patron de diseño facade.
 * Un unico punto de acceso hacia distintos DAOS (Datas and objects).
 * Dentro de la clase service podemos operar distintas clases DAO.
 */
@Service
public class ProfessorServiceImpl implements IProfessorService{

    //Inyecta una interfaz para utilizar sus metodos
    @Autowired
    private IProfessorDao professorDao;

    @Transactional(readOnly = true)
    @Override
    public List<Professor> list() {
        return professorDao.list();
    }

    @Transactional
    @Override
    public void save(Professor professor) {
        professorDao.save(professor);
    }

    @Transactional(readOnly = true)
    @Override
    public Professor getById(Long id) {
        return professorDao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        professorDao.delete(id);
    }
    
}
