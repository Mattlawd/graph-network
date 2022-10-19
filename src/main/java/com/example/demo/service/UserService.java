package com.example.demo.service;

import com.example.demo.model.edges.UserToVMRelationship;
import com.example.demo.model.nodes.User;
import com.example.demo.model.nodes.VirtualMachine;
import com.example.demo.repository.NetworkInterfaceCardRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.VirtualMachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    NetworkInterfaceCardRepository networkInterfaceCardRepository;

    @Autowired
    VirtualMachineRepository virtualMachineRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User createUserToVMRelationship(Long userId, Long virtualMachineId, String type) {

        UserToVMRelationship userToVMRelationship = new UserToVMRelationship();
        VirtualMachine virtualMachine = virtualMachineRepository.findById(virtualMachineId).get();
        userToVMRelationship.setVirtualMachine(virtualMachine);
        User user = userRepository.findById(userId).get();

        switch (type) {
            case "INSTANTIATED":
                List<UserToVMRelationship> userInstantiatedConnections = user.getUserInstantiatedConnections();
                userInstantiatedConnections.add(userToVMRelationship);
                user.setUserInstantiatedConnections(userInstantiatedConnections);
            case "LAST_MODIFIED":
                List<UserToVMRelationship> userLastModifiedConnections = user.getUserLastModifiedConnections();
                userLastModifiedConnections.add(userToVMRelationship);
                user.setUserLastModifiedConnections(userLastModifiedConnections);
        }

        return userRepository.save(user);
    }


}
