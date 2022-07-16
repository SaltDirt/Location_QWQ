package com.salt.locatf;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventListener implements Listener {
    @EventHandler
    public void PlayerJoinEvent(PlayerJoinEvent evr){
        Bukkit.broadcastMessage("我们亲爱的"+evr.getPlayer().getName()+"加入了游戏！快去欢♂淫他");
        evr.getPlayer().sendMessage(ChatColor.RED+"Technoblade Never Dies!");
    }
}
