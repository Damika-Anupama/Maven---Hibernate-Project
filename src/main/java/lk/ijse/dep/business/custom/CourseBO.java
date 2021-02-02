package lk.ijse.dep.business.custom;

import lk.ijse.dep.business.SuperBO;
import lk.ijse.dep.dto.CourseDTO;

import java.util.List;

/**
 * @author : Damika Anupama Nanayakkara <damikaanupama@gmail.com>
 * @since : 01/02/2021
 **/
public interface CourseBO extends SuperBO {
    public void saveCourse(CourseDTO courseDTO) throws Exception;
    public void updateCourse(CourseDTO courseDTO) throws Exception;
    public void deleteCourse(String courseCode) throws Exception;
    public List<CourseDTO> getAllCourses() throws Exception;
}
