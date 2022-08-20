package com.powdermc.scoreboard.hook;

import com.powdermc.scoreboard.ScoreboardPlugin;
import com.powdermc.scoreboard.util.NumberFormatter;
import org.black_ixx.playerpoints.PlayerPoints;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public final class SecondaryEconomyHook {

  private PlayerPoints playerpoints;

  public void init() {
    Plugin plugin = ScoreboardPlugin.getInstance().getServer().getPluginManager()
        .getPlugin("PlayerPoints");

    playerpoints = (PlayerPoints) plugin;
  }

  public double getBalance(Player player) {
    return playerpoints.getAPI().look(player.getUniqueId());
  }

  public String getBalanceFormatter(Player player) {
    NumberFormatter formatter = new NumberFormatter();
    return formatter.formatNumber((float) getBalance(player));
  }
}