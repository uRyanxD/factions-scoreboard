package com.powdermc.scoreboard.manager;

import com.powdermc.scoreboard.ScoreboardPlugin;
import com.powdermc.scoreboard.util.FactionUtil;
import fr.mrmicky.fastboard.FastBoard;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public final class ScoreboardManager {

  public void updateBoard(FastBoard board) {
    for (Player player : Bukkit.getOnlinePlayers()) {

      board.updateTitle("§6§lFACTIONS ORION");

      if (FactionUtil.getFaction(player).isNone()) {
        board.updateLines(
            "     §8" + FactionUtil.getZoneNameOnLocation(player),
            "",
            "§fPoder: §a" + FactionUtil.getPlayerPower(player),
            "§fCoins: §a" + ScoreboardPlugin.getInstance().getEconomyHook()
                .getBalanceFormatted(player),
            "§fCash: §a" + ScoreboardPlugin.getInstance().getSecondaryHook()
                .getBalanceFormatter(player),
            "",
            "§7Sem facção",
            "",
            "§ewww.redepowder.com"
        );
      } else {
        board.updateLines(
            "     §8" + FactionUtil.getZoneNameOnLocation(player),
            "",
            "§fPoder: §a" + FactionUtil.getPlayerPower(player),
            "§fCoins: §a" + ScoreboardPlugin.getInstance().getEconomyHook()
                .getBalanceFormatted(player),
            "§fCash: §a" + ScoreboardPlugin.getInstance().getSecondaryHook()
                .getBalanceFormatter(player),
            "",
            " §e" + FactionUtil.getPlayerFactionNameAndTag(player),
            "  §fTerras: §e" + FactionUtil.getFactionPower(player),
            "  §fOnline: §e" + FactionUtil.getMembersOnFaction(player),
            "  §fPoder: §e" + FactionUtil.getPlayerPower(player),
            "",
            "§ewww.redepowder.com"
        );
      }
    }
  }
}