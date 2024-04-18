package mx.utng.jaep.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.utng.jaep.model.dao.IEmpleadoDao;
import mx.utng.jaep.model.entity.Empleado;
/*
 * Una clase service, esta basada en el patron de diseño facade.
 * Un unico punto de acceso hacia distintos DAOS (Datas and objects).
 * Dentro de la clase service podemos operar distintas clases DAO.
 */
@Service
public class EmpleadoServiceImpl implements IEmpleadoService{

    //Inyecta una interfaz para utilizar sus metodos
    @Autowired
    private IEmpleadoDao empleadoDao;

    @Transactional(readOnly = true)
    @Override
    public List<Empleado> list() {
        return empleadoDao.list();
    }

    @Transactional
    @Override
    public void save(Empleado empleado) {
        empleadoDao.save(empleado);
    }

    @Transactional(readOnly = true)
    @Override
    public Empleado getById(Long id) {
        return empleadoDao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        empleadoDao.delete(id);
    }
    
}
