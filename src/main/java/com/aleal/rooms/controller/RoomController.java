package com.aleal.rooms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aleal.rooms.config.RoomServiceConfiguration;
import com.aleal.rooms.model.PropertiesRooms;
import com.aleal.rooms.model.Room;
import com.aleal.rooms.services.IRoomService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RoomController {

	@Autowired
	private IRoomService service;
	
	@Autowired
	private RoomServiceConfiguration configRoom;
	
	@GetMapping("rooms")
	public List<Room> search(){
		log.info("inicio del metodo search en rooms");
		return (List<Room>) this.service.search();	
	}
	
	@GetMapping("rooms/{id}")
	public List<Room> searchByHotelId(@PathVariable long id){
		log.info("inicio del metodo search by id de rooms");
		return (List<Room>) this.service.searchRoomByHotelId(id);	
	}
	
	
	@GetMapping("/hotels/read/properties")
	public String getPropertiesHotels() throws JsonProcessingException {
		ObjectWriter owj = new ObjectMapper().writer().withDefaultPrettyPrinter();
		PropertiesRooms propertiesRoom = new PropertiesRooms(configRoom.getMsg(), configRoom.getBuildVersion(), configRoom.getMailDetails());
		String jsonString = owj.writeValueAsString(propertiesRoom);
		return jsonString;
	}
}
