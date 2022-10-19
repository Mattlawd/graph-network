package com.example.graphNetwork.controller;

import com.example.graphNetwork.model.nodes.VirtualMachine;
import com.example.graphNetwork.model.utils.VMMetrics;
import com.example.graphNetwork.model.utils.VMSpecs;
import com.example.graphNetwork.service.VirtualMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
    void updateVMSpecs(@RequestParam Long vmId, @RequestBody VMSpecs vmSpecs) {
        virtualMachineService.updateVMSpecs(vmId, vmSpecs);
    }

    @PatchMapping("/updateVMMetrics")
    void updateVMMetrics(@RequestParam Long vmId, @RequestBody VMMetrics vmMetrics) {
        virtualMachineService.updateVMMetrics(vmId, vmMetrics);
    }

    @GetMapping(value = {"", "/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    List<VirtualMachine> getVirtualMachines() {
        return virtualMachineService.getVirtualMachines();
    }

}