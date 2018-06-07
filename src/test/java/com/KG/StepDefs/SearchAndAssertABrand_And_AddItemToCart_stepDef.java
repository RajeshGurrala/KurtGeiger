package com.KG.StepDefs;
import com.KG.Support.WebModel;
import cucumber.api.java.en.*;

public class SearchAndAssertABrand_And_AddItemToCart_stepDef {

    WebModel webModel=new WebModel();
    @Given("^I am on the homepage$")
    public void iAmOnTheHomepage()  {
        webModel.getDashBoardPageKG().assetDashBoardPage("https://www.kurtgeiger.es/");

    }

    @When("^I select brand category from the header$")
    public void iSelectBrandCategoryFromTheHeader() throws InterruptedException {
        webModel.getDashBoardPageKG().selectTabFromTheHeaderOnTheDashBoardPage("brands");
    }

    @Then("^I should see the list of brands$")
    public void iShouldSeeTheListOfBrands()  {
        webModel.getBrandPageKG().assertBrandPage();

    }

    @And("^I select \"([^\"]*)\" brand from the list$")
    public void iSelectBrandFromTheList(String brand) throws InterruptedException {
        webModel.getBrandPageKG().clickaBrandFromList(brand);

    }

    @Then("^I should see the list of products from \"([^\"]*)\"$")
    public void iShouldSeeTheListOfProductsFrom(String brand) {
        webModel.getBrandPageKG().assertSearchedItemsOnBrandPage(brand);


    }

    @Given("^I select men category from the header$")
    public void iSelectMenCategoryFromTheHeader() throws InterruptedException {
        webModel.getDashBoardPageKG().assetDashBoardPage("https://www.kurtgeiger.es/");
        webModel.getDashBoardPageKG().selectTabFromTheHeaderOnTheDashBoardPage("men");
    }

    @And("^I am on PDP$")
    public void iAmOnPDP() {
        webModel.getMensShoePageKG().assertMens_ShoePage();

    }

    @When("^I select any colour and size for the chosen men category$")
    public void iSelectAnyColourAndSizeForTheChosenMenCategory() throws InterruptedException {
        webModel.getMensShoePageKG().clickAShoeAndSelectColourAndSize();


    }

    @And("^I add the product to the bag$")
    public void iAddTheProductToTheBag() throws InterruptedException {
        webModel.getMensShoePageKG().addItemToCart();

    }

    @Then("^I can see the bag with single item$")
    public void iCanSeeTheBagWithSingleItem()  {
        webModel.getMensShoePageKG().assertItemAddToCart();

    }

    @And("^I click 'Proceed to Checkout'$")
    public void iClickProceedToCheckout() throws InterruptedException {
        webModel.getMensShoePageKG().navigateToCheckOut();

    }

    @Then("^I should be on checkout page$")
    public void iShouldBeOnCheckoutPage() {
        webModel.getCheckOutPageKG().assertCheckOutPage("https://www.kurtgeiger.es/checkout/cart/");
        webModel.getCheckOutPageKG().crossCheckAddedItem();

    }
}
