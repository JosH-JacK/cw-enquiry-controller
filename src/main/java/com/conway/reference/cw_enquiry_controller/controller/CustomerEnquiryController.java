package com.conway.reference.cw_enquiry_controller.controller;

import com.conway.reference.cw_enquiry_controller.dto.AllCustomerEnquiryResponseDto;
import com.conway.reference.cw_enquiry_controller.dto.CustomerEnquiryRequestDto;
import com.conway.reference.cw_enquiry_controller.service.CustomerEnquiryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CustomerEnquiryController {

    private final CustomerEnquiryService customerEnquiryService;

    @PostMapping(value = "/add-enquiry")
    public ResponseEntity<String> addNewReferenceEnquiry(@RequestBody CustomerEnquiryRequestDto customerEnquiryRequestDto) {
        String response = customerEnquiryService.addNewCustomerEnquiry(customerEnquiryRequestDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/customer-enquiries")
    public ResponseEntity<List<AllCustomerEnquiryResponseDto>> getAllCustomerEnquiries(){
        List<AllCustomerEnquiryResponseDto> response = customerEnquiryService.getAllEnquiries();
        return ResponseEntity.ok(response);
    }
}
