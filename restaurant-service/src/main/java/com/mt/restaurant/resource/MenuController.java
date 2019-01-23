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

import com.mt.restaurant.service.MenuService;
import com.mt.restaurant.vo.MenuVO;



@RestController
@RequestMapping("/menu")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MenuController {


	private Logger LOGGER = LoggerFactory.getLogger(MenuController.class);

	@Autowired
	private MenuService service;

	@RequestMapping(path = "/{menu_id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<MenuVO> getMenuById(@PathVariable("menu_id") Integer id) {
		MenuVO menuVO;
		try {
			menuVO = service.findById(id);
		} catch (Exception e) {
			return new ResponseEntity<MenuVO>(HttpStatus.INTERNAL_SERVER_ERROR); 
		}
		return menuVO != null ? new ResponseEntity<MenuVO>(menuVO, HttpStatus.OK) 
	            : new ResponseEntity<MenuVO>(HttpStatus.NO_CONTENT); 
	}

	
	@RequestMapping(path = "/all", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<MenuVO>> getAllMenu() {
		List<MenuVO> menuVOs;
		try {
			menuVOs = service.findAll();
		} catch (Exception e) {
			return new ResponseEntity<List<MenuVO>>(HttpStatus.INTERNAL_SERVER_ERROR); 
		}
		return menuVOs != null ? new ResponseEntity<List<MenuVO>>(menuVOs, HttpStatus.OK) 
	            : new ResponseEntity<List<MenuVO>>(HttpStatus.NO_CONTENT); 
	}
	
	
	@PostMapping("/add")
    public ResponseEntity<Integer>add(@RequestBody final MenuVO menuVO) {
		Integer id = service.createMenu(menuVO);
		return id != null ? new ResponseEntity<Integer>(id, HttpStatus.OK) 
	            : new ResponseEntity<Integer>(HttpStatus.NO_CONTENT);
    }
	
	
	@PostMapping("/delete/{menu_id}")
    public ResponseEntity<Boolean> delete(@PathVariable("menu_id") final Integer menuId) {
        Boolean status = service.deleteMenu(menuId);
        return status != null ? new ResponseEntity<Boolean>(status, HttpStatus.OK) 
	            : new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT);
    }
	 

}
