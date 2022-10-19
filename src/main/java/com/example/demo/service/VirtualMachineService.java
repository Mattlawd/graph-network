package com.example.demo.service;

import com.example.demo.model.nodes.VirtualMachine;
import com.example.demo.model.utils.VMMetrics;
import com.example.demo.model.utils.VMSpecs;
import com.example.demo.repository.VirtualMachineRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class VirtualMachineService {

    @Autowired
    VirtualMachineRepository virtualMachineRepository;

    public VirtualMachine createVirtualMachine(VirtualMachine newVirtualMachine) {
        return virtualMachineRepository.save(newVirtualMachine);
    }

    public void updateVMSpecs(Long vmId, VMSpecs vmSpecs) {
        VirtualMachine virtualMachine = virtualMachineRepository.findById(vmId).get();
        virtualMachine.setVMSpecs(vmSpecs);
        virtualMachineRepository.save(virtualMachine);
    }

    public void updateVMMetrics(Long vmId, VMMetrics vmMetrics) {
        VirtualMachine virtualMachine = virtualMachineRepository.findById(vmId).get();
        virtualMachine.setVMMetrics(vmMetrics);
        virtualMachineRepository.save(virtualMachine);
    }

    public List<VirtualMachine> getVirtualMachines() {
        return virtualMachineRepository.findAll();
    }

}
