package org.sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagePOM extends Basecls{
	public HomePagePOM() {
	PageFactory.initElements(driver, this);
	}
@FindAll({@FindBy(xpath="//*[@id=\"nav-link-accountList\"]")})
private WebElement txtSignIn;
@FindAll({@FindBy(id="ap_email"),@FindBy(xpath="//input[@type='email']'")})
private WebElement txtEmail;
@FindAll({@FindBy(id="continue"),@FindBy(xpath="//input[@type='submit']'")})
private WebElement btnContinue;
@FindAll({@FindBy(id="ap_password"),@FindBy(xpath="//input[@type='password']'")})
private WebElement txtPassword;
@FindAll({@FindBy(id="signInSubmit"),@FindBy(xpath="//input[@type='submit']'")})
private WebElement btnSignIn;
public WebElement getTxtSignIn() {
	return txtSignIn;
}
public WebElement getTxtEmail() {
	return txtEmail;
}
public WebElement getBtnContinue() {
	return btnContinue;
}
public WebElement getTxtPassword() {
	return txtPassword;
}
public WebElement getBtnSignIn() {
	return btnSignIn;
}


}
