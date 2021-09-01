package com.eystar.console.startup.handler.parser;


import com.eystar.console.startup.entity.gwdata.GwData;

public class TraceDataParser extends DetailAbstractDataParser{

	public TraceDataParser() {
		super("TRACE_DETAIL");
	}
	
	@Override
	public void fillEachDetailRecord(GwData record) {}

}
