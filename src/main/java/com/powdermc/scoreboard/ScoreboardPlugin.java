package com.powdermc.scoreboard;

import com.powdermc.scoreboard.hook.EconomyHook;
import com.powdermc.scoreboard.hook.SecondaryEconomyHook;
import com.powdermc.scoreboard.listener.ScoreboardListener;
import com.powdermc.scoreboard.manager.ScoreboardManager;
import com.powdermc.scoreboard.scheduler.ScoreboardRunnable;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class ScoreboardPlugin extends JavaPlugin {

  private final ScoreboardManager manager = new ScoreboardManager();
  private final EconomyHook economyHook = new EconomyHook();
  private final SecondaryEconomyHook secondaryHook = new SecondaryEconomyHook();

  public static ScoreboardPlugin getInstance() {
    return getPlugin(ScoreboardPlugin.class);
  }

  @Override
  public void onEnable() {
    economyHook.init();
    secondaryHook.init();

    new ScoreboardRunnable().runTaskTimerAsynchronously(this, 0, 20);

    Bukkit.getPluginManager().registerEvents(new ScoreboardListener(), this);
  }
}