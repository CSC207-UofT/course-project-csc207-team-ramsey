package test;

import commandline.ShowKitchenRecipesCmd;
import controllers.KitchenControlCentre;
import controllers.RecipeControlCentre;
import entities.User;
import org.junit.Before;
import org.junit.Test;
import usecases.RecipeManager;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class TestShowKitchenRecipesCmd {

    KitchenControlCentre kitchenControl;
    User user;
    String instructions;
    HashMap<String, Float> ingredients;
    ShowKitchenRecipesCmd<RecipeControlCentre> displayRecipesCmd

}
