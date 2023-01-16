package com.backFalahApp.BackFalahApp.model;

import com.backFalahApp.BackFalahApp.enumerations.AppUserRole;

import javax.persistence.Entity;
import java.util.List;
@Entity

public class Expert extends  AppUser{

    private String identityDocument;

    public Expert(String firstname, String lastname, String email, String password, AppUserRole role, String profession,String personalphoto) {
        super(firstname, lastname, email, password, role, profession, personalphoto);
    }

    public Expert(String firstname, String lastname, String email, String password, AppUserRole role, String profession) {
        super(firstname, lastname, email, password, role, profession);
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
    public Expert(String identityDocument, String expertCertificate, Boolean verified) {

        this.identityDocument = identityDocument;
        this.expertCertificate = expertCertificate;
        this.verified = verified;
    }

    public Expert(String firstname, String lastname, String email, String password, AppUserRole role, String profession,String personalphoto, String identityDocument, String expertCertificate,Boolean verified) {
        super(firstname, lastname, email, password, role, profession, personalphoto);
        this.identityDocument = identityDocument;
        this.expertCertificate = expertCertificate;
        this.verified = verified;
    }

}
