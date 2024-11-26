package com.jSierraB3991.franchise.infrastructure.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BranchOfficeByFranchiseResponse {
    private String id;
    private String name;
    private ProductResponseBasic product;
}