/**
 * NOTE: This class is auto generated by the panchtantra code generator program (2.4.15).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.adobe.panchtantra.api;

import com.adobe.panchtantra.model.ModelPackage;
import com.adobe.panchtantra.model.Otts;
import com.adobe.panchtantra.model.Packages;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@javax.annotation.Generated(value = "io.panchtantra.codegen.languages.SpringCodegen", date = "2020-09-24T08:39:55.612Z")

@Api(value = "ott", description = "the ott API")
public interface OttApi {

    @ApiOperation(value = "Get all otts", nickname = "getAllOtts", notes = "Get all otts", response = Otts.class, tags={ "OTT", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = Packages.class)
    })
    @RequestMapping(value = "/ott",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<Otts> getAllOtts();

    @ApiOperation(value = "Find OTT packages by OTTid", nickname = "getAllOttPackages", notes = "Find OTT packages by OTTid", response = Packages.class, tags={ "OTT", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Packages.class),
        @ApiResponse(code = 400, message = "Invalid ID"),
        @ApiResponse(code = 404, message = "Package not found") })
    @RequestMapping(value = "/ott/{ottId}/packages",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Packages> getAllOttPackages(@ApiParam(value = "ID of ott",required=true) @PathVariable("ottId") Long ottId);


    @ApiOperation(value = "Find ott Package by Id", nickname = "getPackageById", notes = "Find ott Package by Id", response = ModelPackage.class, tags={ "OTT", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = ModelPackage.class),
        @ApiResponse(code = 400, message = "Invalid ID"),
        @ApiResponse(code = 404, message = "Package not found") })
    @RequestMapping(value = "/ott/{ottId}/package/{packageId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<ModelPackage> getPackageById(@ApiParam(value = "ID of ott to return",required=true) @PathVariable("ottId") Long ottId,@ApiParam(value = "ID of package to return",required=true) @PathVariable("packageId") Long packageId);

}
