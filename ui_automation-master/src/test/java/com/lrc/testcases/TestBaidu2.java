package com.lrc.testcases;

import com.lrc.businesslogic.BaiduFlow;
import com.lrc.common.BaseTest;
import com.lrc.config.GlobalDatas;
import com.lrc.page.BaiduPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @param
 * @author lrc
 * @create 2021/12/23
 * @return
 * @description
 **/
public class TestBaidu2 extends BaseTest {
    @BeforeMethod
    public void setup(){
        //用例前置
        //1、打开浏览器
        openBrowser(GlobalDatas.BROWSER_NAME);
        maxBrowser();
        //2、进入百度页面
        toURL(GlobalDatas.INDEX_URL);
    }

    @Test
    public void test_baidu_01(){
        BaiduPage baiduPage=new BaiduPage(driver);
        baiduPage.inputData(GlobalDatas.USER_NAME);
        BaiduFlow baiduFlow=new BaiduFlow(driver);
        baiduFlow.selectTime("最近一月");
    }


    @AfterMethod
    public void teardown(){
        //用例后置
        //退出浏览器
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        quitBrowser();
    }
}
