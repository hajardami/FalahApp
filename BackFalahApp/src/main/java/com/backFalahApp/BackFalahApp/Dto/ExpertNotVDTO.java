package com.backFalahApp.BackFalahApp.Dto;

import lombok.Data;

@Data
public class ExpertNotVDTO{
        long id_coach;
        String nom_coach;
        String certificate;
        String cin;
        String image;

        public ExpertNotVDTO(Long id, String s, String expertCertificate, String identityDocument, String personalphoto) {
                this.id_coach=id;
                this.nom_coach=s;
                this.certificate=expertCertificate;
                this.cin=identityDocument;
                this.image=personalphoto;
        }
}
