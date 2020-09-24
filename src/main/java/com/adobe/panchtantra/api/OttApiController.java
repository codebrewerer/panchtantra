package com.adobe.panchtantra.api;

import com.adobe.panchtantra.model.ModelPackage;
import com.adobe.panchtantra.model.Otts;
import com.adobe.panchtantra.model.Packages;
import com.adobe.panchtantra.service.OttsServiceImpl;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

@javax.annotation.Generated(value = "io.panchtantra.codegen.languages.SpringCodegen", date = "2020-09-24T08:39:55.612Z")

@Controller
public class OttApiController implements OttApi {

    private static final Logger log = LoggerFactory.getLogger(OttApiController.class);

    @Autowired
    private OttsServiceImpl ottsServiceImpl;

    public ResponseEntity<Otts> getAllOtts() {
        try {
            Otts otts = ottsServiceImpl.getAllOtts();
            return new ResponseEntity<>(otts, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Exception occurred while fetching otts", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Packages> getAllOttPackages(@ApiParam(value = "ID of ott", required = true) @PathVariable("ottId") Long ottId) {
        try {
            Packages packages = ottsServiceImpl.getPackages(ottId);
            return new ResponseEntity<Packages>(packages, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Exception occurred while fetching packages", e);
            return new ResponseEntity<Packages>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<ModelPackage> getPackageById(@ApiParam(value = "ID of ott to return", required = true) @PathVariable("ottId") Long ottId, @ApiParam(value = "ID of package to return", required = true) @PathVariable("packageId") Long packageId) {
        try {
            ModelPackage modelPackage = ottsServiceImpl.getPackage(ottId, packageId);
            return new ResponseEntity<ModelPackage>(modelPackage, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Exception occurred while fetching package", e);
            return new ResponseEntity<ModelPackage>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
