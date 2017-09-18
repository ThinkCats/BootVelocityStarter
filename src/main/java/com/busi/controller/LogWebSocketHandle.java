package com.busi.controller;

import javax.websocket.CloseReason;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.Session;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by wl on 16/7/11.
 */
public class LogWebSocketHandle extends Endpoint {

    private Process process;
    private InputStream inputStream;

    @Override
    public void onOpen(Session session, EndpointConfig endpointConfig) {
        try {
            process = Runtime.getRuntime().exec("ping www.baidu.com");
            inputStream = process.getInputStream();

            // 一定要启动新的线程，防止InputStream阻塞处理WebSocket的线程
            TailLogThread thread = new TailLogThread(inputStream, session);
            thread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClose(Session session, CloseReason closeReason) {
        try {
            if (inputStream != null)
                inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (process != null)
            process.destroy();
    }

    @Override
    public void onError(Session session, Throwable thr) {
        thr.printStackTrace();
    }
}

