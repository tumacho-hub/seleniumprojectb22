package com.cybertek.Office_Hours.day_05;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

/*
public class techCrunch {
// author : (//article[@class='post-block post-block--image post-block--unread'])[1]//a[contains(@aria-label,'Posts by')]
// pictures : (//article[@class='post-block post-block--image post-block--unread'])[1]//img[contains(@sizes,'min-width: 1024px')]
    @Test
    public void test(){
        // Go to https://techcrunch.com/
        Driver.getDriver().get("https://techcrunch.com/");

        List<WebElement> latestNews = Driver.getDriver().findElements(By.xpath("//article[@class='post-block post-block--image post-block--unread']"));
        System.out.println(latestNews.size());
        BrowserUtils.sleep(2);
        for (int i = 1; i <= latestNews.size(); i++) {
            // Verify each article has an author
    String authorLocator = "(//article[@class='post-block post-block--image post-block--unread'])["+i+"]//a[contains(@aria-label,'Posts by')]";
    WebElement authorElement = Driver.getDriver().findElement(By.xpath(authorLocator));
            Assert.assertTrue(authorElement.isDisplayed());

    String pictureLocator = "(//article[@class='post-block post-block--image post-block--unread'])["+i+"]//img[contains(@sizes,'min-width: 1024px')]";
    WebElement pictureElement = Driver.getDriver().findElement(By.xpath(pictureLocator));
    Assert.assertTrue(pictureElement.isDisplayed());

        }

        //    the browser title is the same with the news title
        Random random = new Random();
        int newsNumber = random.nextInt(latestNews.size())+1;
        latestNews.get(newsNumber).click();
        BrowserUtils.sleep(2);
        String expectedTitle = Driver.getDriver().findElement(By.xpath("//h1")).getText();
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        // the links within the news content

List<WebElement> allTheLinksOfTheNews = Driver.getDriver().findElements(By.xpath("//h2[.='The Latest']/../div/div/article["+newsNumber+"]/div[2]/div/div[2]//a"));
Assert.assertTrue(allTheLinksOfTheNews.size()>0);
        for (WebElement eachLinksOfTheNew : allTheLinksOfTheNews) {
            System.out.println("eachLinksOfTheNew = " + eachLinksOfTheNew.getAttribute("href"));
        }

 Driver.closeDriver();
    }
}
 */

/*
Selenium Test Automation Task From commencis.com
Tech Blog Website
Using any test automation framework, Java language (except record/play tools) and Maven
dependency management, please do following:
1- Go to https://techcrunch.com/
2- For “The Latest News” list, verify followings;
        	a. each news has an author
        	b. each news has an image
3- Click one of news from “The Latest News” list to reach the full content and verify followings;
        	a. the browser title is the same with the news title
        	b. the links within the news content
 */
public class TechCrunch {
    // author : (//article[@class='post-block post-block--image post-block--unread'])[1]//a[contains(@aria-label,'Posts by')]
    // pictures: (//article[@class='post-block post-block--image post-block--unread'])[1]//img[contains(@sizes,'min-width: 1024px')]
    @Test
    public void test(){
        // Go to https://techcrunch.com/
        Driver.getDriver().get("https://techcrunch.com/");

                List<WebElement> latestNews = Driver.getDriver().findElements(By.xpath("//article[@class='post-block post-block--image post-block--unread']"));
        System.out.println(latestNews.size());
        BrowserUtils.sleep(2);
        for (int i = 1; i <= latestNews.size(); i++) {
            // Verify each article has an author                                         we concatenating ["+i+"]
            String authorLocator = "(//article[@class='post-block post-block--image post-block--unread'])["+i+"]//a[contains(@aria-label,'Posts by')]";
            WebElement authorElement = Driver.getDriver().findElement(By.xpath(authorLocator));
            Assert.assertTrue(authorElement.isDisplayed());

        String pictureLocator = ("(//article[@class='post-block post-block--image post-block--unread'])["+i+"]//img[contains(@sizes,'min-width: 1024px')]");
        WebElement pictureElement = Driver.getDriver().findElement(By.xpath(pictureLocator));
        Assert.assertTrue(pictureElement.isDisplayed());

        }
        Random random =  new Random();
        int newsNumber = random.nextInt(latestNews.size())+1;
        latestNews.get(newsNumber).click();
        BrowserUtils.sleep(2);
        String expectedTitle = Driver.getDriver().findElement(By.xpath("//h1")).getText();
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        // the links with the news content

        List<WebElement> allLinksOfNews = Driver.getDriver().findElements(By.xpath("\"//h2[.='The Latest']/../div/div/article["+newsNumber+"]/div[2]/div/div[2]//a\""));
        Assert.assertTrue(allLinksOfNews.size()>0);
             for (WebElement eachallLinksOfNews : allLinksOfNews){
                 System.out.println("eachallLinksOfNews = " + eachallLinksOfNews.getAttribute("href"));

             }



    }

}
