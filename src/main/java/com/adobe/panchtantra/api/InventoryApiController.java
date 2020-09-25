package com.adobe.panchtantra.api;

import com.adobe.panchtantra.model.BookingModel;
import com.adobe.panchtantra.model.Inventories;
import com.adobe.panchtantra.model.InventoryModel;
import com.adobe.panchtantra.service.PanchtantraServiceImpl;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@javax.annotation.Generated(value = "io.panchtantra.codegen.languages.SpringCodegen", date = "2020-09-24T08:39:55.612Z")

@Controller
public class InventoryApiController implements InventoryApi {

    private static final Logger log = LoggerFactory.getLogger(InventoryApiController.class);

    @Autowired
    private PanchtantraServiceImpl panchtantraServiceImpl;
    

    public ResponseEntity<Void> saveBooking(@ApiParam(value = "BookingModel Object."  )  @Valid @RequestBody BookingModel booking) {
        try {
            panchtantraServiceImpl.saveUpdateBooking(booking);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            log.error("Exception occurred while saving booking ", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    public ResponseEntity<Void> saveInventory(@ApiParam(value = "InventoryEntity Object."  )  @Valid @RequestBody InventoryModel inventory) {
        try {
            panchtantraServiceImpl.saveUpdateInventory(inventory);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            log.error("Exception occurred while saving inventory ", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Inventories> getInventories(@RequestParam(value = "packageId",required = true) String packageId,@RequestParam(value = "startDate",required = true) String startDate, @RequestParam(value = "endDate",required = true) String endDate) {
        try {
            Inventories inventories = panchtantraServiceImpl.getInventoriesByPackage(packageId, startDate, endDate);
            return new ResponseEntity<>(inventories, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Exception occurred while fetching inventories", e);
            return new ResponseEntity<Inventories>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
