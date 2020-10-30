package com.bisket.engine.common;

public class Commons {
    public static String getBusinessCompositeKey(String openServiceId, String openAutonomousBodyCode, String managementCode) {
        return String.format("%s|%s|%s", openServiceId, openAutonomousBodyCode, managementCode);
    }
}
