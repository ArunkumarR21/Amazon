package org.sample;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddtoCart extends Basecls {
public AddtoCart() {
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//span[@class='a-size-medium a-color-base a-text-normal'][1]")
private WebElement btnProductClick;
@FindAll({@FindBy(id="add-to-cart-button"),@FindBy(xpath="//input[@title='Add to Shopping Cart']")})
private WebElement btnAddToCart;
@FindBy(xpath="//*[@id=\"attach-sidesheet-checkout-button\"]/span/input")
private WebElement btnProceedButton;
public WebElement getBtnProductClick() {
	return btnProductClick;
}
public WebElement getBtnAddToCart() {
	return btnAddToCart;
}
public WebElement getBtnProceedButton() {
	return btnProceedButton;
}
}
