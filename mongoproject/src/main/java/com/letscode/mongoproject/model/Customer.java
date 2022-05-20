package com.letscode.mongoproject.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("product")
@Getter
@Setter
@Builder
public class Customer {

    @Id
    private String id;

    @Field
    private String name;

    @Field
    private String registrationNumber;
}
