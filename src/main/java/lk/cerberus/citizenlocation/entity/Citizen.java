package lk.cerberus.citizenlocation.entity;

import javax.persistence.*;

@Entity
@Table(name = "citizen")
public class Citizen {

    @Id
    @Column(length = 10, unique = true, updatable = false, nullable = false)
    private String NIC;

    @Column(name = "name")
    private String c_name;

    @Column(name = "age")
    private int age;

    @Column(name = "address")
    private String address;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "profession")
    private String profession;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "health_status")
    private String health_status;

    public Citizen() {
    }

    public Citizen(String NIC, String c_name, int age, String address, double longitude, double latitude, String profession, String email, String password, String health_status) {
        this.NIC = NIC;
        this.c_name = c_name;
        this.age = age;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
        this.profession = profession;
        this.email = email;
        this.password = password;
        this.health_status = health_status;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHealth_status() {
        return health_status;
    }

    public void setHealth_status(String health_status) {
        this.health_status = health_status;
    }
}

