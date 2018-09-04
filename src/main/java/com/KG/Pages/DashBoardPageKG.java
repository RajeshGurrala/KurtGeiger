package com.KG.Pages;

import com.KG.Support.ElementUtils;
import org.openqa.selenium.By;

public class DashBoardPageKG {

    ElementUtils utils = new ElementUtils();

    public void assetDashBoardPage(String homeUrl) {
        utils.assertURL(homeUrl);

    }

    public void selectTabFromTheHeaderOnTheDashBoardPage(String tab) throws InterruptedException {
        utils.clickBtn(By.xpath("//span[text()='" + tab + "']"));

    }

}
