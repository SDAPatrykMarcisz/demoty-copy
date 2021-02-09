package com.copy.demotywatorycopy.model.comments;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UpdateCommentResponse {

    private Long id;
    private String content;

}
