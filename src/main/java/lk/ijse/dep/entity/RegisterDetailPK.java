package lk.ijse.dep.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author : Damika Anupama Nanayakkara <damikaanupama@gmail.com>
 * @since : 01/02/2021
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class RegisterDetailPK implements Serializable {
    @Column(name = "student_id")
    private int studentId;
    @Column(name = "course_code")
    private String courseCode;
}
