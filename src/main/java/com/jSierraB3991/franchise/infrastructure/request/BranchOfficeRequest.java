package com.jSierraB3991.franchise.infrastructure.request;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BranchOfficeRequest {
    private String name;
    @JsonAlias("franchise_id")
    private String franchiseId;
}
