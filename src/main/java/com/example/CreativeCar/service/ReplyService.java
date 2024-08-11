package com.example.CreativeCar.service;

import com.example.CreativeCar.entity.Reply;
import com.example.CreativeCar.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReplyService {

    @Autowired
    private ReplyRepository replyRepository;

    public List<Reply> getAllReplies() {
        return replyRepository.findAll();
    }

    public Optional<Reply> getReplyById(Long id) {
        return replyRepository.findById(id);
    }

    public Reply saveReply(Reply reply) {
        return replyRepository.save(reply);
    }

    public void deleteReply(Long id) {
        replyRepository.deleteById(id);
    }


}
