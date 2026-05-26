package me.vennlmao.arisshop;

import me.vennlmao.arisshop.commands.ShopCommand;
import me.vennlmao.arisshop.listeners.ShopListener;
import me.vennlmao.arisshop.managers.ShardsManager;
import me.vennlmao.arisshop.managers.ShopManager;
import me.vennlmao.arisshop.utils.SoundUtil;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class ArisShop extends JavaPlugin {

    private static ArisShop instance;
    private Economy economy;
    private ShopManager shopManager;
    private ShardsManager shardsManager;
    private ShopListener shopListener;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        if (!setupEconomy()) {
            getLogger().severe("Vault not found! Disabling plugin.");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        shopManager = new ShopManager(this);
        shardsManager = new ShardsManager(this);
        shopListener = new ShopListener(this);

        SoundUtil.init(this);

        getServer().getPluginManager().registerEvents(shopListener, this);
        getCommand("shop").setExecutor(new ShopCommand(this));
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) return false;
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager()
                .getRegistration(Economy.class);
        if (rsp == null) return false;
        economy = rsp.getProvider();
        return economy != null;
    }

    public static ArisShop getInstance() { return instance; }
    public Economy getEconomy() { return economy; }
    public ShopManager getShopManager() { return shopManager; }
    public ShardsManager getShardsManager() { return shardsManager; }
    public ShopListener getShopListener() { return shopListener; }
}
