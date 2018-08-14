package com.petrokomplekt.core.Users.madel;

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
@Table(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private Long id;

    @JsonProperty("user_first_name")
    private String userFirstName;

    @JsonProperty("user_last_name")
    private String userLastName;

    @JsonProperty("user_middle_name")
    private String userMiddleName;

    @JsonProperty("user_birthday")
    private Date userBirthday;

    @JsonProperty("user_gender")
    private String userGender;

    @JsonProperty("user_position")
    private String userPosition;

    @JsonProperty("user_mobile_phone")
    private String userMobilePhone;

    @JsonProperty("user_work_phone")
    private String userWorkPhone;

    @JsonProperty("user_email")
    private String userEmail;

    @JsonProperty("user_personal_email")
    private String userPersonalEmail;

    @JsonProperty("user_extension")
    private int userExtension;

    @JsonProperty("user_smb_folder")
    private String userSmbFolder;

    @JsonProperty("user_pc_name")
    private String userPcName;

    @JsonProperty("user_ip_address")
    private String userIpAddress;

    @JsonProperty("user_password")
    private String userPassword;

    @JsonProperty("user_pincode")
    private String userPincode;

    @JsonProperty("user_level")
    private int userLevel;

    @JsonProperty("user_department")
    private int userDepartment;

    @JsonProperty("user_external_id")
    private long userExternalId;


}