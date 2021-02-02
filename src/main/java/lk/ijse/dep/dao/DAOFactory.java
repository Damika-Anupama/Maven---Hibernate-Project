package lk.ijse.dep.dao;

import lk.ijse.dep.dao.custom.impl.CourseDAOimpl;
import lk.ijse.dep.dao.custom.impl.RegisterDetailDAOimpl;
import lk.ijse.dep.dao.custom.impl.StudentDAOimpl;

/**
 * @author : Damika Anupama Nanayakkara <damikaanupama@gmail.com>
 * @since : 01/02/2021
 **/
public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){}
    public static DAOFactory getInstance(){
        return (daoFactory==null)?(daoFactory = new DAOFactory()):daoFactory;
    }
    public <T extends SuperDAO> T getDAO(DAOTYPES daotypes){
        switch (daotypes){
            case COURSE:
                return (T) new CourseDAOimpl();
            case STUDENT:
                return (T) new StudentDAOimpl();
            case REGISTER_DETAIL:
                return (T) new RegisterDetailDAOimpl();
            default:
                return null;
        }
    }
}
