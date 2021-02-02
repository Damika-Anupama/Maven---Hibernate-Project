package lk.ijse.dep.business.util;


import lk.ijse.dep.dto.CourseDTO;
import lk.ijse.dep.dto.StudentDTO;
import lk.ijse.dep.entity.Course;
import lk.ijse.dep.entity.Student;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author : Damika Anupama Nanayakkara <damikaanupama@gmail.com>
 * @since : 01/02/2021
 **/
public interface EntityDTOMapper {

    EntityDTOMapper instance = Mappers.getMapper(EntityDTOMapper.class);

    Student getStudent(StudentDTO studentDTO);
    StudentDTO getStudentDTO(Student student);
    List<StudentDTO> getStudents(List<Student> students);

    Course getCourse(CourseDTO courseDTO);
    CourseDTO getCourseDTO(Course course);
    List<CourseDTO> getCourses(List<Course> courses);


}
