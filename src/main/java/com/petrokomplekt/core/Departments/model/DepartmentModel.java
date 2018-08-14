package com.petrokomplekt.core.Departments.model;

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
@Table(name = "departments")
public class DepartmentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private Long id;

    @JsonProperty("department_name")
    private String departmentName;

    @JsonProperty("department_email")
    private String departmentEmail;

    @JsonProperty("department_head")
    private int departmentHead;

    @JsonProperty("department_external_id")
    private int departmentExternalId;

}
