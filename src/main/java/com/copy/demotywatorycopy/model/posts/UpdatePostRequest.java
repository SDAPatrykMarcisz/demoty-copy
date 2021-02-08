package com.copy.demotywatorycopy.model.posts;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UpdatePostRequest {
    private String topText;
    @NotEmpty
    private String bottomText;
    @NotEmpty
    private String imagePath;
}
