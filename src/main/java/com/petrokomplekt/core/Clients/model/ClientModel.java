package com.petrokomplekt.core.Clients.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)

@Entity
@Inheritance
@Table(name = "clients")
public class ClientModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private Long id;

    @JsonProperty("client_name")
    private String clientName;

    @JsonProperty("manager_id")
    private Long managerId;

    @JsonProperty("client_information")
    private String clientInformation;

    @JsonProperty("client_manager")
    private String clientManager;

    @JsonProperty("client_email")
    private String clientEmail;

    @JsonProperty("client_mobile")
    private String clientMobile;

    @JsonProperty("client_phone")
    private String clientPhone;

    @JsonProperty("client_address")
    private String clientAddress;

}
