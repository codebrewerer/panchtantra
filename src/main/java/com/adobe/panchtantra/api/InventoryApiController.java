package com.adobe.panchtantra.api;

import com.adobe.panchtantra.model.Booking;
import com.adobe.panchtantra.model.Inventories;
import com.adobe.panchtantra.model.Inventory;
import com.adobe.panchtantra.model.ModelPackage;
import com.adobe.panchtantra.service.OttsServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import javax.servlet.http.HttpServletRequest;

@javax.annotation.Generated(value = "io.panchtantra.codegen.languages.SpringCodegen", date = "2020-09-24T08:39:55.612Z")

@Controller
public class InventoryApiController implements InventoryApi {

    private static final Logger log = LoggerFactory.getLogger(InventoryApiController.class);

    @Autowired
    private OttsServiceImpl ottsServiceImpl;
    

    public ResponseEntity<Void> saveBookingsByInventoryId(@ApiParam(value = "inventoryId",required=true) @PathVariable("inventoryId") Long inventoryId,@ApiParam(value = "Booking Object."  )  @Valid @RequestBody Booking booking) {
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> saveInventory(@ApiParam(value = "Inventory Object."  )  @Valid @RequestBody Inventory inventory) {
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Inventories> getInventories(@RequestParam(value = "packageId",required = true) String packageId,@RequestParam(value = "startDate",required = true) String startDate, @RequestParam(value = "endDate",required = true) String endDate) {
        try {
            Inventories inventories = ottsServiceImpl.getInventories(packageId, startDate, endDate);
            return new ResponseEntity<>(inventories, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Exception occurred while fetching package", e);
            return new ResponseEntity<Inventories>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
