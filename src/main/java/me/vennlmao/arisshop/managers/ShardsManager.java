package me.vennlmao.arisshop.managers;

import me.vennlmao.arisshop.ArisShop;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;

public class ShardsManager {

    private final ArisShop plugin;

    public ShardsManager(ArisShop plugin) {
        this.plugin = plugin;
    }

    public double getShards(Player player) {
        if (!plugin.getServer().getPluginManager().isPluginEnabled("PlaceholderAPI")) return 0;
        String placeholder = plugin.getConfig().getString("shards.placeholder", "%aris_shards%");
        String value = PlaceholderAPI.setPlaceholders(player, placeholder);
        try {
            return Double.parseDouble(value.replace(",", ""));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public void takeShards(Player player, int amount) {
        String cmd = plugin.getConfig().getString("shards.take_command", "shards take {player} {amount}");
        String replaced = cmd
                .replace("{player}", player.getName())
                .replace("{amount}", String.valueOf(amount));
        plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), replaced);
    }
}
