package com.petrokomplekt.core.Delivery.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)

@Entity
@Inheritance
@Table(name = "delivery")
public class DeliveryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private Long id;

    @JsonProperty("date_of_creation")
    private String dateOfCreation;

    @JsonProperty("date_of_change")
    private String dateOfChange;

    @JsonProperty("creator_name")
    private String creatorName;

    @JsonProperty("editor_name")
    private String editorName;

    @JsonProperty("client_name")
    private String clientName;

    @JsonProperty("client_address")
    private String clientAddress;

    @JsonProperty("client_contacts")
    private String clientContacts;

    @JsonProperty("comments")
    private String comments;

    @JsonProperty("driver")
    private String driver;

    @JsonProperty("number_of_requests")
    private String numberOfRequests;

    @JsonProperty("delivery_date")
    private String deliveryDate;

    @JsonProperty("delivery_weight")
    private String deliveryWeight;
}