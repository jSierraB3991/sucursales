package com.jSierraB3991.franchise.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Document(collection = "franchises")
public class Franchise implements Serializable {
    @Serial
    private static final long serialVersionUID = 4459946113200984315L;
    @Id
    private String id;
    private String name;
}
