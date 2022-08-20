package com.powdermc.scoreboard.scheduler;

import com.powdermc.scoreboard.ScoreboardConstants;
import com.powdermc.scoreboard.ScoreboardPlugin;
import fr.mrmicky.fastboard.FastBoard;
import org.bukkit.scheduler.BukkitRunnable;

public final class ScoreboardRunnable extends BukkitRunnable {

  @Override
  public void run() {
    for (FastBoard board : ScoreboardConstants.boards.values()) {
      ScoreboardPlugin.getInstance().getManager().updateBoard(board);
    }
  }
}