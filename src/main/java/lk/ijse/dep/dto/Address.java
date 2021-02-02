package lk.ijse.dep.dto;

import java.io.Serializable;

/**
 * @author : Damika Anupama Nanayakkara <damikaanupama@gmail.com>
 * @since : 01/02/2021
 **/
public class Address implements Serializable {
    private String no;
    private String addressLane1;
    private String addressLane2;
    private String city;


    public Address() {
    }

    public Address(String no, String addressLane1, String addressLane2, String city) {
        this.setNo(no);
        this.setAddressLane1(addressLane1);
        this.setAddressLane2(addressLane2);
        this.setCity(city);
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getAddressLane1() {
        return addressLane1;
    }

    public void setAddressLane1(String addressLane1) {
        this.addressLane1 = addressLane1;
    }

    public String getAddressLane2() {
        return addressLane2;
    }

    public void setAddressLane2(String addressLane2) {
        this.addressLane2 = addressLane2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "no='" + no + '\'' +
                ", addressLane1='" + addressLane1 + '\'' +
                ", addressLane2='" + addressLane2 + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
