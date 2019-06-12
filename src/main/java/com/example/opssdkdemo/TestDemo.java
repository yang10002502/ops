package com.example.opssdkdemo;

import com.example.opssdkdemo.jni.CLibrary;
import com.example.opssdkdemo.jni.SdkApi;


/**
 * +---------------------------+
 * |I am the most handsome coding peasant.|
 * +---------------------------+
 * <p>Title: TestDemo</p>
 * <p>Description: TestDemo</p>
 * <p>Copyright:Copyright(c) coder 2018/p>
 * <p>Company: poor</p>
 * <p>CreateTime: 2019/6/3 14:07</p>
 * @author cb
 * @version 1.0
 **/
public class TestDemo
{
    public static void main(String[] args) throws Exception
    {
        //******************************************
        //启动后 终端助手得链接应该为YES 否则请先处理网路问题 终端号terminalID通过助手获取
        //******************************************
        SdkApi.init();
        CLibrary.INSTANCE._SDK_Install_StartTask(SdkApi.dwID);
        System.out.println("任务播放成功");

        Thread.sleep(5000);
        /*查看设备状态*/
        int i = CLibrary.INSTANCE._SDK_Install_GetTerminalInformation(159, 2);
        System.out.println("159号当前状态为：" + i);


        Thread.sleep(10000);
        boolean taskStop = CLibrary.INSTANCE._SDK_Install_StopTask(SdkApi.dwID);
        System.out.println("任务是否停止：" + taskStop);
    }
}
