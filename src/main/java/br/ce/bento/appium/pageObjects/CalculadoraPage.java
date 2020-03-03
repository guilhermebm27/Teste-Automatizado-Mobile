package br.ce.bento.appium.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;

import static br.ce.bento.appium.base.DriverFactory.getDriver;

import io.appium.java_client.MobileElement;

public class CalculadoraPage {
	
	private static By PrimeiroValor = By.id("com.android.calculator2:id/digit_2");
	private static By SegundoValor = By.id("com.android.calculator2:id/digit_5");
	private static By resultado = By.id("com.android.calculator2:id/result");
	
	
	public void somaDeDoisNumeros() {

		getDriver().findElement(PrimeiroValor).click();
		getDriver().findElementByAccessibilityId("plus").click();
		getDriver().findElement(SegundoValor).click();
		getDriver().findElementByAccessibilityId("equals").click();
		getDriver().findElement(resultado).click();
	}

	public void validarResultado()
	{
		MobileElement result = getDriver().findElement(resultado);
		System.out.println(result.getText());
		Assert.assertEquals("10", result.getText());
	}

}
