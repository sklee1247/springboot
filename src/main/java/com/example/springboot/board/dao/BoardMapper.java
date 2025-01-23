package com.example.springboot.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.springboot.board.model.Board;

@Mapper
public interface BoardMapper {
    
	public List<Board> getAllBoardList();
}
