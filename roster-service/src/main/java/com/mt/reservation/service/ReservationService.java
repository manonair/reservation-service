package com.mt.reservation.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mt.reservation.mapper.TableReservationMapper;
import com.mt.reservation.model.TableReservation;
import com.mt.reservation.repository.TableReservationRepository;
import com.mt.reservation.vo.TableRequestVO;
import com.mt.reservation.vo.TableReservationVO;
import com.mt.reservation.vo.TablesVO;

 

@Service
public class ReservationService {

	@Autowired
	private TableReservationRepository reservationRepository ;

	 @Autowired
	 private TableReservationMapper reservationMapper;
	
		@Autowired
	    RestTemplate restTemplate;
		
		
		
	public List<TableReservationVO> findAll() throws Exception {
		List<TableReservationVO> vos = null;
		List<TableReservation> reservations = (List<TableReservation>) reservationRepository.findAll();
		if (!reservations.isEmpty()) {
			Map<Integer, TableReservationVO> voMap = reservations.stream()
					.collect(Collectors.toMap(TableReservation::getTableReservationId, obj -> mapToReservationVO(obj)));
			
			List<Integer> collect=reservations.stream()
					.map(TableReservation::getTableId)
					.collect(Collectors.toList());
			
			ParameterizedTypeReference<List<TablesVO>> response = new ParameterizedTypeReference<List<TablesVO>>(){};
	 
	        TableRequestVO requestVO = new TableRequestVO();
	        requestVO.setIds(collect);
	        ResponseEntity<List> responseEntity= restTemplate.postForEntity("http://restaurant-service/tables/tableIds", requestVO, List.class);
//					.getForObject("http://RESTAURANT-SERVICE/tables/",ResponseEntity.class,collect );
	        List<TablesVO> tables= responseEntity.getBody();

			Map<Integer, TablesVO> tableMap =new HashMap<Integer, TablesVO>();
			/*tableMap.put(tables.getTableId(), tables);
					tables.stream()
					.collect(Collectors.toMap(TablesVO::getTableId, obj->obj));*/
			
			vos=reservations.stream().map(reservation->  mapToReservationVO(voMap.get(reservation.getTableReservationId()), tableMap.get(reservation.getTableId())))
			.collect(Collectors.toList());
		}
		return vos;
	}
	
	public Integer createTableReservation(TableReservationVO reservationVO) {
		TableReservation entity= reservationMapper.maptoEntity(reservationVO);
		entity=reservationRepository.saveAndFlush(entity);
		return entity.getRestaurantId();
	}

	public Boolean deleteTableReservation(Integer reservationId) {
		reservationRepository.delete(reservationId);
		return true;
	}
	
	
	private TableReservationVO mapToReservationVO(TableReservationVO reservationVO, TablesVO tablesVO) {
		reservationVO.setRestaurantVO( tablesVO.getRestaurantVO());
		reservationVO.setTablesVO( tablesVO);
		return reservationVO;
	}
	
	 
	
	
	private TableReservationVO mapToReservationVO(TableReservation reservation) {
		TableReservationVO vo=null; 
		vo = reservationMapper.maptoTableReservationVO(reservation);
		return vo;
	} 

}
