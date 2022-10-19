package com.example.demo.service;

import com.example.demo.model.edges.Flow;
import com.example.demo.model.edges.NICToVMRelationship;
import com.example.demo.model.nodes.ExternalNIC;
import com.example.demo.model.nodes.InternalNIC;
import com.example.demo.model.nodes.NIC;
import com.example.demo.model.nodes.VirtualMachine;
import com.example.demo.repository.NetworkInterfaceCardRepository;
import com.example.demo.repository.VirtualMachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NetworkInterfaceCardService {

    @Autowired
    NetworkInterfaceCardRepository networkInterfaceCardRepository;

    @Autowired
    VirtualMachineRepository virtualMachineRepository;

    public InternalNIC createInternalNIC(InternalNIC internalNIC) {
        return networkInterfaceCardRepository.save(internalNIC);
    }

    public ExternalNIC createExternalNIC(ExternalNIC externalNIC) {
        return networkInterfaceCardRepository.save(externalNIC);
    }

    public List<NIC> getNetworkInterfaceCards() {
        return networkInterfaceCardRepository.findAll();
    }

    public NIC createFlow(Flow flow, Long outboundNICId, Long inboundNICId) {

        NIC inboundNIC = networkInterfaceCardRepository.findById(inboundNICId).get();
        NIC outboundNIC = networkInterfaceCardRepository.findById(outboundNICId).get();
        flow.setInboundNIC(inboundNIC);
        List<Flow> outboundFlows = outboundNIC.getOutgoingFlows();
        outboundFlows.add(flow);
        return networkInterfaceCardRepository.save(outboundNIC);

    }

    public NIC createNICtoVMConnection(Long networkInterfaceCardId, Long virtualMachineId) {


        NICToVMRelationship nicToVMRelationship = new NICToVMRelationship();

        VirtualMachine virtualMachine = virtualMachineRepository.findById(virtualMachineId).get();

        nicToVMRelationship.setVirtualMachine(virtualMachine);

        NIC nic = networkInterfaceCardRepository.findById(networkInterfaceCardId).get();

        List<NICToVMRelationship> nicToVMRelationships = nic.getNicToVMRelationships();
        nicToVMRelationships.add(nicToVMRelationship);
        nic.setNicToVMRelationships(nicToVMRelationships);

        return networkInterfaceCardRepository.save(nic);
    }

}
