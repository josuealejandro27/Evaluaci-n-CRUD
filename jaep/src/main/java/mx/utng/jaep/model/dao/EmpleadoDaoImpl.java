package mx.utng.jaep.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.utng.jaep.model.entity.Empleado;

@Repository
public class EmpleadoDaoImpl implements IEmpleadoDao{

    //Coloco un atributo que me permitira gestionar la entidad
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Empleado> list() {
        return em.createQuery("from Empleado").getResultList();
    }

    @Override
    public void save(Empleado empleado) {
        //Si el id es distinto a nulo o mayor que cero, quiere decir que el registro ya existe lo va a modificar
        if(empleado.getId() != null && empleado.getId()>0){
            em.merge(empleado);
        }else{
            //Registro nuevo al usar persist
            em.persist(empleado);
        }
    }

    @Override
    public Empleado getById(Long id) {
        return em.find(Empleado.class, id);
    }

    @Override
    public void delete(Long id) {
      Empleado empleado = getById(id);
      em.remove(empleado);
    }
}