package com.conway.reference.cw_enquiry_controller.controller;

import com.conway.reference.cw_enquiry_controller.dto.CustomerEnquiryRequestDto;
import com.conway.reference.cw_enquiry_controller.service.CustomerEnquiryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CustomerEnquiryControllerImpl {

    private final CustomerEnquiryService customerEnquiryService;

    @PostMapping(value = "/add-enquiry")
    public ResponseEntity<String> addNewReferenceEnquiry(@RequestBody CustomerEnquiryRequestDto customerEnquiryRequestDto) {
        String response = customerEnquiryService.addNewCustomerEnquiry(customerEnquiryRequestDto);
        return ResponseEntity.ok(response);
    }

}
