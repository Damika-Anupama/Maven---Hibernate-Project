package lk.ijse.dep.dao;

import lk.ijse.dep.entity.SuperEntity;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @author : Damika Anupama Nanayakkara <damikaanupama@gmail.com>
 * @since : 01/02/2021
 **/
public abstract class CrudDAOimpl<T extends SuperEntity,PK extends Serializable> implements CrudDAO<T,PK>{

    private EntityManager em;
    private Class<T> entityClassObject;

    public CrudDAOimpl() {
        entityClassObject = (Class<T>) ((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0];
    }

    @Override
    public void setEntityManager(EntityManager em) {
            this.em = em;
    }

    protected EntityManager getEntityManager(){
        return em;
    }
    @Override
    public void save(SuperEntity entity) throws Exception {
        em.persist(entity);
    }

    @Override
    public void update(SuperEntity entity) throws Exception {
        em.merge(entity);
    }

    @Override
    public void delete(Serializable key) throws Exception {
        em.remove(em.getReference(entityClassObject,key));
    }

    @Override
    public SuperEntity get(Serializable key) throws Exception {
        return em.find(entityClassObject,key);
    }

    @Override
    public List getAll() throws Exception {
        return em.createQuery("SELECT e FROM "+entityClassObject.getName()+" e").getResultList();
    }
}
