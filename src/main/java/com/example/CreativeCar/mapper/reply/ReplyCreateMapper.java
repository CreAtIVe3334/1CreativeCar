package com.example.CreativeCar.mapper.reply;

import com.example.CreativeCar.dto.reply.CreateReplyDTO;
import com.example.CreativeCar.entity.Comment;
import com.example.CreativeCar.entity.Reply;
import com.example.CreativeCar.entity.Users;

public class ReplyCreateMapper {
    public static Reply dtoToEntity(CreateReplyDTO createReplyDTO, Comment comment, Users user) {
        return Reply.builder().reply(
                createReplyDTO.getReply()).
                comment(comment).
                user(user)
                .build();
    }
}
