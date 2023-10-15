package com.caj.infra.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caj.domain.masterfile.StationDo;
import com.caj.domain.masterfile.StationRepository;
import com.caj.infra.repository.mapper.StationDao;

@Service
public class StationRepositoryImpl implements StationRepository {

	@Autowired
	StationDao stationDao;

	@Override
	public List<StationDo> findStations() {
		List<StationDo> stationDoList = new ArrayList<>();
		stationDao.findAll().forEach(station -> {
			StationDo stationDo = new StationDo();
			stationDo.setStationCode(station.getStationCode());
			stationDo.setStationDistance(station.getStationDistance());
			stationDo.setStationEngName(station.getStationEngName());
			stationDo.setStationId(station.getStationId());
			stationDo.setStationName(station.getStationName());
			stationDo.setStationOrder(station.getStationOrder());
			stationDoList.add(stationDo);
		});
		return stationDoList;
	}

	@Override
	public int findStationDistance(String departureId, String destinationId) {
		int departureInt = Integer.valueOf(departureId);
		int destinationInt = Integer.valueOf(destinationId);
		String departureStr= departureInt > destinationInt ? String.valueOf(destinationId):departureId;
		String destinationStr= departureInt > destinationInt ? String.valueOf(departureId):destinationId;
		return stationDao.findAll().stream().filter(item -> {
			return Integer.valueOf(item.getStationId()) > Integer.valueOf(departureStr)
					&& Integer.valueOf(item.getStationId()) <= Integer.valueOf(destinationStr);
		}).mapToInt(i -> i.getStationDistance()).sum();
	}

}