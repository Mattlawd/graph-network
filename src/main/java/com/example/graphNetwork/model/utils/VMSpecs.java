package com.example.graphNetwork.model.utils;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class VMSpecs extends TimeDetails {

    private float cores;
    private float ram;

    public void setVMSpecs(VMSpecs vmSpecs) {
        this.cores = vmSpecs.cores;
        this.ram = vmSpecs.ram;
    }

    public VMSpecs() {}

}
