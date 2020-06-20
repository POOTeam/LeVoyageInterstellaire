package fr.emac.gipsi.gsi.launch;

import java.util.ArrayList;

import fr.emac.gipsi.gsi.ecran.ListScreen;
import fr.emac.gipsi.gsi.screen.Screen;
import fr.emac.gipsi.gsi.voyage.Planete;
import fr.emac.gipsi.gsi.voyage.Voyage;
import fr.emac.gipsi.gsi.voyageur.AbstractVoyageur;
import fr.emac.gipsi.gsi.voyageur.VoyageurSimuler;

public class LaunchVoyage {

    public static void main(String[] args) {
        ArrayList<Planete> listPlanete = new ArrayList<>();

        Planete p1 = new Planete();
        p1.setColorName("DarkSalmon");
        p1.setEchantillonRoche(ListScreen.gruiki());
        p1.setEchantillonSol(ListScreen.gruiki());
        p1.setRayon(0);
        p1.getPos().setX(1);
        p1.getPos().setY(1);
        listPlanete.add(p1);

        Planete p2 = new Planete();
        p2.setColorName("DeepPink");
        p2.setEchantillonRoche(ListScreen.funecire());
        p2.setEchantillonSol(ListScreen.hericendre());
        p2.setRayon(0);
        p2.getPos().setX(1);
        p2.getPos().setY(9);
        listPlanete.add(p2);
        
        Planete p3 = new Planete();
        p3.setColorName("Red");
        p3.setEchantillonRoche(ListScreen.dracoloss());
        p3.setEchantillonSol(ListScreen.germinion());
        p3.setRayon(0);
        p3.getPos().setX(5);
        p3.getPos().setY(8);
        listPlanete.add(p3);
        
        Planete p4 = new Planete();
        p4.setColorName("Black");
        p4.setEchantillonRoche(ListScreen.funecire());
        p4.setEchantillonSol(ListScreen.hericendre());
        p4.setRayon(0);
        p4.getPos().setX(4);
        p4.getPos().setY(5);
        listPlanete.add(p4);
        
        Planete p5 = new Planete();
        p5.setColorName("White");
        p5.setEchantillonRoche(ListScreen.funecire());
        p5.setEchantillonSol(ListScreen.hericendre());
        p5.setRayon(0);
        p5.getPos().setX(8);
        p5.getPos().setY(6);
        listPlanete.add(p5);
        
        Planete p6 = new Planete();
        p6.setColorName("Blue");
        p6.setEchantillonRoche(ListScreen.funecire());
        p6.setEchantillonSol(ListScreen.hericendre());
        p6.setRayon(0);
        p6.getPos().setX(6);
        p6.getPos().setY(1);
        listPlanete.add(p6);
        
        Planete p7= new Planete();
        p7.setColorName("Yellow");
        p7.setEchantillonRoche(ListScreen.funecire());
        p7.setEchantillonSol(ListScreen.hericendre());
        p7.setRayon(0);
        p7.getPos().setX(2);
        p7.getPos().setY(7);
        listPlanete.add(p7);
        
        // 1-2
        p2.getListAccessibilite().add(p1);
        p1.getListAccessibilite().add(p2);
        // 2-3
        p2.getListAccessibilite().add(p3);
        p3.getListAccessibilite().add(p2);
        // 3-4
        p4.getListAccessibilite().add(p3);
        p3.getListAccessibilite().add(p4);
        // 2-4
        p4.getListAccessibilite().add(p2);
        p2.getListAccessibilite().add(p4);
        // 4-5
        p4.getListAccessibilite().add(p5);
        p5.getListAccessibilite().add(p4);
        // 5-6
        p5.getListAccessibilite().add(p6);
        p6.getListAccessibilite().add(p5);
        // 7-6
        p7.getListAccessibilite().add(p6);
        p6.getListAccessibilite().add(p7);

        
        // 1-2
        p2.getListVisibilite().add(p1);
        p1.getListVisibilite().add(p2);
        // 2-3
        p2.getListVisibilite().add(p3);
        p3.getListVisibilite().add(p2);
        // 3-4
        p4.getListVisibilite().add(p3);
        p3.getListVisibilite().add(p4);
        // 2-4
        p4.getListVisibilite().add(p2);
        p2.getListVisibilite().add(p4);
        // 4-5
        p4.getListVisibilite().add(p5);
        p5.getListVisibilite().add(p4);
        // 5-6
        p5.getListVisibilite().add(p6);
        p6.getListVisibilite().add(p5);
        // 7-6
        p7.getListVisibilite().add(p6);
        p6.getListVisibilite().add(p7);
        
        
        AbstractVoyageur simulatedVoyageur = new VoyageurSimuler(); // voyageur qui va faire le parcours
        
        simulatedVoyageur.getPosTete().setX(listPlanete.get(0).getPos().getX());
        simulatedVoyageur.getPosTete().setY(listPlanete.get(0).getPos().getY());
        simulatedVoyageur.getPosBody().setX(listPlanete.get(0).getPos().getX());
        simulatedVoyageur.getPosBody().setY(listPlanete.get(0).getPos().getY()-1);
        simulatedVoyageur.setDirection("E");

        
        Voyage voyage = new Voyage(listPlanete, simulatedVoyageur);
        
        voyage.lancementSimuler();
    }

}