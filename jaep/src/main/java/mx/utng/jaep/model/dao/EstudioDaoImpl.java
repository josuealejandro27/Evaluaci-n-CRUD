package mx.utng.jaep.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.utng.jaep.model.entity.Estudio;

@Repository
public class EstudioDaoImpl implements IEstudioDao{

    //Coloco un atributo que me permitira gestionar la entidad
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Estudio> list() {
        return em.createQuery("from Estudio").getResultList();
    }

    @Override
    public void save(Estudio estudio) {
        //Si el id es distinto a nulo o mayor que cero, quiere decir que el registro ya existe lo va a modificar
        if(estudio.getId() != null && estudio.getId()>0){
            em.merge(estudio);
        }else{
            //Registro nuevo al usar persist
            em.persist(estudio);
        }
    }

    @Override
    public Estudio getById(Long id) {
        return em.find(Estudio.class, id);
    }

    @Override
    public void delete(Long id) {
      Estudio estudio = getById(id);
      em.remove(estudio);
    }
}