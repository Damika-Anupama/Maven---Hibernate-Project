package lk.ijse.dep.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author : Damika Anupama Nanayakkara <damikaanupama@gmail.com>
 * @since : 01/02/2021
 **/
@Embeddable
public class Address {
    private String no;
    @Column(name = "address_name_1")
    private String addressLane1;
    @Column(name = "address_name_2")
    private String addressLane2;
    private String city;

}
