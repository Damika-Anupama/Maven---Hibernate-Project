package lk.ijse.dep.business;

import lk.ijse.dep.business.custom.impl.CourseBOimpl;
import lk.ijse.dep.business.custom.impl.StudentBOimpl;

/**
 * @author : Damika Anupama Nanayakkara <damikaanupama@gmail.com>
 * @since : 01/02/2021
 **/
public class BOFactory {
    private BOFactory(){

    }
    private static BOFactory boFactory;
    public static BOFactory getInstance(){
        return (boFactory==null)?(boFactory = new BOFactory()):boFactory;
    }
    public <T extends SuperBO> T getBO(BOTypes boTypes){
        switch (boTypes){
            case STUDENT:
                return (T) new StudentBOimpl();
            case COURSE:
                return (T) new CourseBOimpl();
            default:
                return null;
        }
    }
}
