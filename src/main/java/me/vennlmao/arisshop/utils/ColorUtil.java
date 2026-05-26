package me.vennlmao.arisshop.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;

public class ColorUtil {

    private static final MiniMessage MM = MiniMessage.miniMessage();

    public static Component parse(String raw) {
        String s = raw
                .replaceAll("#([0-9A-Fa-f]{6})", "<color:#$1>")
                .replace("&a", "<green>").replace("&b", "<aqua>").replace("&c", "<red>")
                .replace("&d", "<light_purple>").replace("&e", "<yellow>").replace("&f", "<white>")
                .replace("&7", "<gray>").replace("&6", "<gold>").replace("&4", "<dark_red>")
                .replace("&2", "<dark_green>").replace("&1", "<dark_blue>").replace("&9", "<blue>")
                .replace("&5", "<dark_purple>").replace("&3", "<dark_aqua>").replace("&0", "<black>")
                .replace("&8", "<dark_gray>").replace("&l", "<bold>").replace("&o", "<italic>")
                .replace("&n", "<underlined>").replace("&m", "<strikethrough>")
                .replace("&k", "<obfuscated>").replace("&r", "<reset>");
        return MM.deserialize(s);
    }

    public static String strip(String s) {
        return s.replaceAll("&[0-9a-fk-or]", "")
                .replaceAll("#[0-9A-Fa-f]{6}", "")
                .replaceAll("§[0-9a-fk-or]", "")
                .trim();
    }
}
