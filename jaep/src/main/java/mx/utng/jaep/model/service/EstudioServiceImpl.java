package mx.utng.jaep.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.utng.jaep.model.dao.IEstudioDao;
import mx.utng.jaep.model.entity.Estudio;
/*
 * Una clase service, esta basada en el patron de diseño facade.
 * Un unico punto de acceso hacia distintos DAOS (Datas and objects).
 * Dentro de la clase service podemos operar distintas clases DAO.
 */
@Service
public class EstudioServiceImpl implements IEstudioService{

    //Inyecta una interfaz para utilizar sus metodos
    @Autowired
    private IEstudioDao estudioDao;

    @Transactional(readOnly = true)
    @Override
    public List<Estudio> list() {
        return estudioDao.list();
    }

    @Transactional
    @Override
    public void save(Estudio estudio) {
        estudioDao.save(estudio);
    }

    @Transactional(readOnly = true)
    @Override
    public Estudio getById(Long id) {
        return estudioDao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        estudioDao.delete(id);
    }
    
}
