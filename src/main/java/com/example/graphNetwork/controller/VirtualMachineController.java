package com.example.graphNetwork.controller;

import com.example.graphNetwork.model.nodes.VirtualMachine;
import com.example.graphNetwork.model.nodes.VMMetrics;
import com.example.graphNetwork.model.nodes.VMSpecs;
import com.example.graphNetwork.service.VirtualMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/neo4j/VM")
public class VirtualMachineController {

    @Autowired
    VirtualMachineService virtualMachineService;

    @PostMapping
    VirtualMachine createVirtualMachine(@RequestBody VirtualMachine newVirtualMachine) {
        return virtualMachineService.createVirtualMachine(newVirtualMachine);
    }

    @PatchMapping("/updateVMSpecs")
    void updateVMSpecs( @RequestBody VMSpecs vmSpecs, @RequestParam Long vmId, @RequestParam @Nullable Long oldVMSpecsId) {
        virtualMachineService.updateVMSpecs(vmSpecs, vmId, oldVMSpecsId);
    }

    @PatchMapping("/updateVMMetrics")
    void updateVMMetrics(@RequestBody VMMetrics vmMetrics, @RequestParam Long vmId, @RequestParam @Nullable Long oldVMMetricsId) {
        virtualMachineService.updateVMMetrics(vmMetrics, vmId, oldVMMetricsId);
    }

    @GetMapping(value = {"", "/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    List<VirtualMachine> getVirtualMachines() {
        return virtualMachineService.getVirtualMachines();
    }

}
