package com.megacrit.cardcrawl.android.mods.devCommands.relic;

import com.megacrit.cardcrawl.android.mods.devCommands.ConsoleCommand;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.RelicLibrary;

import java.util.ArrayList;
import java.util.Arrays;

public class RelicAdd extends ConsoleCommand {
    public RelicAdd() {
        this.requiresPlayer = true;
        this.minExtraTokens = 1;
        this.maxExtraTokens = 1;
        this.simpleCheck = true;
    }

    @Override
    public void execute(String[] tokens, int depth) {
        String[] relicNameArray = Arrays.copyOfRange(tokens, 2, tokens.length);
        String relicName = Relic.getRelicName(relicNameArray);
        AbstractDungeon.getCurrRoom().spawnRelicAndObtain((float)(Settings.WIDTH / 2), (float)(Settings.HEIGHT / 2), RelicLibrary.getRelic(relicName).makeCopy());
    }

    @Override
    public ArrayList<String> extraOptions(String[] tokens, int depth) {
        return ConsoleCommand.getRelicOptions();
    }

    @Override
    public void errorMsg() {
        Relic.cmdRelicHelp();
    }
}
