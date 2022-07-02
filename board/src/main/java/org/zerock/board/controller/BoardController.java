package org.zerock.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.board.dto.BoardDTO;
import org.zerock.board.dto.PageRequestDTO;
import org.zerock.board.dto.PageResultDTO;
import org.zerock.board.entity.Board;
import org.zerock.board.service.BoardService;

@Controller
@RequestMapping("/board/")
@Log4j2
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model){
        log.info("list............" + pageRequestDTO);

        model.addAttribute("result", boardService.getList(pageRequestDTO));
    }

    @GetMapping("/register")
    public void register(){
        log.info("register get...");
    }

    @PostMapping("/register")
    public String register(BoardDTO boardDTO, RedirectAttributes redirectAttributes){
        log.info("dto..." + boardDTO);
        Long bno = boardService.register(boardDTO);
        redirectAttributes.addFlashAttribute("msg", bno);
        return "redirect:/board/list";
    }

    @GetMapping({"/read", "/modify"})
    public void read(long bno, @ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO, Model model){
        log.info("bno: " + bno );
        BoardDTO dto = boardService.get(bno);
        log.info(dto);
        model.addAttribute("dto", dto);
    }

    @PostMapping("/modify")
    public String modify(BoardDTO boardDTO, @ModelAttribute("requestDTO")PageRequestDTO pageRequestDTO, RedirectAttributes redirectAttributes){
        log.info("post modify.................");
        log.info("dto: " + boardDTO);

        boardService.modify(boardDTO);

        redirectAttributes.addAttribute("page", pageRequestDTO.getPage());
        redirectAttributes.addAttribute("type", pageRequestDTO.getType());
        redirectAttributes.addAttribute("keyword", pageRequestDTO.getKeyword());

        redirectAttributes.addAttribute("bno", (long)boardDTO.getBno());

        return "redirect:/board/read";
    }

    @PostMapping("/remove")
    public String remove(long bno, RedirectAttributes redirectAttributes){
        log.info("bno: " + bno);
        boardService.removeWithReplies(bno);
        redirectAttributes.addFlashAttribute("msg", bno);
        return "redirect:/board/list";
    }
}
