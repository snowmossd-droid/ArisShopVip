package me.vennlmao.arisshop.commands;

import me.vennlmao.arisshop.ArisShop;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ShopCommand implements CommandExecutor {

    private final ArisShop plugin;

    public ShopCommand(ArisShop plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command,
                             @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) return true;
        player.getScheduler().run(plugin, t ->
                plugin.getShopListener().openShop(player), null);
        return true;
    }
}
