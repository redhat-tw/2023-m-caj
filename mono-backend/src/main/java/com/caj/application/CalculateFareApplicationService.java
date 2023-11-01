package com.caj.application;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caj.domain.fare.FareDo;
import com.caj.domain.fare.FareService;
import com.caj.domain.masterfile.PassengerTypeService;
import com.caj.domain.masterfile.StationService;

@Service
public class CalculateFareApplicationService {

   /**
	* Logger
	*/
	static Logger log = LoggerFactory.getLogger("jsonLogger");	
	 
	/**
	 * PassengerType Service
	 */
	@Autowired
	PassengerTypeService passengerTypeService;
	
	/**
	 * Station Service
	 */
	@Autowired
	StationService stationService;
	
	/**
	 * Fare Service
	 */
	@Autowired
	FareService fareService;
	
	
	/**
	 * Execute Calculate Fare
	 * @return
	 */
	public int execute(FareDo fareDo) {
		
		// Get Distance
		int distance =stationService.getStationDistance(fareDo.getDeparture(), fareDo.getDestination());
		log.info("distance:{}",distance);
		
		// Get Passenger Discount
		BigDecimal discount= passengerTypeService.getPassengerDiscount(fareDo.getPassengerType());
		log.info("discount:{}",discount);
		
		// Calcute Fare
		int fare=fareService.calcuteFare(distance, discount, fareDo.getClassCode());
		log.info("fare:{}",fare);
		
		return fare;
	}
	
	/**
	 * Execute Calculate Fare
	 * @return
	 */
	public int execute(List<FareDo> fareDos) {
		return fareDos.stream().map(item->{
			return this.execute(item);
		}).mapToInt(Integer::intValue)
        .sum();
	}
	

}
