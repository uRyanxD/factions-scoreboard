package com.powdermc.scoreboard;

import fr.mrmicky.fastboard.FastBoard;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public final class ScoreboardConstants {

  public static final Map<UUID, FastBoard> boards = new ConcurrentHashMap<>();

}