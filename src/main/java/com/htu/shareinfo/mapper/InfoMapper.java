package com.htu.shareinfo.mapper;

import com.htu.shareinfo.entity.Information;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InfoMapper {

    List<Information> selectAllInfo(@Param("uid")Long uid, @Param("offset")Integer offset, @Param("size")Integer size);

    Integer totalCount(Long uid);

    Information selectByid(Long id);
}
