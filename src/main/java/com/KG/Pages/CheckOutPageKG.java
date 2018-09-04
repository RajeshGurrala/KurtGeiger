package com.KG.Pages;

import com.KG.Support.ElementUtils;
import org.openqa.selenium.By;

import static com.KG.Pages.Mens_ShoePageKG.shoeBrandandColor;
import static com.KG.Pages.Mens_ShoePageKG.shoeSize;
import static com.KG.Support.BaseClass.driver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class CheckOutPageKG {

    ElementUtils utils = new ElementUtils();
    private String SHOESIZE_IN_CHECKOUT = "//p[@class='cart_row--size']";
    private String SHOEBRAND_IN_CHECKOUT = "//img[contains(@src,'thumbnail')]/../..//h3";
    private String SHOECOLOR_IN_CHECKOUT = "//img[contains(@src,'thumbnail')]/../..//h3/..//span";


    public void assertCheckOutPage(String url) {
        utils.assertURL(url);
    }

    public String getShoeSizeInCheckOut() {
        return driver.findElement(By.xpath(SHOESIZE_IN_CHECKOUT)).getText();
    }

    public String getShoeBrandInCheckOut() {
        return driver.findElement(By.xpath(SHOEBRAND_IN_CHECKOUT)).getText();
    }

    public String getShoeColorInCheckOut() {
        return driver.findElement(By.xpath(SHOECOLOR_IN_CHECKOUT)).getText();

    }

    public void crossCheckAddedItem() {
        //here the item in the cart is verified and made sure that the item that shows up in the cart is the one that is actually added
        assertThat(getShoeSizeInCheckOut(), containsString(shoeSize));
        assertThat(shoeBrandandColor.toUpperCase(), containsString((getShoeBrandInCheckOut())));
        assertThat(shoeBrandandColor.toUpperCase(), containsString(getShoeColorInCheckOut()));


    }
}
