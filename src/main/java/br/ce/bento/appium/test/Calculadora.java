package br.ce.bento.appium.test;

import java.net.MalformedURLException;

import org.junit.Test;

import br.ce.bento.appium.base.BaseTest;
import br.ce.bento.appium.pageObjects.CalculadoraPage;

public class Calculadora extends BaseTest{
	
	private CalculadoraPage calcular = new CalculadoraPage();

	@Test
	public void calcularSomaDeDoisNumeros() throws MalformedURLException {
		calcular.somaDeDoisNumeros();
		calcular.validarResultado();
	}

}
