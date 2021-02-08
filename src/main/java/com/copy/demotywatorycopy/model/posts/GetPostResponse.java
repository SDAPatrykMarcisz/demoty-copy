package com.copy.demotywatorycopy.model.posts;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class GetPostResponse {
    private long id;
    private String topText;
    private String bottomText;
    private String imagePath;
}
