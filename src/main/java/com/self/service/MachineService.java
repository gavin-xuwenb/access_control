package com.self.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.self.dao.MachineMapper;
import com.self.pojo.Machine;


@Service
public class MachineService {

	@Autowired
	MachineMapper machineMapper;

    public List<Machine> selectAll() {
    	return machineMapper.selectAll();
    }
}
