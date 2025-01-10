package com.example.springboot.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.springboot.board.dto.Board;

@Mapper
public interface BoardMapper {
    List<Board> getAllBoardList();
}
