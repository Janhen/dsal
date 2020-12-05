package com.janhen.coding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

  public static void main(String[] args) {
    String str = "是的艰苦奋斗是减肥3333---222---2323dfsjsdkfjs3333---222---2323kdsfjskfd ";
    Matcher matcher = Pattern.compile("[\\d-]+").matcher(str);
    while (matcher.find()) {
      System.out.println(matcher.group());
    }
  }
}
