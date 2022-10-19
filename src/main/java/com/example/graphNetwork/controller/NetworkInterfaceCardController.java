package com.example.graphNetwork.controller;


import com.example.graphNetwork.model.edges.Flow;
import com.example.graphNetwork.model.nodes.ExternalNIC;
import com.example.graphNetwork.model.nodes.InternalNIC;
import com.example.graphNetwork.model.nodes.NIC;
import com.example.graphNetwork.service.NetworkInterfaceCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/neo4j/NIC")
public class NetworkInterfaceCardController {

    @Autowired
    NetworkInterfaceCardService networkInterfaceCardService;

    @PostMapping("/createInternalNIC")
    InternalNIC createInternalNIC(@RequestBody InternalNIC internalNIC) {
        return networkInterfaceCardService.createInternalNIC(internalNIC);
    }

    @PostMapping("/createExternalNIC")
    ExternalNIC createExternalNIC(@RequestBody ExternalNIC externalNIC) {
        return networkInterfaceCardService.createExternalNIC(externalNIC);
    }

    @PostMapping(value = "/createNICtoVMConnection")
    NIC createNICtoVMConnection(@RequestParam Long networkInterfaceCardId, @RequestParam Long virtualMachineId) {
        return networkInterfaceCardService.createNICtoVMConnection(networkInterfaceCardId, virtualMachineId);

    }

    @PostMapping("/createFlow")
    NIC createFlow(@RequestBody Flow flow, @RequestParam Long outboundNICId, @RequestParam Long inboundNICId){
        return networkInterfaceCardService.createFlow(flow, outboundNICId, inboundNICId);
    }


    @GetMapping(value = { "", "/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    List<NIC> getNetworkInterfaceCards() {
        return networkInterfaceCardService.getNetworkInterfaceCards();
    }

}
