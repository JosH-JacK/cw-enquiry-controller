package com.conway.reference.cw_enquiry_controller.dto;

import com.conway.reference.cw_enquiry_controller.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEnquiryRequestDto {
    private String referenceType;
    private String customerName;
    private String customerAddress;
    private String contactPersonName;
    private Long contactNumber;
    private String emailId;
    private Long gstNumber;
    private String remarks;
    private List<Product> product;
    private boolean quotationGiven;
    private boolean followUpRequired;
}
