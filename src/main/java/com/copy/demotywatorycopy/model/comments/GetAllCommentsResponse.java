package com.copy.demotywatorycopy.model.comments;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class GetAllCommentsResponse {

    private List<GetCommentResponse> comments;

}
