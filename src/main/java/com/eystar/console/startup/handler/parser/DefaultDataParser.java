package com.eystar.console.startup.handler.parser;


import com.eystar.console.startup.entity.gwdata.GwData;
import com.eystar.console.startup.handler.message.DataMessage;

public class DefaultDataParser extends AbstractDataParser{

	private  DataMessage message;

	public   void init(DataMessage msg){
		message=msg;
	}

	@Override
	public void prepare(GwData record) {
		System.out.println("DefaultDataParser"+"====-----===>prepare");
	}

//
//	@Override
//	public void after(Record record) {
//
//	}
	
}
