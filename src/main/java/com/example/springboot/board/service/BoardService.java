package com.example.springboot.board.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springboot.board.dao.BoardMapper;
import com.example.springboot.board.model.Board;

@Service
public class BoardService {

    private final BoardMapper boardMapper;

    public BoardService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    public List<Board> getAllBoardList() {
    	List<Board> board = new ArrayList<Board>();
    	
    	try {
        	board = boardMapper.getAllBoardList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return board;
    }
    
}