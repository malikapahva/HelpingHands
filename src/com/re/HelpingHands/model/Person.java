package com.re.HelpingHands.model;

public class Person {
    private int id;
    private String name;
    private String phone;
    private String homeAddress;
    private String officeAddress;
    private String designation;
    private String spouse;
    private String spousePhone;
    private String healthInsurance;
    private String autoInsurance;
    private String rentalInsurance;
    private String birthDate;
    private String email;
    private String bloodGroup;

    public Person(String name, String phone, String homeAddress, String officeAddress, String designation, String spouse, String spousePhone, String healthInsurance, String autoInsurance, String rentalInsurance, String birthDate, String email, String bloodGroup) {
        this.name = name;
        this.phone = phone;
        this.homeAddress = homeAddress;
        this.officeAddress = officeAddress;
        this.designation = designation;
        this.spouse = spouse;
        this.spousePhone = spousePhone;
        this.healthInsurance = healthInsurance;
        this.autoInsurance = autoInsurance;
        this.rentalInsurance = rentalInsurance;
        this.birthDate = birthDate;
        this.email = email;
        this.bloodGroup = bloodGroup;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getSpouse() {
        return spouse;
    }

    public void setSpouse(String spouse) {
        this.spouse = spouse;
    }

    public String getSpousePhone() {
        return spousePhone;
    }

    public void setSpousePhone(String spousePhone) {
        this.spousePhone = spousePhone;
    }

    public String getHealthInsurance() {
        return healthInsurance;
    }

    public void setHealthInsurance(String healthInsurance) {
        this.healthInsurance = healthInsurance;
    }

    public String getAutoInsurance() {
        return autoInsurance;
    }

    public void setAutoInsurance(String autoInsurance) {
        this.autoInsurance = autoInsurance;
    }

    public String getRentalInsurance() {
        return rentalInsurance;
    }

    public void setRentalInsurance(String rentalInsurance) {
        this.rentalInsurance = rentalInsurance;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Person(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
