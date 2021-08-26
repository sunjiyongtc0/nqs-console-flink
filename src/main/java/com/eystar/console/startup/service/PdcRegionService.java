package com.eystar.console.startup.service;




import com.eystar.console.startup.entity.TPdcRegion;

import java.util.List;

public interface PdcRegionService {

    TPdcRegion findByRcode(long rCode);


    int updateRname(String rNameDb,String rName,int level);

    int updateRnameLike(String rNameDb,String rName);

    List<TPdcRegion> selectByPathNameLike(String pathName);

}
