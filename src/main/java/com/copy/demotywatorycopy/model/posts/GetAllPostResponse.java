package com.copy.demotywatorycopy.model.posts;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class GetAllPostResponse {
    private List<GetPostResponse> posts;
}
