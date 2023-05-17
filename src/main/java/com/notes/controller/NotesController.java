package com.notes.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.notes.domain.Notes;
import com.notes.service.NotesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notes")
@Slf4j
public class NotesController {

    @Autowired
    NotesService notesService;

    /**
     * 获取错题详情（需要切换图片源）
     *
     * @param notesId 笔记Id
     * @return 是否插入成功
     */
    @GetMapping("/getNotesById/{notesId}")
    public Notes getNotesById(@PathVariable String notesId) {
        return notesService.getNotesById(Integer.parseInt(notesId));
    }

    /**
     * 条件获取用户错题（用于列表显示
     *
     * @return 分页结果
     */
    @PostMapping("/getNotes/{currentPage}/{pageSize}")
    public IPage<Notes> getNotes(@PathVariable long currentPage, @PathVariable long pageSize,@RequestBody Map<String,Object> map) {
        String account = (String) map.get("account");
        Map<String,String> condition = (Map<String, String>) map.get("condition");
        int order = (int) map.get("order");
        String orderCondition = (String) map.get("orderCondition");
        log.info("[getNotes] condition = {}", condition);
        return notesService.getNotes(currentPage,pageSize,account,condition,order,orderCondition);
    }

    @PostMapping("/test/{id}")
    public String test(@PathVariable String id){
        return id;
    }

    /**
     * 插入数据
     *
     * @param account 发布者账号（当前用户）
     * @param notes   待插入的笔记
     * @return 是否插入成功
     */
    @PostMapping("/addNotes")
    public boolean addNotes(@RequestParam("account") String account, @RequestBody Notes notes) {
        System.out.println(notes);
        return notesService.insert(account, notes);
    }

    /**
     * 更新Notes
     */
    @PutMapping("/updateNotes")
    public Notes updateNotes(@RequestBody Notes notes) {
        return notesService.update(notes);
    }

    /**
     * 删除错题
     *
     * @return 是否删除成功
     */
    @DeleteMapping("/deleteNotes/{notesId}")
    public boolean deleteNotes(@PathVariable Integer notesId) {
        return notesService.delete(notesId);
    }

    /**
     * 批量删除错题(调用delete方法,用于删除缓存）
     *
     * @param selectedNotesId 要删除的notesId集合
     * @return 是否删除成功
     */
    @DeleteMapping("/multiDeleteNotes")
    public boolean multiDeleteNotes(@RequestBody List<Integer> selectedNotesId) {
        return notesService.delete(selectedNotesId);
    }
}
