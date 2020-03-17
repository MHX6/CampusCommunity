package com.htu.shareinfo.service;

import com.htu.shareinfo.dto.InfoDTO;
import com.htu.shareinfo.dto.PaginationDTO;

public interface InfoService {
    PaginationDTO selectAllInfo(Long uid, Integer page, Integer size);

    InfoDTO selectByid(Long id);
}
