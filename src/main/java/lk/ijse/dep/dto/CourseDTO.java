package lk.ijse.dep.dto;

import java.io.Serializable;

/**
 * @author : Damika Anupama Nanayakkara <damikaanupama@gmail.com>
 * @since : 01/02/2021
 **/
public class CourseDTO implements Serializable {
    private String code;
    private String description;
    private Audience audience;
    private String courseFee;

    public CourseDTO() {
    }

    public CourseDTO(String code, String description, Audience audience, String courseFee) {
        this.code = code;
        this.description = description;
        this.audience = audience;
        this.courseFee = courseFee;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Audience getAudience() {
        return audience;
    }

    public void setAudience(Audience audience) {
        this.audience = audience;
    }

    public String getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(String courseFee) {
        this.courseFee = courseFee;
    }

    @Override
    public String toString() {
        return "CourseDTO{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", audience=" + audience +
                ", courseFee='" + courseFee + '\'' +
                '}';
    }
}
