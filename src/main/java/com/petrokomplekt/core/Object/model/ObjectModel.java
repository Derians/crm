package com.petrokomplekt.core.Object.model;

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
@Table(name = "objects")
public class ObjectModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private Long id;

    @JsonProperty("object_name")
    private String objectName;

    @JsonProperty("client_id")
    private Long clientId;

    @JsonProperty("object_email")
    private String objectEmail;

    @JsonProperty("object_mobile")
    private String objectMobile;

    @JsonProperty("object_phone")
    private String objectPhone;

    @JsonProperty("object_contact")
    private String objectContact;

    @JsonProperty("object_address")
    private String objectAddress;

    @JsonProperty("object_gps")
    private String objectGps;

    @JsonProperty("object_persone")
    private String objectPersone;

    @JsonProperty("object_information")
    private String objectInformation;
}