package lk.ijse.dep.business;

import javax.persistence.EntityManager;

/**
 * @author : Damika Anupama Nanayakkara <damikaanupama@gmail.com>
 * @since : 01/02/2021
 **/
public interface SuperBO {
    void setEntityManager(EntityManager em);
}
