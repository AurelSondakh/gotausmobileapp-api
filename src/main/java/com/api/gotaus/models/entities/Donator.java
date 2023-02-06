package com.api.gotaus.models.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "donator")
public class Donator implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    @NotEmpty(message = "donator id is required")
    private String donatorID;

    @Getter
    @Setter
    @NotEmpty(message = "donator name is required")
    //@Column(name = "donatorName", length = 100)
    private String donatorName;
    
}
