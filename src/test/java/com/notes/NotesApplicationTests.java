package com.notes;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.notes.domain.Notes;
import com.notes.mapper.NotesMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NotesApplicationTests {
    @Autowired
    private NotesMapper notesMapper;

    @Test
    void testGetNotes() {
        QueryWrapper<Notes> qw = new QueryWrapper<>();
        qw.eq("promulgator", "lisi");
        notesMapper.selectList(qw).stream().forEach(System.out::println);
    }

}
