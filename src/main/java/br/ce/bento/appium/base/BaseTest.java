package br.ce.bento.appium.base;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BaseTest {
	
	private AndroidDriver<MobileElement> driver;
	
	@Before
	public void Initialization() throws MalformedURLException {
		driver = DriverFactory.getDriver();
	}
	
	@AfterClass
	public static void finalizarClasse() {
		DriverFactory.killDriver();
	}
	
	@After
	public void tearDown() {
		gerarScreenshot();
		DriverFactory.getDriver().resetApp();
	}
	
	public void gerarScreenshot() {
		try {
		File imagem = ((TakesScreenshot)DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(imagem,  new File("C:\\QA\\Appium\\Screenshot.imagem.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
