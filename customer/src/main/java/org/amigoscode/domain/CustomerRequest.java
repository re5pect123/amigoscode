package org.amigoscode.domain;

import lombok.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {

    private int id;
    private String password;
    private String name;
    private String surname;
}
