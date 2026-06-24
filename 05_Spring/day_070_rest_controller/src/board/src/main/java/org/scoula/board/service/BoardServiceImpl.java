package org.scoula.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.board.domain.BoardVO;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.mapper.BoardMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
@Log4j2
@RequiredArgsConstructor //final 멤버를 인자로 가지는 생성자 추가
public class BoardServiceImpl implements BoardService {
    // 생성자가 1개인 경우 생성자 주입으로 초기화
    final private BoardMapper mapper;


    @Override
    public List<BoardDTO> getList() {
        log.info("getList...........");

        return mapper.getList().stream()
                .map(BoardDTO::of)
                //vo -> BoardDTO.of(vo)
                .toList();
    }

    @Override
    public BoardDTO get(Long no) {
        log.info("get........" + no);
        BoardDTO board = BoardDTO.of(mapper.get(no));
        return Optional.ofNullable(board)
                .orElseThrow(NoSuchElementException::new);
                //() -> new NoSuchElementException
    }

    @Transactional // 2개 이상의 insert 문이 실행될 수 있으므로 트랜잭션 처리 필요
    @Override
    public BoardDTO create(BoardDTO board) {
        log.info("create......" + board);
        BoardVO boardVO= board.toVo();
        mapper.create(boardVO);
        // 파일 업로드 처리
        List<MultipartFile> files = board.getFiles();
        if(files != null && !files.isEmpty()) {
            upload(boardVO.getNo(), files);
        }
        return get(boardVO.getNo());
    }

    @Override
    public BoardDTO update(BoardDTO board) {
        log.info("update......" + board);
        mapper.update(board.toVo());
        return get(board.getNo());
    }

    @Override
    public BoardDTO delete(Long no) {
        log.info("delete...." + no);
        BoardDTO board = get(no);

        mapper.delete(no);
        return board;
    }
}
