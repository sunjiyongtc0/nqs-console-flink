package com.eystar.console.startup.service;




import com.eystar.console.startup.entity.TMIpRegion;

public interface IpRegionService {




    TMIpRegion findByIP(String ip);

}
