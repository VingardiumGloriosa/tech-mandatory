package com.techman.techmandatory2.service;

import com.techman.techmandatory2.model.Friendship2;
import com.techman.techmandatory2.model.Protocol;
import com.techman.techmandatory2.repo.*;

import org.springframework.stereotype.Service;

@Service
public class FriendshipService {

    private final Friendship2Repo friendship2Repo;

    public FriendshipService(Friendship2Repo friendship2Repo) {
        this.friendship2Repo = friendship2Repo;
    }

    public Friendship2 handleFriendship(Protocol protocol) {
        String src = protocol.getSRC();
        String dest = protocol.getDEST();
        Friendship2 friendship = friendship2Repo.findBySrcUserEmailAndDestUserEmail(src, dest);
        Friendship2 backFriendship = friendship2Repo.findBySrcUserEmailAndDestUserEmail(dest, src);

        if(friendship == null){
            friendship = backFriendship;
        }

        switch(protocol.getMethod()) {
            case "ADD":
                if (friendship == null) {
                    friendship = new Friendship2(src, dest, "PENDING");
                    friendship2Repo.save(friendship);
                }
                break;
            case "ACCEPT":
                if (friendship != null) {
                    if(friendship.getStatus().equals("PENDING") && friendship.getSrcUserEmail().equals(protocol.getDEST())) {
                        friendship.setStatus("ACCEPTED");
                        friendship2Repo.save(friendship);
                    }
                }
                break;
            case "DENY":
                if(friendship.getStatus().equals("PENDING")){
                    friendship2Repo.delete(friendship);
                    friendship.setStatus("DENIED");
                }
                break;
            case "REMOVE":
                if (friendship.getStatus().equals("ACCEPTED")) {
                    friendship2Repo.delete(friendship);
                    friendship.setStatus("REMOVED");
                }
                break;
            case "BLOCK":
                if (friendship == null) {
                    friendship = new Friendship2(src, dest, "BLOCKED");
                }
                else {
                    friendship.setStatus("BLOCKED");
                }
                friendship2Repo.save(friendship);
                break;
            default:
        }
        return friendship;
    }

    public Friendship2 getFriendship(Protocol protocol) {
        return friendship2Repo.findBySrcUserEmailAndDestUserEmail(protocol.getSRC(), protocol.getDEST());
    }
}
