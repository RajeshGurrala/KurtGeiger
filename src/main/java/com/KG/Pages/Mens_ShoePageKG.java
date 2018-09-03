package com.KG.Pages;
import com.KG.Support.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import static com.KG.Support.BaseClass.driver;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class Mens_ShoePageKG {
    ElementUtils utils=new ElementUtils();
    private String URL_FOR_MENS_SHOES="https://www.kurtgeiger.es/men/shoes";
    private String HEADER_TEXT_ON_MENS_SHOES_PAGE="//div[@class='category-title']//h1";
    private String ADD_TO_BAG_BUTTON="//span[text()='Add to bag']";
    private String ONE_ITEM_ADDED_TO_CART="//span[@class='skiplinks_count'][text()='1']";
    private String GO_TO_BAG="//a[text()='Go to bag']";
    private String ITEM_THUMBNAIL_IN_PRODUCTS_PAGE="//img[contains(@src,'thumbnail')]";
    private String PAGE_LOADER="//button[@class='switch-domain btn-rounded']";
    public static String shoeSize;
    public static String shoeBrandandColor;

    public void assertMens_ShoePage(){
        utils.assertURL(URL_FOR_MENS_SHOES).
        waitForElementVisible(By.xpath(HEADER_TEXT_ON_MENS_SHOES_PAGE));
        assertThat(utils.getTextOfElement(By.xpath(HEADER_TEXT_ON_MENS_SHOES_PAGE)),is(equalToIgnoringCase("Men's Shoes")));
    }
    public void clickAShoeAndSelectColourAndSize() throws InterruptedException {
        //here all the thumb nails of products that were shown on the search screen are looped via foreach loop and click action is performed
        List<WebElement> shoes = driver.findElements(By.xpath(ITEM_THUMBNAIL_IN_PRODUCTS_PAGE));
       for(WebElement pick:shoes){
           shoeBrandandColor=pick.getAttribute("alt");
           utils.waitForElementVisible(By.xpath(PAGE_LOADER));
           pick.click();
       break;}
utils.waitForElementVisible(By.xpath(ADD_TO_BAG_BUTTON));
        assertThat(utils.getTextOfElement(By.xpath(ADD_TO_BAG_BUTTON)),is(equalToIgnoringCase("Add to bag")));
        //this is the method that randomly selects a different shoe size in each run
        String[] range={"42","43","44","45","46"};
        shoeSize=utils.pickAtRandomWithInRange(range);
        utils.clickBtn(By.xpath("//span[text()='"+shoeSize+"']"));

    }
    public void addItemToCart()  {
        utils.clickBtn(By.xpath(ADD_TO_BAG_BUTTON));

    }
    public void assertItemAddToCart(){
        utils.waitForElementVisible(By.xpath(ONE_ITEM_ADDED_TO_CART));
    }
    public void navigateToCheckOut()  {
        utils.clickBtn(By.xpath(GO_TO_BAG));
    }

}
