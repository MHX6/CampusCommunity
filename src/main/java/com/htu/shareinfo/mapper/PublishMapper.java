package com.htu.shareinfo.mapper;

import com.htu.shareinfo.entity.Information;

public interface PublishMapper {

    void insertInfo(Information article);

    void updateInfo(Information information);
}
