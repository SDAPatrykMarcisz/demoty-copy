package com.copy.demotywatorycopy.model.comments;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CreateCommentRequest {

    @NotEmpty
    private String content;

}
