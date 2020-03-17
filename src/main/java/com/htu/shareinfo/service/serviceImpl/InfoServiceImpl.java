package com.htu.shareinfo.service.serviceImpl;

import com.htu.shareinfo.dto.InfoDTO;
import com.htu.shareinfo.dto.PaginationDTO;
import com.htu.shareinfo.entity.Information;
import com.htu.shareinfo.entity.User;
import com.htu.shareinfo.mapper.InfoMapper;
import com.htu.shareinfo.mapper.UserMapper;
import com.htu.shareinfo.service.InfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mhx
 * @date 2020-02-18 10:45
 **/
@Service
public class InfoServiceImpl implements InfoService {

    @Autowired(required = false)
    private InfoMapper infoMapper;

    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public PaginationDTO selectAllInfo(Long uid,Integer page, Integer size) {

        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalCount = infoMapper.totalCount(uid);
        paginationDTO.setPagination(totalCount,page,size);
        if (page < 1){
            page = 1;
        }
        if (page > paginationDTO.getTotalPage()){
            page = paginationDTO.getTotalPage();
        }

        Integer offset = size * (page-1);
        List<Information> infoList = infoMapper.selectAllInfo(uid,offset,size);
        List<InfoDTO> infoDTOList = new ArrayList<>();
        for (Information info : infoList){
            InfoDTO infoDTO = new InfoDTO();
            User user = userMapper.findByUid(info.getUid());
            BeanUtils.copyProperties(info,infoDTO);
            infoDTO.setUser(user);
            infoDTOList.add(infoDTO);
        }
        paginationDTO.setInfoDTOS(infoDTOList);
        return paginationDTO;
    }

    @Override
    public InfoDTO selectByid(Long id) {
        Information info = infoMapper.selectByid(id);
        System.out.println(info);
        InfoDTO infoDTO = new InfoDTO();
        BeanUtils.copyProperties(info,infoDTO);
        User user = userMapper.findByUid(info.getUid());
        infoDTO.setUser(user);
        return  infoDTO;
    }

}
