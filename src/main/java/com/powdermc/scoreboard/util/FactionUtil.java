package com.powdermc.scoreboard.util;

import com.massivecraft.factions.entity.BoardColl;
import com.massivecraft.factions.entity.Faction;
import com.massivecraft.factions.entity.MPlayer;
import com.massivecraft.massivecore.ps.PS;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.bukkit.entity.Player;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FactionUtil {

  public static Faction getFaction(Player player) {
    return MPlayer.get(player).getFaction();
  }

  public static String getZoneNameOnLocation(Player player) {
    Faction factionAt = BoardColl.get().getFactionAt(PS.valueOf(player.getLocation()));

    return factionAt.getName();
  }

  public static String getPlayerPower(Player player) {
    MPlayer mPlayer = MPlayer.get(player);
    return mPlayer.getPowerRounded() + "/" + mPlayer.getPowerMaxRounded();
  }

  public static String getPlayerFactionNameAndTag(Player player) {
    Faction faction = getFaction(player);
    return "[" + faction.getTag() + "] " + faction.getName();
  }

  public static int getFactionPower(Player player) {
    return getFaction(player).getOnlinePlayers().size();
  }

  public static int getMembersOnFaction(Player player) {
    return getFaction(player).getOnlinePlayers().size();
  }

  public static String getLandsOnFaction(Player player) {
    NumberFormatter formatter = new NumberFormatter();
    return formatter.formatNumber(getFaction(player).getLandCount());
  }
}