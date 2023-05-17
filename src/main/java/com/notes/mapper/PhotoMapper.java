package com.notes.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.notes.domain.Photo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PhotoMapper extends BaseMapper<Photo> {
}
