package com.adobe.panchtantra.api;

import com.adobe.panchtantra.model.ModelPackage;
import com.adobe.panchtantra.model.Packages;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@javax.annotation.Generated(value = "io.panchtantra.codegen.languages.SpringCodegen", date = "2020-09-24T08:39:55.612Z")

@Controller
public class OttApiController implements OttApi {

    private static final Logger log = LoggerFactory.getLogger(OttApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public OttApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Packages> getAllOttPackages(@ApiParam(value = "ID of ott",required=true) @PathVariable("ottId") Long ottId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Packages>(objectMapper.readValue("\"\"", Packages.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Packages>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Packages>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ModelPackage> getPackageById(@ApiParam(value = "ID of ott to return",required=true) @PathVariable("ottId") Long ottId,@ApiParam(value = "ID of package to return",required=true) @PathVariable("packageId") Long packageId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ModelPackage>(objectMapper.readValue("{  \"noOfSeats\" : 6,  \"name\" : \"name\",  \"id\" : 0,  \"basis\" : \"MONTHLY\",  \"pricing\" : 1.4658129805029452,  \"status\" : \"ACTIVE\"}", ModelPackage.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ModelPackage>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ModelPackage>(HttpStatus.NOT_IMPLEMENTED);
    }

}
