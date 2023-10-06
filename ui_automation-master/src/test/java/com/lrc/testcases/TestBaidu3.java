package com.lrc.testcases;

import com.lrc.businesslogic.BaiduFlow;
import com.lrc.common.BaseTest;
import com.lrc.config.GlobalDatas;
import com.lrc.page.BaiduPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @param
 * @author lrc
 * @create 2021/12/25
 * @return
 * @description
 **/
public class TestBaidu3 extends BaseTest {
    @BeforeMethod
    public void setup(){
        //用例前置
        //1、打开浏览器
        openBrowser(GlobalDatas.BROWSER_NAME);
        maxBrowser();
        //2、进入百度页面
        toURL(GlobalDatas.INDEX_URL);
    }

    @Test(dataProvider = "getInputData")
    public void test_baidu_06(String data){
        BaiduPage baiduPage=new BaiduPage(driver);
        baiduPage.inputData(data);
        BaiduFlow baiduFlow=new BaiduFlow(driver);
        baiduFlow.selectTime("最近一月");
        myAssertEquals(1,2,"一定会失败的断言");
    }

    @Test
    public void test_03(){
        BaiduPage baiduPage=new BaiduPage(driver);
        System.out.println("当前driver所有的handles:"+driver.getWindowHandles());
        System.out.println("当前driver所在的handle:"+driver.getWindowHandle());
        baiduPage.clickNews();
       /* System.out.println("点击新闻链接后driver所有的handles:"+driver.getWindowHandles());
        System.out.println("点击新闻链接后driver所在的handle:"+driver.getWindowHandle());
        switchWindowWithTitle("百度新闻——海量中文资讯平台");
        System.out.println("切换窗口后driver所在的handle:"+driver.getWindowHandle());*/
        driver.findElement(By.xpath("//input[@id='ww']")).sendKeys("aaaa");
    }

    @Test
    public void test_04(){
        driver.get("https://www.mi.com/");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当前driver所有的handles:"+driver.getWindowHandles());
        System.out.println("当前driver所在的handle:"+driver.getWindowHandle());
        driver.findElement(By.xpath("//a[text()='MIUI']")).click();
        System.out.println("点击新闻链接后driver所有的handles:"+driver.getWindowHandles());
        System.out.println("点击新闻链接后driver所在的handle:"+driver.getWindowHandle());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        switchWindowWithTitle("MIUI 13 开始·连接万物");
        driver.findElement(By.xpath("//a[text()='Phone']")).click();
    }

    @Test
    public void test_05() throws InterruptedException {
        driver.get("https://ke.qq.com");
        Thread.sleep(2000);
        driver.findElement(By.id("js_login")).click();
        Thread.sleep(2000);
        WebElement iframeElement=driver.findElement(By.xpath("//div[@class='login-qq-iframe-wrap']/iframe"));
        driver.switchTo().frame(iframeElement);
        Thread.sleep(1000);
        driver.findElement(By.id("switcher_plogin")).click();
    }


    @DataProvider
    public Object[][] getInputData(){
        Object[][] datas={
                {"13211112222"},
                {"筱筱创"},
                {"误杀2"},
                {"aaabbb"},
                {"#@!$%^"},
        };
        return datas;
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
