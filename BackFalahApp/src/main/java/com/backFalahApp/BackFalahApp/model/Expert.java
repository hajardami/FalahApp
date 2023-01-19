package com.backFalahApp.BackFalahApp.model;

import com.backFalahApp.BackFalahApp.enumerations.AppUserRole;

import javax.persistence.Entity;
import java.util.List;
@Entity

public class Expert extends  AppUser{

    private String identityDocument;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String description;
    private String phone;

    public Expert(String firstname, String lastname, String email, String password, AppUserRole role, String profession,String personalphoto) {
        super(firstname, lastname, email, password, role, profession, personalphoto);
    }

    public Expert(String firstname, String lastname, String email, String password, AppUserRole role, String profession, String description,String phone) {
        super(firstname, lastname, email, password, role, profession);
        this.description=description;
        this.phone=phone;
    }

    public Expert() {

    }


    public String getIdentityDocument() {
        return identityDocument;
    }

    public void setIdentityDocument(String identityDocument) {
        this.identityDocument = identityDocument;
    }

    public String getExpertCertificate() {
        return expertCertificate;
    }

    public void setExpertCertificate(String expertCertificate) {
        this.expertCertificate = expertCertificate;
    }
   public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    /**
     * path to coaching certificate
     */
    private String expertCertificate ;
    /**
     * path to image of coach
     */
    private Boolean verified = false;
    public Expert(String identityDocument, String expertCertificate, Boolean verified,String description,String phone) {

        this.identityDocument = identityDocument;
        this.expertCertificate = expertCertificate;
        this.verified = verified;
        this.description=description;
        this.phone=phone;
    }

    public Expert(String firstname, String lastname, String email, String password, AppUserRole role, String profession,String personalphoto, String identityDocument, String expertCertificate,Boolean verified,String description,String phone) {
        super(firstname, lastname, email, password, role, profession, personalphoto);
        this.identityDocument = identityDocument;
        this.expertCertificate = expertCertificate;
        this.verified = verified;
        this.description=description;
        this.phone=phone;
    }

}
