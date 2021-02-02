package lk.ijse.dep.dao;

import javax.persistence.EntityManager;

/**
 * @author : Damika Anupama Nanayakkara <damikaanupama@gmail.com>
 * @since : 01/02/2021
 **/
public interface SuperDAO {
    void setEntityManager(EntityManager em);
}
