package com.virtualpairprogrammers.rest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.virtualpairprogrammers.data.Data;
import com.virtualpairprogrammers.domain.VehicleNotFoundException;
import com.virtualpairprogrammers.domain.VehiclePosition;

@RestController
public class PositionReportsController 
{
	@Autowired
	private Data data;
	
	@RequestMapping(method=RequestMethod.GET,value="/vehicles/{vehicleName}")
	public ResponseEntity<VehiclePosition> getLatestReportForVehicle(@PathVariable String vehicleName)
	{
		try 
		{
			VehiclePosition position = data.getLatestPositionFor(vehicleName);
			return new ResponseEntity<VehiclePosition>(position, HttpStatus.OK);
		} 
		catch (VehicleNotFoundException e) 
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/vehicles/")
	public ResponseEntity<List<VehiclePosition>> getUpdatedPositions(@RequestParam(value="since", required=false) Date since)
	{
		throw new UnsupportedOperationException();
	}
}
