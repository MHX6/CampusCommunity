package com.htu.shareinfo.service;

import com.htu.shareinfo.entity.Information;

/**
 * @author mhx
 * @date 2020-02-05 19:11
 **/
public interface PublishService {

    void publishInfo(Information article);

    void updateInfo(Information information);
}
