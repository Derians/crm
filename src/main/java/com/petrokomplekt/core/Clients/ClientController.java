package com.petrokomplekt.core.Clients;

import com.petrokomplekt.core.Clients.model.ClientModel;
import com.petrokomplekt.core.SuccessModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/api/client")
public class ClientController {

    private final ClientRepository clientRepository;

    @Value("${my.apikey}")
    private String apiKey;

    @Autowired
    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping(path = "/add")
    public @ResponseBody
    ClientModel addNewClient(@RequestParam(value = "clientName") String clientName,
                             @RequestParam(value = "managerId") Long managerId,
                             @RequestParam(value = "clientInformation", required = false) String clientInformation,
                             @RequestParam(value = "clientManager", required = false) String clientManager,
                             @RequestParam(value = "clientEmail", required = false) String clientEmail,
                             @RequestParam(value = "clientMobile", required = false) String clientMobile,
                             @RequestParam(value = "clientPhone", required = false) String clientPhone,
                             @RequestParam(value = "clientAddress", required = false) String clientAddress,
                             @RequestParam("key") String key) {

        if (key != null && key.equals(apiKey)) {

            ClientModel clientModel = new ClientModel();
            clientModel.setClientName(clientName);
            clientModel.setManagerId(managerId);
            clientModel.setClientInformation(clientInformation);
            clientModel.setClientManager(clientManager);
            clientModel.setClientEmail(clientEmail);
            clientModel.setClientMobile(clientMobile);
            clientModel.setClientPhone(clientPhone);
            clientModel.setClientAddress(clientAddress);
            clientRepository.save(clientModel);
            return clientModel;
        }
        return null;
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<ClientModel> getAllClients(@RequestParam("key") String key) {
        if (key != null && key.equals(apiKey))
            return clientRepository.findAll();
        return null;
    }

    @GetMapping("/del/{id}/")
    public @ResponseBody
    SuccessModel delById(@PathVariable Long id, @RequestParam("key") String key) {

        if (key != null && key.equals(apiKey)) {

            SuccessModel successModel = new SuccessModel();

            if (clientRepository.existsById(id)) {

                clientRepository.deleteById(id);

                successModel.setSuccess(true);
                successModel.setMessage("ClientModel with id=" + id + " successfully deleted");
                return successModel;

            } else {

                successModel.setSuccess(false);
                successModel.setMessage("ClientModel with id=" + id + " not found");
                return successModel;
            }
        }
        return null;
    }

    @GetMapping("/find/id/{id}/")
    public @ResponseBody
    ClientModel getById(@PathVariable Long id, @RequestParam("key") String key) {
        if (key != null && key.equals(apiKey))
            return clientRepository.findById(id).get();
        return null;
    }

    @GetMapping("/find/name/{name}/")
    public @ResponseBody
    ClientModel getByClientName(@PathVariable String name, @RequestParam("key") String key) {
        if (key != null && key.equals(apiKey))
            return clientRepository.findByClientName(name);
        return null;
    }
}