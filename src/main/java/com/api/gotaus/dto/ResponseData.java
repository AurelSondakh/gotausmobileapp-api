package com.api.gotaus.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class ResponseData<T> {
    
    @Getter
    @Setter
    private boolean status;

    @Getter
    @Setter
    private List<String> message = new ArrayList<>();

    @Getter
    @Setter
    private T payload;
}
