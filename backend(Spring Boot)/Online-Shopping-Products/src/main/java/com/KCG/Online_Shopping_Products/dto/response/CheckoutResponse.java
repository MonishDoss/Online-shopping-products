package com.KCG.Online_Shopping_Products.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CheckoutResponse {
    private String message;
    private double totalAmount;
}