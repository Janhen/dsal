/**
 * 版权所有 (C) ，上海海鼎信息工程股份有限公司， 2020 ，所有权利保留。
 * <p>
 * 项目名：  ff
 * 文件名：  Test.java
 * 模块说明：
 * 修改历史：
 * 2020年11月25日 - zhangjiang - 创建。
 */
package com.janhen.coding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhangjiang
 */
public class Test {

  public static void main(String[] args) {
    String str = "是的艰苦奋斗是减肥3333---222---2323dfsjsdkfjs3333---222---2323kdsfjskfd ";
    Matcher matcher = Pattern.compile("[\\d-]+").matcher(str);
    while (matcher.find()) {
      System.out.println(matcher.group());
    }
  }
}
