package com.msgtouch.clienttest;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.msgtouch.common.service.LoginService;
import com.msgtouch.framework.settings.SocketClientSetting;
import com.msgtouch.framework.socket.SocketEngine;
import com.msgtouch.framework.socket.client.MsgTouchClientApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Dean on 2016/10/9.
 */

public class Launch {

    private  static Logger logger= LoggerFactory.getLogger(Launch.class);
    private static final SerializerFeature[] FEATURES=new SerializerFeature[]{SerializerFeature.WriteClassName};
    public static void main(String []args){

        SocketClientSetting socketClientSetting=new SocketClientSetting();
        socketClientSetting.host="127.0.0.1";
        socketClientSetting.port=8001;


        try {
            MsgTouchClientApi msgTouchClientApi=SocketEngine.startClient(socketClientSetting);
            LoginService loginService=msgTouchClientApi.getRpcCallProxy(true, LoginService.class);
           // logger.info(loginService.login("32432423423"));
            logger.info(loginService.test(true,"1",'2',(byte)1,(short)2,3,4.0f,5.0,6L));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
