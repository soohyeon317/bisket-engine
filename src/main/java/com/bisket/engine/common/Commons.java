package com.bisket.engine.common;

public class Commons {
    public static String getCompositeUniqueKey(String openServiceId, String openAutonomousBodyCode, String managementCode) {
        return String.format("{}|{}|{}", openServiceId, openAutonomousBodyCode, managementCode);
    }
}
