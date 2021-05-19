package org.sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartDeletionPOM extends Basecls{
	public CartDeletionPOM() {
		PageFactory.initElements(driver, this);
	}
@FindAll({@FindBy(id="nav-cart"),@FindBy(xpath="//a[@class='nav-a nav-a-2 nav-progressive-attribute']")})
private WebElement btnCart;
@FindBy(xpath="//input[@value='Delete'][1]")
private WebElement btnDelete;
public WebElement getBtnCart() {
	return btnCart;
}
public WebElement getBtnDelete() {
	return btnDelete;
}
}
