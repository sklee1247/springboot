package com.example.springboot.board.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.board.dto.Board;
import com.example.springboot.board.service.BoardService;

@RestController
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/list")
    public List<Board> findAll() {
        return boardService.getAllBoardList();
    }

}