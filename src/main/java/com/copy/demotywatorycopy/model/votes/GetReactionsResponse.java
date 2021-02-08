package com.copy.demotywatorycopy.model.votes;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class GetReactionsResponse {

    private long votesUp;
    private long votesDown;
    private long balance;

}
