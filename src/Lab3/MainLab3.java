package Lab3;

import java.util.ArrayList;
import java.util.Collection;
import javax.swing.*;

public class MainLab3 {
    public static void execute(JTextArea output) {
        StringBuffer outputText = new StringBuffer();

        Collection<Mammals> mammalsColl1 = new ArrayList<>();
        mammalsColl1.add(new HedgehogEuropian());
        mammalsColl1.add(new Lynx());
        mammalsColl1.add(new HedgehogEuropian());
        mammalsColl1.add(new Manul());
        mammalsColl1.add(new Manul());
        mammalsColl1.add(new HedgehogEuropian());

        Collection<Hedgehogs> hedgehogsColl1 = new ArrayList<>();
        Collection<Feline> felineColl1 = new ArrayList<>();
        Collection<Predatory> predatoryColl1 = new ArrayList<>();

        Segregation segregation = new Segregation();
        segregation.segregate(mammalsColl1, hedgehogsColl1, felineColl1, predatoryColl1);


        outputText.append("1\nЕжовые:\n");
        hedgehogsColl1.forEach(animal -> animal.who(outputText));
        outputText.append("Кошачьи:\n");
        felineColl1.forEach(animal -> animal.who(outputText));
        outputText.append("Хищные:\n");
        predatoryColl1.forEach(animal -> animal.who(outputText));


        Collection<Predatory> predatoryColl2 = new ArrayList<>();
        predatoryColl2.add(new Manul());
        predatoryColl2.add(new Lynx());
        predatoryColl2.add(new Manul());

        Collection<Chordal> chordalColl2 = new ArrayList<>();
        Collection<Manul> manulColl2 = new ArrayList<>();
        Collection<Feline> felineColl2 = new ArrayList<>();

        segregation.segregate(predatoryColl2, chordalColl2, manulColl2, felineColl2);

        outputText.append("2\nХордовые:\n");
        chordalColl2.forEach(animal -> animal.who(outputText));
        outputText.append("Манулы:\n");
        manulColl2.forEach(animal -> animal.who(outputText));
        outputText.append("Кошачьи:\n");
        felineColl2.forEach(animal -> animal.who(outputText));


        Collection<Hedgehogs> hedgehogsColl3 = new ArrayList<>();
        hedgehogsColl3.add(new HedgehogEuropian());
        hedgehogsColl3.add(new HedgehogEuropian());
        hedgehogsColl3.add(new HedgehogEuropian());

        Collection<Insectivores> insectivoresColl3 = new ArrayList<>();
        Collection<Predatory> predatoryColl3 = new ArrayList<>();
        Collection<Predatory> predatoryColl4 = new ArrayList<>();

        segregation.segregate(hedgehogsColl3, insectivoresColl3, predatoryColl3, predatoryColl4);

        outputText.append("3\nНасекомоядные:\n");
        insectivoresColl3.forEach(animal -> animal.who(outputText));
        outputText.append("Хищные:\n");
        predatoryColl3.forEach(animal -> animal.who(outputText));
        outputText.append("Хищные:\n");
        predatoryColl4.forEach(animal -> animal.who(outputText));

        output.setText(outputText.toString());
    }
}
