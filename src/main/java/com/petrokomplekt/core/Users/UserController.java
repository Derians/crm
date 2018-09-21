package com.petrokomplekt.core.Users;

import com.petrokomplekt.core.SuccessModel;
import com.petrokomplekt.core.Users.madel.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(path="/api/user")
public class UserController {
    private final UserRepository userRepository;

    @Value("${my.apikey}")
    private String apiKey;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(path="/add")
    public @ResponseBody
    UserModel addNewUser (@RequestParam("firstName") String firstName
            , @RequestParam("lastName") String lastName
            , @RequestParam("middleName") String middleName
            , @RequestParam("birthDay") String birthDay
            , @RequestParam("gender") String gender
            , @RequestParam(value = "position", required=false) String position
            , @RequestParam(value = "mobile", required=false) String mobile
            , @RequestParam(value = "phone", required=false) String phone
            , @RequestParam(value = "email", required=false) String email
            , @RequestParam(value = "personalEmail", required=false) String personalEmail
            , @RequestParam(value = "extension", defaultValue = "0") int extension
            , @RequestParam(value = "smbFolder", required=false) String smbFolder
            , @RequestParam(value = "pcName", required=false) String pcName
            , @RequestParam(value = "ipAddress", required=false) String ipAddress
            , @RequestParam(value = "password", required=false) String password
            , @RequestParam(value = "pincode", required=false) String pincode
            , @RequestParam(value = "level", defaultValue = "0") int level
            , @RequestParam(value = "department", defaultValue = "0") int department
            , @RequestParam(value = "externalId", defaultValue = "0") Long externalId
            , @RequestParam("key") String key) {

        if (key != null && key.equals(apiKey)) {

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
            try {
                date = formatter.parse(birthDay);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            UserModel userModel = new UserModel();
            userModel.setUserFirstName(firstName);
            userModel.setUserLastName(lastName);
            userModel.setUserMiddleName(middleName);
            userModel.setUserBirthday(date);
            userModel.setUserGender(gender);
            userModel.setUserPosition(position);
            userModel.setUserMobilePhone(mobile);
            userModel.setUserWorkPhone(phone);
            userModel.setUserEmail(email);
            userModel.setUserPersonalEmail(personalEmail);
            userModel.setUserExtension(extension);
            userModel.setUserSmbFolder(smbFolder);
            userModel.setUserPcName(pcName);
            userModel.setUserIpAddress(ipAddress);
            userModel.setUserPassword(password);
            userModel.setUserPincode(pincode);
            userModel.setUserLevel(level);
            userModel.setUserDepartment(department);
            userModel.setUserExternalId(externalId);
            userRepository.save(userModel);

            return userModel;
        }
        return null;
    }

    @GetMapping(path="/all")
    public @ResponseBody
    Iterable<UserModel> getAllUsers(@RequestParam("key") String key) {
        if (key != null && key.equals(apiKey))
            return userRepository.findAll();
        return null;
    }

    @GetMapping("/del/{id}")
    public @ResponseBody
    SuccessModel delById (@PathVariable Long id, @RequestParam("key") String key) {

        if (key != null && key.equals(apiKey)) {

            SuccessModel successModel = new SuccessModel();

            if (userRepository.existsById(id)) {

                userRepository.deleteById(id);

                successModel.setSuccess(true);
                successModel.setMessage("User with id=" + id + " successfully deleted");
                return successModel;

            } else {

                successModel.setSuccess(false);
                successModel.setMessage("User with id=" + id + " not found");
                return successModel;
            }
        }
        return null;
    }


    @GetMapping("/find/id/{id}")
    public @ResponseBody
    UserModel getById (@PathVariable Long id, @RequestParam("key") String key) {
        if (key != null && key.equals(apiKey))
            if (userRepository.existsById(id))
                return userRepository.findById(id).get();
        return null;
    }

    @GetMapping("/find/personalmail/{email}")
    public @ResponseBody
    UserModel getByUserPersonalEmail (@PathVariable String email, @RequestParam("key") String key) {
        if (key != null && key.equals(apiKey))
            return userRepository.findByUserPersonalEmail(email);
        return null;
    }

    @GetMapping("/find/email/{email}")
    public @ResponseBody
    UserModel getByUserEmail(@PathVariable String email, @RequestParam("key") String key) {
        if (key != null)
            return userRepository.findByUserEmail(email);
        return null;
    }

    @GetMapping("/find/gender/{gender}")
    public @ResponseBody
    List<UserModel> getByUserGender(@PathVariable String gender, @RequestParam("key") String key) {
        if (key != null && key.equals(apiKey))
            return userRepository.findByUserGender(gender);
        return null;
    }

    @GetMapping("/find/firstname/{firstname}")
    public @ResponseBody
    List<UserModel> getByUserFirstName(@PathVariable String firstname, @RequestParam("key") String key) {
        if (key != null && key.equals(apiKey))
            return userRepository.findByUserFirstName(firstname);
        return null;
    }

    @GetMapping("/find/lastname/{lastname}")
    public @ResponseBody
    List<UserModel> getByUserLastName(@PathVariable String lastname, @RequestParam("key") String key) {
        if (key != null && key.equals(apiKey))
            return userRepository.findByUserLastName(lastname);
        return null;
    }

    @GetMapping("/find/position/{position}")
    public @ResponseBody
    List<UserModel> getByUserPosition(@PathVariable String position, @RequestParam("key") String key) {
        if (key != null && key.equals(apiKey))
            return userRepository.findByUserPosition(position);
        return null;
    }

    @GetMapping("/find/pcname/{pcname}")
    public @ResponseBody
    UserModel getByUserPcName(@PathVariable String pcname, @RequestParam("key") String key) {
        if (key != null && key.equals(apiKey))
            return userRepository.findByUserPcName(pcname);
        return null;
    }

    @GetMapping("/find/ip/{ip}")
    public @ResponseBody
    UserModel getByUserIpAddress(@PathVariable String ip, @RequestParam("key") String key) {
        if (key != null && key.equals(apiKey))
            return userRepository.findByUserIpAddress(ip);
        return null;
    }

    @GetMapping("/find/level/{level}")
    public @ResponseBody
    List<UserModel> getByUserLevel(@PathVariable String level, @RequestParam("key") String key) {
        if (key != null && key.equals(apiKey))
            return userRepository.findByUserLevel(level);
        return null;
    }

    @GetMapping("/find/department/{department}")
    public @ResponseBody
    List<UserModel> getByUserDepartment(@PathVariable String department, @RequestParam("key") String key) {
        if (key != null && key.equals(apiKey))
            return userRepository.findByUserDepartment(department);
        return null;
    }

    @GetMapping("/find/externalid/{externalid}")
    public @ResponseBody
    UserModel getByUserExternalId(@PathVariable String externalid, @RequestParam("key") String key) {
        if (key != null && key.equals(apiKey))
            return userRepository.findByUserExternalId(externalid);
        return null;
    }
}
