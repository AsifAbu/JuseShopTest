package test;

import framework.ParentScenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class OderStepDef extends ParentScenario {

    @Given("user is on home page")
    public void user_is_on_home_page() {
        orderPage.verifyUserIsOnHomePage();
    }

    @Then("add one item to the basket")
    public void add_one_item_to_the_basket() {
        orderPage.addOneItemToBasket();
    }

    @Given("item is already available in the basket")
    public void item_is_already_available_in_the_basket() {
        orderPage.clickOnTheBasketButton();
        orderPage.verifyAddItem();
    }

    @Then("go to the checkout page")
    public void go_to_the_checkout_page() {
        orderPage.clickCheckoutButton();
        orderPage.verifyCheckoutPage();
    }
    @Then("click on the checkout button")
    public void click_on_the_checkout_button() {
        orderPage.clickAddressButton();
    }

    @Then("set a delivery address")
    public void set_a_delivery_address() {
        orderPage.createAddress();
    }

    @Then("select the address and continue")
    public void select_the_address_and_continue() {
        orderPage.selectCreatedAddress();
        orderPage.addressContinue();
    }
    /*
    @Then("choose delivery speed and continue")
    public void choose_delivery_speed_and_continue() {

    }
    @Then("add new card")
    public void add_new_card() {

    }
    @Then("choose added card and continue")
    public void choose_added_card_and_continue() {

    }
    @Then("place order")
    public void place_order() {

    }*/

}
