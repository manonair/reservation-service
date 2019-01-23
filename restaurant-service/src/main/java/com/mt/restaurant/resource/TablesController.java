package com.mt.restaurant.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mt.restaurant.service.TablesService;
import com.mt.restaurant.vo.TablesVO;



@RestController
@RequestMapping("/tables")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TablesController {


	private Logger LOGGER = LoggerFactory.getLogger(TablesController.class);

	@Autowired
	private TablesService service;

	@RequestMapping(path = "/{table_id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<TablesVO> getTableById(@PathVariable("table_id") Integer id) {
		TablesVO tablesVO;
		try {
			tablesVO = service.findById(id);
		} catch (Exception e) {
			return new ResponseEntity<TablesVO>(HttpStatus.INTERNAL_SERVER_ERROR); 
		}
		return tablesVO != null ? new ResponseEntity<TablesVO>(tablesVO, HttpStatus.OK) 
	            : new ResponseEntity<TablesVO>(HttpStatus.NO_CONTENT); 
	}

	
	@RequestMapping(path = "/all", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<TablesVO>> getAllTables() {
		List<TablesVO> tables;
		try {
			tables = service.findAll();
		} catch (Exception e) {
			return new ResponseEntity<List<TablesVO>>(HttpStatus.INTERNAL_SERVER_ERROR); 
		}
		return tables != null ? new ResponseEntity<List<TablesVO>>(tables, HttpStatus.OK) 
	            : new ResponseEntity<List<TablesVO>>(HttpStatus.NO_CONTENT); 
	}
	
	
	@PostMapping("/add")
    public ResponseEntity<Integer>add(@RequestBody final TablesVO restaurantVO) {
		Integer id = service.createTables(restaurantVO);
		return id != null ? new ResponseEntity<Integer>(id, HttpStatus.OK) 
	            : new ResponseEntity<Integer>(HttpStatus.NO_CONTENT);
    }
	
	
	@PostMapping("/delete/{tableId}")
    public ResponseEntity<Boolean> delete(@PathVariable("tableId") final Integer tableId) {
        Boolean status = service.deleteTables(tableId);
        return status != null ? new ResponseEntity<Boolean>(status, HttpStatus.OK) 
	            : new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT);
    }
	 

}
