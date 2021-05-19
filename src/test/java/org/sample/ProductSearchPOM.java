package org.sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductSearchPOM extends Basecls{
public ProductSearchPOM() {
PageFactory.initElements(driver, this);
}
@FindAll({@FindBy(id="twotabsearchtextbox"),@FindBy(xpath="//input[@type='text']")})
private WebElement txtSignIn;
@FindAll({@FindBy(id="nav-search-submit-button"),@FindBy(xpath="//input[@type='submit']")})
private WebElement btnSearch;
public WebElement getTxtSignIn() {
	return txtSignIn;
}
public WebElement getBtnSearch() {
	return btnSearch;
}

}

