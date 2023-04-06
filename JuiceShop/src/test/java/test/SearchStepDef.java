package test;

import framework.ParentScenario;
import io.cucumber.java.en.Then;

public class SearchStepDef extends ParentScenario{

    @Then("verify search button")
    public void verify_search_button() {
        searchPage.verifySearchButton();
    }

    @Then("search for apple")
    public void search_for_apple() {
        searchPage.search();
    }

    @Then("verify the search result contains only apple product")
    public void verify_the_search_result_contains_only_apple_product() {
        searchPage.verifySearchResult();
    }

}
