package Lab3;

import java.util.Collection;

public class Segregation {
    public void segregate(Collection<? extends Chordal> srcCollection, Collection<? super HedgehogEuropian> collection1,
                          Collection<? super Manul> collection2, Collection<? super Lynx> collection3) {
        for (Chordal animal : srcCollection) {
            if (animal instanceof HedgehogEuropian) {
                collection1.add((HedgehogEuropian) animal);
            } else if (animal instanceof Manul) {
                collection2.add((Manul) animal);
            } else if (animal instanceof Lynx) {
                collection3.add((Lynx) animal);
            }
        }
    }
}
