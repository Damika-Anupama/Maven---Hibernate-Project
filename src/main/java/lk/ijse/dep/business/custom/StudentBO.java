package lk.ijse.dep.business.custom;

import lk.ijse.dep.business.SuperBO;
import lk.ijse.dep.dto.CourseDTO;

import java.util.List;

/**
 * @author : Damika Anupama Nanayakkara <damikaanupama@gmail.com>
 * @since : 01/02/2021
 **/
public interface StudentBO extends SuperBO {
    public void saveStudent(CourseDTO courseDTO) throws Exception;
    public void updateStudent(CourseDTO courseDTO) throws Exception;
    public void deleteStudent(String courseCode) throws Exception;
    public List<CourseDTO> getAllStudents() throws Exception;
}
