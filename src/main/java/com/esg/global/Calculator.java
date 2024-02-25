package com.esg.global;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

  public int Add(String numbers) {
    int sum = 0;

    if (isNullOrEmpty(numbers)) {
      return sum;
    }

    sum = getNumbersSum(numbers);

    return sum;
  }

  private int getNumbersSum(String numbers) {
    int sum = 0;
    String[] numberArray = splitString(numbers);
    List<Integer> negativeNumbers = new ArrayList<>();

    for (String number : numberArray) {
      if (!isNullOrEmpty(number)) {
        int num = Integer.parseInt(number);
          if(num < 0) {
            negativeNumbers.add(num);
          }
          else if(num <= 1000) {
            sum += Integer.parseInt(number);
          }
      }
    }

    throwExceptionForNegativeNumbers(negativeNumbers);

    return sum;
  }

  private static boolean isNullOrEmpty(String numbers) {
    return numbers == null || numbers.trim().isEmpty();
  }

  private void throwExceptionForNegativeNumbers(List<Integer> negativeNumbers) {
    if (!negativeNumbers.isEmpty()) {
      throw new IllegalArgumentException("Negatives not allowed: " + negativeNumbers);
    }
  }

  private String[] splitString(String numbers) {
    String delimiter = ",";

    if (numbers.startsWith("//")) {
      int delimiterIndex = numbers.indexOf("\n") + 1;
      delimiter = numbers.substring(2, delimiterIndex);
      numbers = numbers.substring(delimiterIndex);
    }

    return numbers.split("[\n," + delimiter + "]");
  }
}
