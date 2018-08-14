package com.petrokomplekt.core.Object;

import com.petrokomplekt.core.Object.model.ObjectModel;
import com.petrokomplekt.core.SuccessModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/api/object")
public class ObjectController {

    private final ObjectRepository objectRepository;

    @Value("${my.apikey}")
    private String apiKey;

    @Autowired
    public ObjectController(ObjectRepository objectRepository) {
        this.objectRepository = objectRepository;
    }

    @GetMapping(path="/add")
    public @ResponseBody
    ObjectModel addNewObject (@RequestParam(value = "objectName") String objectName
            , @RequestParam(value = "clientId", defaultValue = "0") Long clientId
            , @RequestParam(value = "objectEmail", required=false) String objectEmail
            , @RequestParam(value = "objectMobile", required=false) String objectMobile
            , @RequestParam(value = "objectPhone", required=false) String objectPhone
            , @RequestParam(value = "objectContact", required=false) String objectContact
            , @RequestParam(value = "objectAddress", required=false) String objectAddress
            , @RequestParam(value = "objectGps", required=false) String objectGps
            , @RequestParam(value = "objectPersone", required=false) String objectPersone
            , @RequestParam(value = "objectInformation", required=false) String objectInformation
            , @RequestParam("key") String key
    ) {

        if (key != null && key.equals(apiKey)) {

            ObjectModel objectModel = new ObjectModel();
            objectModel.setObjectName(objectName);
            objectModel.setClientId(clientId);
            objectModel.setObjectEmail(objectEmail);
            objectModel.setObjectMobile(objectMobile);
            objectModel.setObjectPhone(objectPhone);
            objectModel.setObjectContact(objectContact);
            objectModel.setObjectAddress(objectAddress);
            objectModel.setObjectGps(objectGps);
            objectModel.setObjectPersone(objectPersone);
            objectModel.setObjectInformation(objectInformation);
            objectRepository.save(objectModel);
            return objectModel;

        }

        return null;
    }

    @GetMapping("/del/{id}/")
    public @ResponseBody
    SuccessModel delById (@PathVariable Long id, @RequestParam("key") String key) {

        if (key != null && key.equals(apiKey)) {

            SuccessModel successModel = new SuccessModel();

            if (objectRepository.existsById(id)) {

                objectRepository.deleteById(id);

                successModel.setSuccess(true);
                successModel.setMessage("Object with id=" + id + " successfully deleted");
                return successModel;

            } else {

                successModel.setSuccess(false);
                successModel.setMessage("Object with id=" + id + " not found");
                return successModel;

            }

        }

        return null;

    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<ObjectModel> getAllDepartments(@RequestParam("key") String key) {
        if (key != null && key.equals(apiKey)) {

            return objectRepository.findAll();

        }

        return null;

    }


    @GetMapping("/find/id/{id}/")
    public @ResponseBody
    ObjectModel getById (@PathVariable Long id, @RequestParam("key") String key) {
        if (key != null && key.equals(apiKey)) {

            return objectRepository.findById(id).get();

        }

        return null;

    }

    @GetMapping("/find/name/{name}/")
    public @ResponseBody
    ObjectModel getByDepartmentName (@PathVariable String name, @RequestParam("key") String key) {
        if (key != null && key.equals(apiKey)) {

            return objectRepository.findByObjectName(name);

        }

        return null;

    }


}
