package com.esg.global;

import static org.junit.Assert.assertThrows;
import org.junit.Test;

public class CalculatorTest {

  @Test
  public void add_emptyString_returns_0() {

    Calculator calculator = new Calculator();

    int result = calculator.Add("");

    assert result == 0;
  }

  @Test
  public void add_singleNumber_returnsNumber() {
    Calculator calculator = new Calculator();

    int result = calculator.Add("1");

    assert result == 1;
  }

  @Test
  public void add_twoNumbers_returnsSum() {

    Calculator calculator = new Calculator();

    int result = calculator.Add("1,2");

    assert result == 3;
  }

  @Test
  public void add_unknownNumbers_returnsSum(){
    Calculator calculator = new Calculator();

    int result = calculator.Add("1,2,3,4,5");

    assert result == 15;
  }

  @Test
  public void add_newLinesBetweenNumber_returnsSum(){
    Calculator calculator = new Calculator();

    int result = calculator.Add("1\n,2,3");

    assert result == 6;
  }

  @Test
  public void addWithDelimiterReturnsSum() {
    Calculator calculator = new Calculator();

    int result = calculator.Add("//;\n1;2");

    assert result == 3;
  }

  @Test
  public void addNegativeNumber_throwsException() {
    Calculator calculator = new Calculator();
    assertThrows(IllegalArgumentException.class, () -> {
      calculator.Add("-1,2");
    });
  }

  @Test
  public void addMultipleNegativeNumbers_throwsException() {
    Calculator calculator = new Calculator();
    assertThrows(IllegalArgumentException.class, () -> {
      calculator.Add("2,-4,3,-5");
    });
  }

  @Test
  public void testAddNumbersGreaterThan1000AreIgnored() {
    Calculator calculator = new Calculator();
    int result = calculator.Add("1001,2");
    assert result ==2;
  }

  @Test
  public void testAddDelimetersAnyLength() {
    Calculator calculator = new Calculator();

    int result = calculator.Add("//[|||]\n1|||2|||3");

    assert result ==6;

  }

  @Test
  public void testAddMultipleDelimiters() {
    Calculator calculator = new Calculator();

    int result = calculator.Add("//[|][%]\n1|2%3");

    assert result ==6;

  }

  @Test
  public void testAddMultipleDelimitersAnyLength() {
    Calculator calculator = new Calculator();

    int result = calculator.Add("//[||][%%%]\n1||2%%%3");

    assert result ==6;
  }
}