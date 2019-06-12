package com.example.opssdkdemo.jni;

import lombok.extern.slf4j.Slf4j;


/**
 * +---------------------------+
 * |I am the most handsome coding peasant.|
 * +---------------------------+
 * <p>Title: SdkApi</p>
 * <p>Description: SdkApi</p>
 * <p>Copyright:Copyright(c) coder 2018/p>
 * <p>Company: poor</p>
 * <p>CreateTime: 2019/5/20 13:43</p>
 * @author cb
 * @version 1.0
 **/
@Slf4j
public abstract class SdkApi
{

    /**
     * 任务唯一标志
     */
    public static int dwID = 0;

    /**
     * <p>Description:初始化</p>
     * <p>CreateTime:2019/5/20 14:22</p>
     * <p>@author cb</p>
     *
     */
    public static void init() throws Exception
    {
        if (!CLibrary.INSTANCE._SDK_Install_InitDll())
        {
            log.info("###【初始化sdk失败！】###");
            throw new RuntimeException("初始化sdk失败");
        }
        log.info("###【初始化sdk成功！】###");

        if (!CLibrary.INSTANCE._SDK_Install_InitNetworkManager(12680, 0))
        {
            log.info("###【初始化网络失败！】###");
            throw new RuntimeException("初始化网络失败");
        }
        log.info("###【初始化网络成功！】###");
        Thread.sleep(6000);

        //TODO 可配置 多个网卡得情况使用该函数
        CLibrary.INSTANCE._SDK_Install_BindNetwork("192.168.1.41");
        Thread.sleep(3000);
        log.info("###【绑定网卡成功！】###");

        //todo 可配置
        dwID = CLibrary.INSTANCE._SDK_Install_AddTask("D:\\mp3\\788mp3.mp3|", "159|", 2,
                null, null, 0);
        log.info("###【添加任务dwID={}】###", dwID);
        Thread.sleep(5000);

    }

}
