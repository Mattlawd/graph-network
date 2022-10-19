package com.example.graphNetwork.model.utils;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class VMMetrics extends VMSpecs {

    private float cpuUtilisation;
    private float availableMemory;

    public void setVMMetrics(VMMetrics vmMetrics) {
        this.cpuUtilisation = vmMetrics.getCpuUtilisation();
        this.availableMemory = vmMetrics.getAvailableMemory();
    }


}
