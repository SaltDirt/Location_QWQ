package com.salt.locatf;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class MainClass extends JavaPlugin {
    @Override
    public void onEnable() {
        this.getLogger().info(ChatColor.GREEN+"由SaltDirt制作的插件 Get Player Location 已加载完成,用指令/help Location_QWQ获取帮助");
    }

    @Override
    public void onDisable() {
        this.getLogger().info(ChatColor.RED+"§2 Goodbye,This world");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("location")){
            if(args.length!=1){
                return false;
            }
            Player p = this.getServer().getPlayer(args[0]);
            sender.sendMessage("玩家"+p.getName()+"所在的坐标是 X="+String.valueOf(p.getLocation().getBlockX())+",Y="+String.valueOf(p.getLocation().getBlockY())+",Z="+String.valueOf(p.getLocation().getBlockZ()));
            return true;
        }
        if(command.getName().equalsIgnoreCase("locationdouble")){
            Player p = this.getServer().getPlayer(args[0]);
            sender.sendMessage("玩家"+p.getName()+"所在的坐标是 X="+String.valueOf(p.getLocation().getX())+",Y="+String.valueOf(p.getLocation().getY())+",Z="+String.valueOf(p.getLocation().getZ()));
            return true;
        }
        if(command.getName().equalsIgnoreCase("moveto")){
            if(sender.isOp()!=true){
                sender.sendMessage(ChatColor.RED+"你是管理吗？");
            }
            Player a = this.getServer().getPlayer(args[0]);
            Player p = (Player)sender;
            Player b = this.getServer().getPlayer(args[1]);
            Location l = b.getLocation();
            String cmd = "/tp "+a.getName()+" "+b.getLocation().getBlockX()+" "+b.getLocation().getBlockY()+" "+b.getLocation().getBlockZ();
            p.chat(cmd);
            return true;
        }
        if(command.getName().equalsIgnoreCase("getspawnpoint")){
            if(args.length!=1){
                return false;
            }
            Player p = this.getServer().getPlayer(args[0]);
            sender.sendMessage("此玩家的重生点为 X="+String.valueOf(p.getBedSpawnLocation().getBlockX())+",Y="+String.valueOf(p.getBedSpawnLocation().getBlockY())+",Z="+String.valueOf(p.getBedSpawnLocation().getBlockZ()));
            return true;
        }
        if(command.getName().equalsIgnoreCase("ping")){
            Player p = this.getServer().getPlayer(args[0]);
            int a = p.getPing();
            sender.sendMessage(a+" FPS");
            return true;
        }
        return false;
    }
}
