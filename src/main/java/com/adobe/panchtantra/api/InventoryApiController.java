package com.adobe.panchtantra.api;

import com.adobe.panchtantra.model.Booking;
import com.adobe.panchtantra.model.Inventory;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;

@javax.annotation.Generated(value = "io.panchtantra.codegen.languages.SpringCodegen", date = "2020-09-24T08:39:55.612Z")

@Controller
public class InventoryApiController implements InventoryApi {

    private static final Logger log = LoggerFactory.getLogger(InventoryApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public InventoryApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> saveBookingsByInventoryId(@ApiParam(value = "inventoryId",required=true) @PathVariable("inventoryId") Long inventoryId,@ApiParam(value = "Booking Object."  )  @Valid @RequestBody Booking booking) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> saveInventory(@ApiParam(value = "Inventory Object."  )  @Valid @RequestBody Inventory inventory) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
