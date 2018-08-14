package com.petrokomplekt.core.Departments;

import com.petrokomplekt.core.Departments.model.DepartmentModel;
import com.petrokomplekt.core.SuccessModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/api/department")
public class DepartmentController {

    private final DepartmentRepository departmentRepository;

    @Value("${my.apikey}")
    private String apiKey;

    @Autowired
    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }


    @GetMapping(path="/add")
    public @ResponseBody
    DepartmentModel addNewDepartment (@RequestParam(value = "departmentName", required=false) String departmentName
            , @RequestParam(value = "departmentEmail", required=false) String departmentEmail
            , @RequestParam(value = "departmentHead", defaultValue = "0") int departmentHead
            , @RequestParam(value = "departmentExternalId", defaultValue = "0") int departmentExternalId
            , @RequestParam("key") String key
            ) {

        if (key != null && key.equals(apiKey)) {

            DepartmentModel departmentModel = new DepartmentModel();
            departmentModel.setDepartmentName(departmentName);
            departmentModel.setDepartmentEmail(departmentEmail);
            departmentModel.setDepartmentHead(departmentHead);
            departmentModel.setDepartmentExternalId(departmentExternalId);
            departmentRepository.save(departmentModel);
            return departmentModel;

        }

        return null;
    }

    @GetMapping("/del/{id}/")
    public @ResponseBody
    SuccessModel delById (@PathVariable Long id, @RequestParam("key") String key) {

        if (key != null && key.equals(apiKey)) {

            SuccessModel successModel = new SuccessModel();

            if (departmentRepository.existsById(id)) {

                departmentRepository.deleteById(id);

                successModel.setSuccess(true);
                successModel.setMessage("Department with id=" + id + " successfully deleted");
                return successModel;

            } else {

                successModel.setSuccess(false);
                successModel.setMessage("Department with id=" + id + " not found");
                return successModel;

            }

        }

        return null;

    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<DepartmentModel> getAllDepartments(@RequestParam("key") String key) {
        if (key != null && key.equals(apiKey)) {

            return departmentRepository.findAll();

        }

        return null;

    }


    @GetMapping("/find/id/{id}/")
    public @ResponseBody
    DepartmentModel getById (@PathVariable Long id, @RequestParam("key") String key) {
        if (key != null && key.equals(apiKey)) {

            return departmentRepository.findById(id).get();

        }

        return null;

    }

    @GetMapping("/find/name/{name}/")
    public @ResponseBody
    DepartmentModel getByDepartmentName (@PathVariable String name, @RequestParam("key") String key) {
        if (key != null && key.equals(apiKey)) {

            return departmentRepository.findByDepartmentName(name);

        }

        return null;

    }

}
