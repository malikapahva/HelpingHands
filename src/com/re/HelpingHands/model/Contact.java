package com.re.HelpingHands.model;

public class Contact {
    private String contactType;
    private int id;
    private String image;
    private String name;
    private String relation;
    private String phone;
    private String email;
    private String address;

    public Contact(String contactType, String image, String name, String relation, String phone, String email, String address) {
        this.contactType = contactType;
        this.image = image;
        this.name = name;
        this.relation = relation;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
