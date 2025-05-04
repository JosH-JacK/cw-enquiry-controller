package com.conway.reference.cw_enquiry_controller.resultsetmapping;

import com.conway.reference.cw_enquiry_controller.dto.AllCustomerEnquiryResponseDto;
import jakarta.persistence.*;

import java.util.Date;
@Entity
@SqlResultSetMapping(
    name = "CustomerEnquiryResultSetMapping",
    classes = @ConstructorResult(
        targetClass = AllCustomerEnquiryResponseDto.class,
        columns = {
            @ColumnResult(name = "ENQUIRY_ID", type = Long.class),
            @ColumnResult(name = "REFERENCE_TYPE", type = String.class),
            @ColumnResult(name = "CUSTOMER_NAME", type = String.class),
            @ColumnResult(name = "CUSTOMER_ADDRESS", type = String.class),
            @ColumnResult(name = "CONTACT_PERSON_NAME", type = String.class),
            @ColumnResult(name = "CONTACT_NUMBER", type = Long.class),
            @ColumnResult(name = "EMAIL_ID", type = String.class),
            @ColumnResult(name = "MODEL", type = String.class),
            @ColumnResult(name = "OPTION_CODE", type = String.class),
            @ColumnResult(name = "TYPE", type = String.class),
            @ColumnResult(name = "GST_NUMBER", type = Long.class),
            @ColumnResult(name = "REMARKS", type = String.class),
            @ColumnResult(name = "QUOTATION_GIVEN", type = Boolean.class),
            @ColumnResult(name = "FOLLOW_UP_REQUIRED", type = Boolean.class),
            @ColumnResult(name = "ENQUIRED_ON", type = Date.class)
        }
    )
)

public class CustomerEnquiryResultSetMapper {
    @Id
    private Long enquiryId;
}
