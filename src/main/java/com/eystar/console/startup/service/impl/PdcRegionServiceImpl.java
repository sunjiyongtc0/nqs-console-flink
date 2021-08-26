package com.eystar.console.startup.service.impl;

import com.eystar.console.startup.entity.TPdcRegion;
import com.eystar.console.startup.mapper.TPdcRegionMapper;
import com.eystar.console.startup.service.PdcRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("pdcRegionService")
public class PdcRegionServiceImpl implements PdcRegionService {

    @Autowired
    private TPdcRegionMapper tPdcRegionMapper;

    @Override
    public TPdcRegion findByRcode(long rCode) {
        return tPdcRegionMapper.selectByPrimaryKey(rCode);
    }

    @Override
    public int updateRname(String rNameDb, String rName,int level) {
        return tPdcRegionMapper.updateRname(rNameDb,rName,level);
    }

    @Override
    public int updateRnameLike(String rNameDb, String rName) {
        return tPdcRegionMapper.updateRnameLike( rNameDb,  rName);
    }



    @Override
    public List<TPdcRegion> selectByPathNameLike(String pathName) {
        return tPdcRegionMapper.selectByPathNameLike(pathName);
    }
}
