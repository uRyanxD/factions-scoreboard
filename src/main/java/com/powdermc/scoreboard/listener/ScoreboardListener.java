package com.powdermc.scoreboard.listener;

import com.powdermc.scoreboard.ScoreboardConstants;
import com.powdermc.scoreboard.ScoreboardPlugin;
import fr.mrmicky.fastboard.FastBoard;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public final class ScoreboardListener implements Listener {

  @EventHandler
  public void onJoin(PlayerJoinEvent event) {
    Player player = event.getPlayer();

    FastBoard board = new FastBoard(player);

    ScoreboardPlugin.getInstance().getManager().updateBoard(board);
    ScoreboardConstants.boards.put(player.getUniqueId(), board);
  }

  @EventHandler
  public void onQuit(PlayerQuitEvent event) {
    Player player = event.getPlayer();

    FastBoard board = ScoreboardConstants.boards.remove(player.getUniqueId());

    if (board != null) {
      board.delete();
    }
  }
}