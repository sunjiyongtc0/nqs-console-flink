package com.eystar.console.startup.handler.parser;

import com.eystar.console.startup.entity.gwdata.GwData;


public class DnsDataParser extends DetailAbstractDataParser{

	public DnsDataParser() {
		super("DNS_DETAIL");
	}

	@Override
	public void fillEachDetailRecord(GwData record) {}


}
