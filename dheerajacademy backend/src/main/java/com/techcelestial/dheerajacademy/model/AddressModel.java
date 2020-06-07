package com.techcelestial.dheerajacademy.model;

import javax.persistence.*;

@Entity
@Table(name = "AddressMaster")
public class AddressModel {
    @Id
    @GeneratedValue
    @Column(name = "address_id")
    private Integer addressId;

    @Column(name = "address")
    private String address;

    @Column(name = "address_status")
    private String status;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
