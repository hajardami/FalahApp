package com.backFalahApp.BackFalahApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


    @Setter
    @Getter
    @Entity
    @Table(name="auth_token")
    public class AuthToken {

        @Id
        @Column(name = "token")
        private String token;

        public AuthToken() {

        }

        public AuthToken(String token) {
            this.token = token;
        }


    }

