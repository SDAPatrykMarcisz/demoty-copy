package com.copy.demotywatorycopy.model.votes;

public enum VoteType {
    VOTE_UP ("voteUp"),
    VOTE_DOWN("voteDown");

    private final String type;

    VoteType(String type) {
        this.type = type;
    }

    public static VoteType fromCustomString(String source){
        for(VoteType type : VoteType.values()){
            if(type.name().equals(source) || type.type.equalsIgnoreCase(source)){
                return type;
            }
        }
        throw new IllegalArgumentException();
    }

    public String getType() {
        return type;
    }
}
