package com.dreammaster.scripts.recycling;

import com.dreammaster.scripts.IScriptLoader;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTOreDictUnificator;
import net.minecraftforge.fluids.FluidRegistry;

import java.util.Arrays;
import java.util.List;

import static gregtech.api.enums.Mods.ForbiddenMagic;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.TaintedMagic;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.ThaumicBases;
import static gregtech.api.recipe.RecipeCategories.arcFurnaceRecycling;
import static gregtech.api.recipe.RecipeCategories.maceratorRecycling;
import static gregtech.api.recipe.RecipeMaps.autoclaveRecipes;
import static gregtech.api.recipe.RecipeMaps.cutterRecipes;
import static gregtech.api.recipe.RecipeMaps.maceratorRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;

public class ScriptRecyclingThaumcraft implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "RecyclingThaumcraft";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                GregTech.ID,
                Thaumcraft.ID
        );
    }

    @Override
    public void loadRecipes() {
        cuttingMachineRecycling();
    }

    private void cuttingMachineRecycling() {
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Thaumcraft.ID, "ItemBootsRobe", 1, 0, missing))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemResource", 4, 7, missing))
                .duration(19 * SECONDS + 4 * TICKS).eut(12)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Thaumcraft.ID, "ItemLeggingsRobe", 1, 0, missing))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemResource", 7, 7, missing))
                .duration(24 * SECONDS).eut(15)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Thaumcraft.ID, "ItemChestplateRobe", 1, 0, missing))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemResource", 8, 7, missing))
                .duration(38 * SECONDS + 8 * TICKS).eut(24)
                .addTo(cutterRecipes);
    }

    private void maceratorRecycling() {
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Thaumcraft.ID, "ItemResource", 1, 6, missing))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemResource", 1, 6, missing))
                .duration(1 * MINUTES + 40 * SECONDS).eut(24)
                .recipeCategory(maceratorRecycling)
                .addTo(maceratorRecipes);
    }

    private void fluidExtractorRecycling() {

    }

    private void arcFurnaceRecycling() {

    }
}