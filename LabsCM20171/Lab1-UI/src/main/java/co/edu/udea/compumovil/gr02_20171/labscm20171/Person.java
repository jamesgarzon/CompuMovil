package co.edu.udea.compumovil.gr02_20171.labscm20171;

import java.util.Date;

/**
 * Created by james on 2/21/17.
 */

public class Person {

    private String name;
    private String lastName;
    private Date birthday;
    private String sex;
    private String scholarityGrade;
    private String phone;
    private String email;
    private String country;
    private String city;
    private String address;

    public Person() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getScholarityGrade() {
        return scholarityGrade;
    }

    public void setScholarityGrade(String scholarityGrade) {
        this.scholarityGrade = scholarityGrade;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
