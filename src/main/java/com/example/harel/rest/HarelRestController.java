package com.example.harel.rest;

import com.example.harel.constants.HarelConstants;
import com.example.harel.dto.ErrorResponseDto;
import com.example.harel.dto.ResponseDto;
import com.example.harel.entity.Customers;
import com.example.harel.entity.Policies;
import com.example.harel.service.HarelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(
        name = "APIs for Harel ",
        description = "API for Harel policies and customer"
)
@RestController
@RequestMapping(path = "/api" , produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Validated
public class HarelRestController {

    private HarelService harelService;

    @GetMapping("/policies/{id}")
    public ResponseEntity<Optional<Policies>> getPolicy(@PathVariable @Pattern(regexp = "^[0-9]*$", message = "id must be only digits") String id){
        Optional<Policies> policy = harelService.getPolicy(Integer.parseInt(id));
        return ResponseEntity.status(HttpStatus.OK).body(policy);
    }

    @GetMapping("/getAllCustomers")
    public ResponseEntity<List<Customers>> getAllCoordinates(){
        List<Customers> customersList = harelService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(customersList);
    }
    
    @PostMapping("/policies")
    public ResponseEntity<ResponseDto> createPolicy(@Valid @RequestBody Policies policy){
        harelService.savePolicy(policy);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(HarelConstants.STATUS_201, HarelConstants.MESSAGE_201));
    }


}
