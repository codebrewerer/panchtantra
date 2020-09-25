package com.adobe.panchtantra.api;

import com.adobe.panchtantra.exception.BookingNotFoundException;
import com.adobe.panchtantra.exception.InventoryNotFoundException;
import com.adobe.panchtantra.model.Bookings;
import com.adobe.panchtantra.model.Inventories;
import com.adobe.panchtantra.model.Otts;
import com.adobe.panchtantra.service.PanchtantraServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@javax.annotation.Generated(value = "io.panchtantra.codegen.languages.SpringCodegen", date = "2020-09-24T08:39:55.612Z")

@Controller
public class UserApiController implements UserApi {

    private static final Logger log = LoggerFactory.getLogger(UserApiController.class);

    @Autowired
    private PanchtantraServiceImpl panchtantraServiceImpl;
    
    public ResponseEntity<Bookings> getBookingsByUserId(@ApiParam(value = "userId",required=true) @PathVariable("userId") Long userId) {
        try {
            Bookings bookings = panchtantraServiceImpl.getBookingByUser(userId);
            return new ResponseEntity<>(bookings, HttpStatus.OK);
        } catch(BookingNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            log.error("Exception while getting booking for the user", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Inventories> getInventoriesByUserId(@ApiParam(value = "userId",required=true) @PathVariable("userId") Long userId) {
        try {
            Inventories inventories = panchtantraServiceImpl.getInventoriesByUser(userId);
            return new ResponseEntity<>(inventories, HttpStatus.OK);
        } catch(InventoryNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            log.error("Exception while getting inventories for the user", e);
            return new ResponseEntity<Inventories>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
