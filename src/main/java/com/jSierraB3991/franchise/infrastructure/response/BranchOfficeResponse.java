package com.jSierraB3991.franchise.infrastructure.response;

import com.fasterxml.jackson.annotation.JsonAlias;
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
public class BranchOfficeResponse {
    private String id;
    private String name;
    @JsonAlias("franchise")
    private FranchiseResponse franchiseResponse;
}
