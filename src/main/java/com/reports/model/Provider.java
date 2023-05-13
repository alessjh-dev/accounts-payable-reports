package com.reports.model;

import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;


public class Provider {
    String id;
    String name;
    String phone;
    String email;
    String nit;
    String lineOfBusiness;
    List addresses;
    List accounts;
    Date createdAt;
    Date updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getLineOfBusiness() {
        return lineOfBusiness;
    }

    public void setLineOfBusiness(String lineOfBusiness) {
        this.lineOfBusiness = lineOfBusiness;
    }

    public List getAddresses() {
        return addresses;
    }

    public void setAddresses(List addresses) {
        this.addresses = addresses;
    }

    public List getAccounts() {
        return accounts;
    }

    public void setAccounts(List accounts) {
        this.accounts = accounts;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Provider{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", nit='" + nit + '\'' +
                ", lineOfBusiness='" + lineOfBusiness + '\'' +
                ", addresses=" + addresses +
                ", accounts=" + accounts +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Provider provider = (Provider) o;
        return Objects.equals(id, provider.id) && Objects.equals(name, provider.name) && Objects.equals(phone, provider.phone) && Objects.equals(email, provider.email) && Objects.equals(nit, provider.nit) && Objects.equals(lineOfBusiness, provider.lineOfBusiness) && Objects.equals(addresses, provider.addresses) && Objects.equals(accounts, provider.accounts) && Objects.equals(createdAt, provider.createdAt) && Objects.equals(updatedAt, provider.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phone, email, nit, lineOfBusiness, addresses, accounts, createdAt, updatedAt);
    }
}
