package com.mt.reservation.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mt.reservation.mapper.ReservationMapper;
import com.mt.reservation.mapper.TableReservationMapper;
import com.mt.reservation.model.TableReservation;
import com.mt.reservation.repository.TableReservationRepository;
import com.mt.reservation.vo.ReservationVO;
import com.mt.reservation.vo.TableRequestVO;
import com.mt.reservation.vo.TableReservationVO;
import com.mt.reservation.vo.TablesVO;

@Service
public class ReservationService {

	private Logger LOGGER = LoggerFactory.getLogger(ReservationService.class);
	@Autowired
	private TableReservationRepository reservationRepository;

	@Autowired
	private TableReservationMapper reservationMapper;

	@Autowired
	private ReservationMapper mapper;

	@Autowired
	RestTemplate restTemplate;

	/*
	 * public List<TableReservationVO> findAll() throws Exception {
	 * List<TableReservationVO> vos = null; List<TableReservation> reservations =
	 * (List<TableReservation>) reservationRepository.findAll(); if
	 * (!reservations.isEmpty()) { Map<Integer, TableReservationVO> voMap =
	 * reservations.stream()
	 * .collect(Collectors.toMap(TableReservation::getTableReservationId, obj ->
	 * mapToReservationVO(obj)));
	 * 
	 * List<Integer> collect =
	 * reservations.stream().map(TableReservation::getTableId)
	 * .collect(Collectors.toList());
	 * 
	 * TableRequestVO requestVO = new TableRequestVO(); requestVO.setIds(collect);
	 * ParameterizedTypeReference<List<TablesVO>> response = new
	 * ParameterizedTypeReference<List<TablesVO>>() { }; HttpEntity<TableRequestVO>
	 * requestEntity = new HttpEntity<>(requestVO); ResponseEntity<List<TablesVO>>
	 * responseEntity = restTemplate
	 * .exchange("http://restaurant-service/tables/tableIds", HttpMethod.POST,
	 * requestEntity, response); List<TablesVO> tables = responseEntity.getBody();
	 * 
	 * Map<Integer, TablesVO> tableMap = tables.stream()
	 * .collect(Collectors.toMap(TablesVO::getTableId, obj -> obj));
	 * 
	 * 
	 * vos = reservations.stream() .map(reservation ->
	 * mapToReservationVO(voMap.get(reservation.getTableReservationId()),
	 * tableMap.get(reservation.getTableId()))) .collect(Collectors.toList()); }
	 * return vos; }
	 */

	public ReservationVO findById(Integer reservationId) throws Exception {
		ReservationVO vo = null;
		TableReservation reservation = (TableReservation) reservationRepository.findOne(reservationId);
		if (null != reservation) {
			vo = mapToReservationVO(reservation);
			TableRequestVO requestVO = new TableRequestVO();
			requestVO.setIds(Arrays.asList(vo.getTableId()));
			ParameterizedTypeReference<List<TablesVO>> response = new ParameterizedTypeReference<List<TablesVO>>() {
			};
			HttpEntity<TableRequestVO> requestEntity = new HttpEntity<>(requestVO);
			ResponseEntity<List<TablesVO>> responseEntity = restTemplate
					// .exchange("http://restaurant-service/tables/tableIds", HttpMethod.POST,
					// requestEntity, response);
					.exchange("http://restaurant-service/tables/tableIds", HttpMethod.POST, requestEntity, response);
			List<TablesVO> tables = responseEntity.getBody();

			if (!tables.isEmpty() && null != tables.get(0)) {
				vo = mapToReservationVO(vo, tables.get(0));
			}
		}
		return vo;
	}

	public ReservationVO findByReservationName(String reservationName) throws Exception {
		ReservationVO vo = null;
		TableReservation reservation = (TableReservation) reservationRepository.findByReservationName(reservationName);
		if (null != reservation) {
			vo = mapToReservationVO(reservation);
			TableRequestVO requestVO = new TableRequestVO();
			requestVO.setIds(Arrays.asList(vo.getTableId()));
			ParameterizedTypeReference<List<TablesVO>> response = new ParameterizedTypeReference<List<TablesVO>>() {
			};
			HttpEntity<TableRequestVO> requestEntity = new HttpEntity<>(requestVO);
			ResponseEntity<List<TablesVO>> responseEntity = restTemplate
					.exchange("http://restaurant-service/tables/tableIds", HttpMethod.POST, requestEntity, response);
			List<TablesVO> tables = responseEntity.getBody();

			if (!tables.isEmpty() && null != tables.get(0)) {
				vo = mapToReservationVO(vo, tables.get(0));
			}
		}
		return vo;
	}

	public List<ReservationVO> findAll() throws Exception {
		List<ReservationVO> vos = null;
		List<TableReservation> reservations = (List<TableReservation>) reservationRepository.findAll();
		if (!reservations.isEmpty()) {
			Map<Integer, ReservationVO> voMap = reservations.stream()
					.collect(Collectors.toMap(TableReservation::getTableReservationId, obj -> mapToReservationVO(obj)));

			List<Integer> collect = reservations.stream().map(TableReservation::getTableId)
					.collect(Collectors.toList());

			TableRequestVO requestVO = new TableRequestVO();
			requestVO.setIds(collect);
			ParameterizedTypeReference<List<TablesVO>> response = new ParameterizedTypeReference<List<TablesVO>>() {
			};
			HttpEntity<TableRequestVO> requestEntity = new HttpEntity<>(requestVO);
			ResponseEntity<List<TablesVO>> responseEntity = restTemplate
					.exchange("http://restaurant-service/tables/tableIds", HttpMethod.POST, requestEntity, response);
			List<TablesVO> tables = responseEntity.getBody();

			Map<Integer, TablesVO> tableMap = tables.stream()
					.collect(Collectors.toMap(TablesVO::getTableId, obj -> obj));

			vos = reservations.stream()
					.map(reservation -> mapToReservationVO(voMap.get(reservation.getTableReservationId()),
							tableMap.get(reservation.getTableId())))
					.collect(Collectors.toList());
		}
		return vos;
	}

