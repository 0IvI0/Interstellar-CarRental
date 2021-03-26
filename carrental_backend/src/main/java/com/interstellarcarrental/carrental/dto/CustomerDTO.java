package com.interstellarcarrental.carrental.dto;

import java.time.LocalDate;
import java.util.List;

import com.interstellarcarrental.carrental.models.Invoice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


@SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
public class CustomerDTO extends UserDTO {

/*     private String username;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String emailAddress;
    private String phoneNumber;
    private String address;
    private String creditCardNumber;

    private List<Invoice> invoiceList; */
}