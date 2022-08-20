package com.powdermc.scoreboard.util;

import java.text.DecimalFormat;

/**
 * @author Arantesxyz
 */

public final class NumberFormatter {

  private final String[] suffixes;

  public NumberFormatter() {
    this.suffixes = new String[]{"", "K", "M", "B", "T", "Q", "L"};
  }

  public String formatNumber(float value) {
    int index = 0;
    float tmp;
    while ((tmp = value / 1000) >= 1) {
      value = tmp;
      ++index;
    }
    DecimalFormat decimalFormat = new DecimalFormat("#.##");
    return decimalFormat.format(value) + this.suffixes[index];
  }
}