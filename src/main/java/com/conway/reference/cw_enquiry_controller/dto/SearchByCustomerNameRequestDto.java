package com.conway.reference.cw_enquiry_controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchByCustomerNameRequestDto {
    private String customerName;
}
