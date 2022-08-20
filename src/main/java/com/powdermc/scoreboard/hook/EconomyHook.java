package com.powdermc.scoreboard.hook;

import com.powdermc.scoreboard.util.NumberFormatter;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;

public final class EconomyHook {

  private Economy economy;

  public void init() {
    RegisteredServiceProvider<Economy> registration = Bukkit.getServicesManager()
        .getRegistration(Economy.class);
    if (registration != null) {
      economy = registration.getProvider();
    }
  }

  public double getBalance(Player player) {
    return economy.getBalance(player);
  }

  public String getBalanceFormatted(Player player) {
    NumberFormatter formatter = new NumberFormatter();
    return formatter.formatNumber((float) getBalance(player));
  }
}