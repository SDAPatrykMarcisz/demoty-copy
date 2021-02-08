package com.copy.demotywatorycopy.model.posts;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreatePostResponse {
    private long id;
    private String topText;
    private String bottomText;
    private String imagePath;
}
