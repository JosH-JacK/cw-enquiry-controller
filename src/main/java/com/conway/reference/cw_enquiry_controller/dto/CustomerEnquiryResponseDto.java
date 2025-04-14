package com.conway.reference.cw_enquiry_controller.dto;

import com.conway.reference.cw_enquiry_controller.model.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEnquiryResponseDto {
    private Long enquiryId;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date enquiredOn;
}
