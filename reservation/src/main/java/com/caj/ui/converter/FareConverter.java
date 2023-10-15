package com.caj.ui.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.caj.domain.fare.FareDo;
import com.caj.ui.dto.FareRequestDTO;

@Service
public class FareConverter {

	/**
	 * toDo
	 * @param departure
	 * @param destination
	 * @param classCode
	 * @param passengerType
	 * @return
	 */
	public FareDo toDo(String departure, String destination, String classCode, String passengerType) {
		return FareDo.builder()
				.departure(departure)
				.destination(destination)
				.classCode(classCode)
				.passengerType(passengerType)
				.build();
	}
	
	/**
	 * toDo
	 * @param fareRequestDTO
	 * @return
	 */
	public List<FareDo> toDo(List<FareRequestDTO> fareRequestDTOs) {
		List<FareDo> fareDos=new ArrayList<>();
		fareRequestDTOs.forEach(item->{
			FareDo fareDo=FareDo.builder()
			.departure(item.getDeparture())
			.destination(item.getDestination())
			.classCode(item.getClassCode())
			.passengerType(item.getPassengerType())
			.build();
			fareDos.add(fareDo);
		});
		return fareDos;
	}
}
