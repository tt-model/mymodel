package com.application.v1.core.session;

/**
 * 过滤条件Session
 */
public class FilterSession {

    public static final String FILTER = "filter";

    private MapSession mapSession;

    public MapSession getMapSession() {
        return mapSession;
    }

    public void setMapSession(MapSession mapSession) {
        this.mapSession = mapSession;
    }
}