	public List<ReservationVO> findReservationsByUser(Integer userId) throws Exception {
		List<ReservationVO> vos = null;
		List<TableReservation> reservations = (List<TableReservation>) reservationRepository.findByUserId(userId);
		if (!reservations.isEmpty()) {
			Map<Integer, ReservationVO> voMap = reservations.stream()
					.collect(Collectors.toMap(TableReservation::getTableReservationId, obj -> mapToReservationVO(obj)));

			List<Integer> collect = reservations.stream().map(TableReservation::getTableId)
					.collect(Collectors.toList());

			TableRequestVO requestVO = new TableRequestVO();
			requestVO.setIds(collect);
			ParameterizedTypeReference<List<TablesVO>> response = new ParameterizedTypeReference<List<TablesVO>>() {
			};
			HttpEntity<TableRequestVO> requestEntity = new HttpEntity<>(requestVO);
			ResponseEntity<List<TablesVO>> responseEntity = restTemplate
					.exchange("http://restaurant-service/tables/tableIds", HttpMethod.POST, requestEntity, response);
			List<TablesVO> tables = responseEntity.getBody();

			Map<Integer, TablesVO> tableMap = tables.stream()
					.collect(Collectors.toMap(TablesVO::getTableId, obj -> obj));

			vos = reservations.stream()
					.map(reservation -> mapToReservationVO(voMap.get(reservation.getTableReservationId()),
							tableMap.get(reservation.getTableId())))
					.collect(Collectors.toList());
		}
		return vos;
	}

	public TableReservationVO createTableReservation(TableReservationVO tableReservationVO) {
		TablesVO tablesVO = getTableById(tableReservationVO.getTableId());
		if (null != tablesVO /* && "A".equalsIgnoreCase(tablesVO.getStatus()) */) {
			TableReservation entity = reservationMapper.maptoEntity(tableReservationVO);
			if (StringUtils.isBlank(tableReservationVO.getStatus())) {
				entity.setStatus("B");
				tablesVO.setStatus("B");
			}

			if (StringUtils.isBlank(tableReservationVO.getBookingId())) {
				String bookingId = StringUtils.rightPad(tableReservationVO.getTableId() + "_"
						+ tableReservationVO.getRestaurantId() + "_" + System.currentTimeMillis(), 10, '0');
				entity.setBookingId(bookingId);
			}
			entity = reservationRepository.save(entity);
			// update DAte

			tablesVO.setBookingEnd(entity.getBookingEnd());
			tablesVO.setBookingStart(entity.getBookingStart());
			updateTable(tablesVO);
			tableReservationVO = reservationMapper.maptoTableReservationVO(entity);
		}
		return tableReservationVO;
	}

	public TablesVO getTableById(Integer id) {
		TablesVO tablesVO = null;
		try {
			ResponseEntity<TablesVO> responseEntity = restTemplate.exchange("http://restaurant-service/tables/" + id,
					HttpMethod.GET, null, new ParameterizedTypeReference<TablesVO>() {
					});
			tablesVO = responseEntity.getBody();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
		return tablesVO;

	}

	public TablesVO updateTable(TablesVO tablesVO) {
		try {
			ParameterizedTypeReference<TablesVO> response = new ParameterizedTypeReference<TablesVO>() {
			};
			HttpEntity<TablesVO> requestEntity = new HttpEntity<>(tablesVO);
			ResponseEntity<TablesVO> responseEntity = restTemplate.exchange("http://restaurant-service/tables/update",
					HttpMethod.POST, requestEntity, response);
			tablesVO = responseEntity.getBody();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
		return tablesVO;

	}

	public Boolean deleteTableReservation(Integer reservationId) {
		reservationRepository.delete(reservationId);
		return true;
	}

	public List<ReservationVO> findAvailableTables() throws Exception {
		List<ReservationVO> vos = null;
		ParameterizedTypeReference<List<TablesVO>> response = new ParameterizedTypeReference<List<TablesVO>>() {
		};
		ResponseEntity<List<TablesVO>> responseEntity = restTemplate.exchange("http://restaurant-service/tables/all",
				HttpMethod.GET, null, response);
		if (null != responseEntity) {
			List<TablesVO> tables = responseEntity.getBody();
			vos = tables.stream().map(table -> mapToReservationVO(null, table)).collect(Collectors.toList());
		}
		return vos;
	}

	private ReservationVO mapToReservationVO(ReservationVO reservationVO, TablesVO tablesVO) {
		if (null == reservationVO) {
			reservationVO = new ReservationVO();
		}
		reservationVO.setTableId(tablesVO.getTableId());
		reservationVO.setTableType(tablesVO.getTableType());
		reservationVO.setTableDesc(tablesVO.getTableDesc());
		reservationVO.setCapacity(tablesVO.getCapacity());
		reservationVO.setStatus(tablesVO.getStatus());
		if (null != tablesVO.getRestaurantVO()) {
			reservationVO.setRestaurantName(tablesVO.getRestaurantVO().getRestaurantName());
			reservationVO.setRestaurantId(tablesVO.getRestaurantVO().getRestaurantId());
		}
		return reservationVO;
	}

	private ReservationVO mapToReservationVO(TableReservation reservation) {
		ReservationVO vo = null;
		vo = mapper.maptoTableReservationVO(reservation);
		return vo;
	}

}
