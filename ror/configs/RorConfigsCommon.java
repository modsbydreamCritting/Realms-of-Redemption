package com.dreamcritting.ror.configs;

import ca.weblite.objc.Proxy;
import net.neoforged.neoforge.common.ModConfigSpec;

public class RorConfigsCommon {
    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec SPEC;
    public static final ModConfigSpec.ConfigValue<Boolean> FIRST_LOAD_MESSAGE;
    public static final ModConfigSpec.ConfigValue<Boolean> FIRST_LOAD_GUIDE;
    public static final ModConfigSpec.ConfigValue<Double> KILLBOT_HEALTH;
    public static final ModConfigSpec.ConfigValue<Double> KILLBOT_DAMAGE;
    public static final ModConfigSpec.ConfigValue<Double> CORRUNDODILE_HEALTH;
    public static final ModConfigSpec.ConfigValue<Double> CORRUNDODILE_DAMAGE;
    public static final ModConfigSpec.ConfigValue<Double> NEONICA_HEALTH;
    public static final ModConfigSpec.ConfigValue<Double> NEONICA_DAMAGE;
    public static final ModConfigSpec.ConfigValue<Double> MOX_HEALTH;
    public static final ModConfigSpec.ConfigValue<Double> MOX_DAMAGE;
    public static final ModConfigSpec.ConfigValue<Double> TITANIA_HEALTH;
    public static final ModConfigSpec.ConfigValue<Double> TITANIA_DAMAGE;
    public static final ModConfigSpec.ConfigValue<Double> TITANIA_ATTACK_SPEED_MULTIPLIER;
    public static final ModConfigSpec.ConfigValue<Double> MOX_ATTACK_SPEED_MULTIPLIER;
    public static final ModConfigSpec.ConfigValue<Boolean> CUSTOM_MOB_ATTRIBUTES;

    static {
        BUILDER.push("Realms of Redemption Configs");
        FIRST_LOAD_MESSAGE = BUILDER.comment("Shows a message on first joining a world").define("First Load Message", true);
        FIRST_LOAD_GUIDE = BUILDER.comment("Gives the player a guide book to the mod on first world load").define("Do first load guide", true);
        BUILDER.pop();
        BUILDER.push("Difficulty");
        KILLBOT_HEALTH = BUILDER.comment("Any health values over 1024 will REQUIRE AttributeFix or another mod which raises the vanilla health cap").define("Killbot Health", (double) 750);
        KILLBOT_DAMAGE = BUILDER.define("Killbot Damage", (double) 7);
        CORRUNDODILE_HEALTH = BUILDER.define("Corrundodile Health", (double) 800);
        CORRUNDODILE_DAMAGE = BUILDER.define("Corrundodile Damage", (double) 8);
        NEONICA_HEALTH = BUILDER.define("Neonica Health", (double) 1000);
        NEONICA_DAMAGE = BUILDER.define("neonica Damage", (double) 9);
        MOX_HEALTH = BUILDER.define("Mox Health", (double) 1000);
        MOX_DAMAGE = BUILDER.define("Mox Damage", (double) 6);
        TITANIA_HEALTH = BUILDER.define("Titania Health", (double) 1000);
        TITANIA_DAMAGE = BUILDER.define("Titania Damage", (double) 8);
        TITANIA_ATTACK_SPEED_MULTIPLIER = BUILDER.comment("Multiplies the chance of Titania using a spell by this value").define("Titania Attack Speed Multiplier * 100", (double) 100);
        MOX_ATTACK_SPEED_MULTIPLIER = BUILDER.define("Mox Attack Speed Multiplier * 100", (double) 100);
        CUSTOM_MOB_ATTRIBUTES = BUILDER.comment("Enables or disables changes to mob attributes made in this config, disable if using another mod which modifies starting mob health/damage. Custom values set in this config WILL NOT WORK unless you change this to true!").define("Custom Mob Attributes", false);

        BUILDER.pop();

        SPEC = BUILDER.build();
    }

}
