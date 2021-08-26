package com.eystar.console.startup.mapper;


import com.eystar.console.startup.entity.TPdcRegion;

import java.util.List;

public interface TPdcRegionMapper {
    int deleteByPrimaryKey(Long rCode);

    int insert(TPdcRegion record);

    int insertSelective(TPdcRegion record);

    TPdcRegion selectByPrimaryKey(Long rCode);

    int updateByPrimaryKeySelective(TPdcRegion record);

    int updateByPrimaryKey(TPdcRegion record);

    int updateRname(String rNameDb,String rName,int level);

    int updateRnameLike(String rNameDb,String rName);

    List<TPdcRegion> selectByPathNameLike(String pathName);
}