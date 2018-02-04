package com.application.v1.core.session;

import com.application.v1.library.RequestServletUtil;

import javax.servlet.http.HttpSession;

/**
 * 过滤条件Session
 */
public class FilterSession {

    public static final String FILTER = "filter";

    public FilterSession() {
        HttpSession session = RequestServletUtil.fetchSession();
        MapSession mapSession = (MapSession) session.getAttribute(FILTER);
        if (null != mapSession) {

        } else {
            mapSession = new MapSession();
        }
        setMapSession(mapSession);
    }

    private MapSession mapSession;

    public MapSession getMapSession() {
        return mapSession;
    }

    public void setMapSession(MapSession mapSession) {
        this.mapSession = mapSession;
    }
}
