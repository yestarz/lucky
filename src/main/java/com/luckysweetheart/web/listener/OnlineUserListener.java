package com.luckysweetheart.web.listener;

import com.luckysweetheart.common.RedisKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 统计在线人数到redis中，现在我也不晓得有什么用，就是玩嘛。
 * Created by yangxin on 2017/6/21.
 */
@WebListener
public class OnlineUserListener implements HttpSessionListener {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final Object object = new Object();


    private static final String ONLINE_USER_COUNT_KEY = RedisKey.REDIS_ONLINE_USER_COUNT_KEY;


    @Override
    public void sessionCreated(HttpSessionEvent se) {
        synchronized (object) {
            ServletContext ctx = se.getSession().getServletContext();
            Integer numSessions = (Integer) ctx.getAttribute("numSessions");
            if (numSessions == null) {
                numSessions = 1;
            } else {
                int count = numSessions;
                numSessions = count + 1;
            }
            ctx.setAttribute("numSessions", numSessions);
            logger.info("创建了Session,count : {}", numSessions);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        synchronized (object) {
            ServletContext ctx = se.getSession().getServletContext();
            Integer numSessions = (Integer) ctx.getAttribute("numSessions");
            if (numSessions == null) {
                numSessions = 0;
            } else {
                int activeSessions = numSessions;
                numSessions = activeSessions - 1;
            }
            ctx.setAttribute("numSessions", numSessions);
            logger.info("销毁了session，count: {}", ctx.getAttribute("numSessions"));
        }
    }
}