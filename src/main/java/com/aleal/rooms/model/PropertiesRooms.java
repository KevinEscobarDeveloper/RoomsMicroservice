package com.aleal.rooms.model;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PropertiesRooms {
	private String msg;
	private String buildVersion;
	private Map<String, String> mailDetails;

}
