package com.notes.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.notes.domain.Notes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;


@Mapper
public interface NotesMapper extends BaseMapper<Notes> {
    @Update("update t_notes set notes_group='' where notes_group=#{groupName}")
    void deleteGroup(String groupName);

}
