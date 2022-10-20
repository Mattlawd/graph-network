package com.example.graphNetwork.service;

import com.example.graphNetwork.model.edges.VMMetricsToVMRelationship;
import com.example.graphNetwork.model.edges.VMSpecsToVMRelationship;
import com.example.graphNetwork.model.nodes.*;
import com.example.graphNetwork.repository.VMMetricsRepository;
import com.example.graphNetwork.repository.VMSpecsRepository;
import com.example.graphNetwork.repository.VirtualMachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

import static java.util.Objects.isNull;

@Service
public class VirtualMachineService {

    @Autowired
    VirtualMachineRepository virtualMachineRepository;

    @Autowired
    VMSpecsRepository vmSpecsRepository;

    @Autowired
    VMMetricsRepository vmMetricsRepository;

    public VirtualMachine createVirtualMachine(VirtualMachine newVirtualMachine) {
        return virtualMachineRepository.save(newVirtualMachine);
    }

    public void updateVMSpecs(VMSpecs vmSpecs, Long vmId, Long oldVMSpecsId) {

        VirtualMachine virtualMachine = virtualMachineRepository.findById(vmId).get();
        VMSpecsToVMRelationship vmSpecsToVMRelationship = new VMSpecsToVMRelationship();
        vmSpecsToVMRelationship.setVirtualMachine(virtualMachine);


        ZonedDateTime nowDateTime = ZonedDateTime.now();

        if (isNull(vmSpecs.getStartDate())) {
            vmSpecs.setStartDate(nowDateTime);
        }
        if (isNull(vmSpecsToVMRelationship.getStartDate())) {
            vmSpecsToVMRelationship.setStartDate(nowDateTime);
        }

        if (!isNull(oldVMSpecsId)) {
            VMSpecs oldVMSpecs = vmSpecsRepository.findById(oldVMSpecsId).get();
            VMSpecsToVMRelationship oldVMSpecsToVMRelationship = oldVMSpecs.getVmSpecsToVMRelationship();
            if (isNull(oldVMSpecs.getEndDate())) {
                oldVMSpecs.setEndDate(nowDateTime);
                vmSpecsRepository.save(oldVMSpecs);
            }
            if (isNull(oldVMSpecsToVMRelationship.getEndDate())) {
                oldVMSpecsToVMRelationship.setEndDate(nowDateTime);
                vmSpecsRepository.save(oldVMSpecs);
            }
        }

        vmSpecs.setVmSpecsToVMRelationship(vmSpecsToVMRelationship);
        vmSpecsRepository.save(vmSpecs);
    }

    public void updateVMMetrics(VMMetrics vmMetrics, Long vmId, Long oldVMMetricsId) {

        VirtualMachine virtualMachine = virtualMachineRepository.findById(vmId).get();
        VMMetricsToVMRelationship vmMetricsToVMRelationship = new VMMetricsToVMRelationship();
        vmMetricsToVMRelationship.setVirtualMachine(virtualMachine);


        ZonedDateTime nowDateTime = ZonedDateTime.now();

        if (isNull(vmMetrics.getStartDate())) {
            vmMetrics.setStartDate(nowDateTime);
        }
        if (isNull(vmMetricsToVMRelationship.getStartDate())) {
            vmMetricsToVMRelationship.setStartDate(nowDateTime);
        }

        if (!isNull(oldVMMetricsId)) {
            VMMetrics oldVMMetrics = vmMetricsRepository.findById(oldVMMetricsId).get();
            VMMetricsToVMRelationship oldVMSpecsToVMRelationship = oldVMMetrics.getVmMetricsToVMRelationship();
            if (isNull(oldVMMetrics.getEndDate())) {
                oldVMMetrics.setEndDate(nowDateTime);
                vmMetricsRepository.save(oldVMMetrics);
            }
            if (isNull(oldVMSpecsToVMRelationship.getEndDate())) {
                oldVMSpecsToVMRelationship.setEndDate(nowDateTime);
                vmMetricsRepository.save(oldVMMetrics);
            }
        }

        vmMetrics.setVmMetricsToVMRelationship(vmMetricsToVMRelationship);
        vmMetricsRepository.save(vmMetrics);

    }

    public List<VirtualMachine> getVirtualMachines() {
        return virtualMachineRepository.findAll();
    }

}
