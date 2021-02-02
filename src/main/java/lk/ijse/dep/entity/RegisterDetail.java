package lk.ijse.dep.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author : Damika Anupama Nanayakkara <damikaanupama@gmail.com>
 * @since : 01/02/2021
 **/
@Entity
@Table(name = "register_detail")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterDetail implements SuperEntity{
    @EmbeddedId
    private RegisterDetailPK registerDetailPK;
    @Column(name = "registration_date")
    private Date registrationDate;
    @Column(name = "registration_fee")
    private BigDecimal registrationFee;


    @Setter(AccessLevel.NONE)
    @JoinColumn(name = "student_id",referencedColumnName = "id",insertable = false,updatable = false)
    @ManyToOne
    private Student student;
    @Setter(AccessLevel.NONE)
    @JoinColumn(name = "course_code",referencedColumnName = "code",insertable = false,updatable = false)
    @ManyToOne
    private Course course;


    public RegisterDetail(RegisterDetailPK registerDetailPK, Date registrationDate, BigDecimal registrationFee) {
        this.registerDetailPK = registerDetailPK;
        this.registrationDate = registrationDate;
        this.registrationFee = registrationFee;
    }
    public RegisterDetail(int studentId,String courseCode, Date registrationDate, BigDecimal registrationFee) {
        this.registerDetailPK = new RegisterDetailPK(studentId,courseCode);
        this.registrationDate = registrationDate;
        this.registrationFee = registrationFee;
    }
}
