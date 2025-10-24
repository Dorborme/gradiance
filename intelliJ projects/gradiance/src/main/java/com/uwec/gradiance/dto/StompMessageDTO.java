package com.uwec.gradiance.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

public class StompMessageDTO {

    @Getter
    @NotBlank
    private String sender;
    @Getter
    private String timestamp;
    @Getter
    @NotBlank
    private String message;

    public StompMessageDTO (String sender, String message) {
        if(sender == null || sender.isBlank()) {
            throw new IllegalArgumentException("sender cannot be null or blank");
        }
        else {this.sender = sender;}
        
        this.timestamp = System.currentTimeMillis() + "";
        if(message == null || message.isBlank()) {
            throw new IllegalArgumentException("message cannot be null or blank");
        }
        else {this.message = message;}

    }

}
