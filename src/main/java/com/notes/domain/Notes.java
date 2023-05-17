package com.notes.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 错题
 */
@Data
@TableName("t_notes")
@AllArgsConstructor
@NoArgsConstructor
public class Notes {
    @TableId(type = IdType.ASSIGN_ID)
    private int notesId; // 错题编号
    private String notesTitle; //错题标题
    private String promulgator; //发布者账号
    private String priority; // 错题优先级
    private String subject; // 题目
    private String answer;// 答案
    private String respond ; // 我的答案
    private String summary; // 总结
    private String notesGroup; //错题分组
    private boolean deleted; //是否删除
    private String updateTime;//更新时间
}
