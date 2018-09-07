package com.songhaozhi.mayday.mapper;

import com.songhaozhi.mayday.model.domain.Attachment;
import java.util.List;

public interface AttachmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Attachment record);

    Attachment selectByPrimaryKey(Integer id);

    List<Attachment> selectAll();

    int updateByPrimaryKey(Attachment record);
}