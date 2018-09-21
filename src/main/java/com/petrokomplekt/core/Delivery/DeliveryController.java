package com.petrokomplekt.core.Delivery;

import com.petrokomplekt.core.Delivery.model.DeliveryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/api/delivery")
public class DeliveryController {

    private final DeliveryRepository deliveryRepository;

    @Value("${my.apikey}")
    private String apiKey;

    @Autowired
    public DeliveryController(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @GetMapping(path="/add")
    public @ResponseBody
    DeliveryModel addDelivery (@RequestParam(value = "creatorName") String creatorName,
                               @RequestParam(value = "editorName") String editorName,
                               @RequestParam(value = "clientName") String clientName,
                               @RequestParam(value = "clientAddress") String clientAddress,
                               @RequestParam(value = "clientContacts") String clientContacts,
                               @RequestParam(value = "comments") String comments,
                               @RequestParam(value = "driver") String driver,
                               @RequestParam(value = "numberOfRequests") String numberOfRequests,
                               @RequestParam(value = "deliveryDate") String deliveryDate,
                               @RequestParam(value = "deliveryWeight") String deliveryWeight,
                               @RequestParam("key") String key) {

        if (key != null && key.equals(apiKey)) {

            DeliveryModel deliveryModel = new DeliveryModel();
            deliveryModel.setCreatorName(creatorName);
            deliveryModel.setEditorName(editorName);
            deliveryModel.setClientName(clientName);
            deliveryModel.setClientAddress(clientAddress);
            deliveryModel.setClientContacts(clientContacts);
            deliveryModel.setComments(comments);
            deliveryModel.setDriver(driver);
            deliveryModel.setNumberOfRequests(numberOfRequests);
            deliveryModel.setDeliveryDate(deliveryDate);
            deliveryModel.setDeliveryWeight(deliveryWeight);
            deliveryRepository.save(deliveryModel);
            return deliveryModel;
        }
        return null;
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<DeliveryModel> getAllDepartments(@RequestParam("key") String key) {
        if (key != null && key.equals(apiKey))
            return deliveryRepository.findAll();
        return null;
    }
}