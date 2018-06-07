package com.KG.Pages;

import com.KG.Support.ElementUtils;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import static com.KG.Support.BaseClass.driver;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class BrandPageKG {
    ElementUtils utils=new ElementUtils();
    private String SHOP_BY_BRAND_URL="https://www.kurtgeiger.es/shop-by-brand";
    private String SHOP_BY_BRANDS_HEADER_TEXT="//h1[text()='Shop by Brand']";
    private String ALL_BRANDS_LABEL="//a[text()='All brands']";
    private String BRAND_NAME_ON_SEARCHED_ITEM="//h3[@class='product-brand']";
    public void assertBrandPage(){
        //here URL along with page header (Shop by Brand) and All brands text label is used for assertion
        utils.assertURL(SHOP_BY_BRAND_URL);
        assertThat(utils.getTextOfElement(By.xpath(SHOP_BY_BRANDS_HEADER_TEXT)),is(equalToIgnoringCase("Shop by Brand")));
        assertThat(utils.getTextOfElement(By.xpath(ALL_BRANDS_LABEL)),is(equalToIgnoringCase("All brands")));
    }
    public void clickaBrandFromList(String brand) throws InterruptedException {
        //notes: here the text Dolce & Gabbana is extracted from the feature file and is passed as a parameter for the click action. since the locator requires lower and upper case characters
        //substring is used
        utils.clickBtn(By.xpath("//div[@id='shop-by-tabs']//div[@id='tab1']//li//a[text()[contains(.,'"+brand.substring(0,1).toUpperCase()+brand.substring(1,8).toLowerCase()+brand.substring(8,9).toUpperCase()+brand.substring(9,15).toLowerCase()+"')]]"));
    }
    public void assertSearchedItemsOnBrandPage(String brand){
        //here after clicking Dolce & Gabbana tab the items brought up on the screen are screened for the text D & G. if the items
        //brought on the screen are not from D & G assertion fails
            List<WebElement> SearchedItems=driver.findElements(By.xpath(BRAND_NAME_ON_SEARCHED_ITEM));
            for(WebElement check:SearchedItems){
                Assert.assertThat(check.getText(), Matchers.is((brand)));
            }
    }
}
