/**
 *
 */
package fr.emac.gipsi.gsi.voyage;

import fr.emac.gipsi.gsi.screen.Screen;
import fr.emac.gipsi.gsi.voyageur.AbstractVoyageur;

import java.util.ArrayList;

/**
 * @author Truptil Sebastien - sebastien.truptil@gmail.com
 *
 */
public class Voyage extends AbstractVoyage {

    /**
     * @param listPlanete
     * @param simulatedVoyageur
     */
	
	protected ArrayList<Planete> listPlanete;
	protected AbstractVoyageur simulatedVoyageur;
	protected ArrayList<Planete> listPlanetePhotographie;
	
	
    public Voyage(ArrayList<Planete> listPlanete, AbstractVoyageur simulatedVoyageur) {
        super(listPlanete, simulatedVoyageur);
        
        this.listPlanete = listPlanete;
        this.simulatedVoyageur = simulatedVoyageur;
        this.listPlanetePhotographie = new ArrayList<Planete> ();
    }

    /**
     * @param listPlanete
     * @param simulatedVoyageur
     * @param realVoyager
     */
    public Voyage(ArrayList<Planete> listPlanete, AbstractVoyageur simulatedVoyageur, AbstractVoyageur realVoyager) {
        super(listPlanete, simulatedVoyageur, realVoyager);
        // TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyage.AbstractVoyage#showFromPlanete(fr.emac.gipsi.gsi.voyage.Planete)
     */
    @Override
    public int showFromPlanete(Planete p) {
        // TODO Auto-generated method stub
        return 0;
    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyage.AbstractVoyage#showAll()
     */
    @Override
    public int showAll() {
        // TODO Auto-generated method stub
        return 0;
    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyage.AbstractVoyage#pilotage()
     */
    @Override
    public void lancement() {
        
    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyage.AbstractVoyage#pilotageSimuler()
     */
    @Override
    public void lancementSimuler() {
        // TODO Auto-generated method stub
		System.out.println("Debut");
    	this.prendrePhoto(this.listPlanete.get(0));
    	wait(500);
    	System.out.println("Premier appel " + this.listPlanetePhotographie);
    	this.prendrePhoto(this.listPlanete.get(0));
    	System.out.println(" Deuxieme appel " + this.listPlanetePhotographie);

    	
    	/*

    	this.deplacementXY(4,3);
    	this.deplacementXY(1,2);
    	this.deplacementXY(8, 9);
    	this.deplacementXY(8, 1);
    	this.deplacementXY(8, 9);    	
    	
    	AbstractVoyageur _simulatedVoyageur = this.getSimulatedvoyageur();
		for (int i=0; i < 4; i++) {
	        afficheEcran();
	        wait(500);
			_simulatedVoyageur.goForward();
	        afficheEcran();
	        wait(500);
			_simulatedVoyageur.goBackward();
	        afficheEcran();
	        wait(500);
	        _simulatedVoyageur.turnLeft();
	        afficheEcran();
	        wait(500);
		}
		*/
    }
    
    public void deplacementXY(int X, int Y) {
    	
    	AbstractVoyageur _simulatedVoyageur = this.getSimulatedvoyageur();
    	int posBodyX = _simulatedVoyageur.getPosBody().getX();
    	int posBodyY = _simulatedVoyageur.getPosBody().getY();
    	String direction = _simulatedVoyageur.getDirection();
    	
    	int distanceX = X - posBodyX;
    	int distanceY = Y - posBodyY;
    	
    	if (direction == "S" || direction == "N") {
    		if ((direction == "S" && distanceX < 0) || (direction == "N" && distanceX > 0) && distanceX != 0) {
        		for (int distanceParcourueX = 0 ; distanceParcourueX < Math.abs(distanceX) ; distanceParcourueX++) {
        			_simulatedVoyageur.goBackward();
        			afficheEcran();
        			wait(500);
        		}
    		}
    		for (int distanceParcourueX = 0 ; distanceParcourueX < Math.abs(distanceX) ; distanceParcourueX++) {
    			_simulatedVoyageur.goForward();
    			afficheEcran();
    			wait(500);
    		}
    		if ((distanceY < 0 && direction == "N") || (distanceY > 0 && direction == "S") && distanceY != 0) {
    			_simulatedVoyageur.turnLeft();
    			afficheEcran();
    			wait(500);
    		}
    		else if (distanceY != 0) {
    			_simulatedVoyageur.turnRight();
    			afficheEcran();
    			wait(500);
    		}
    		for (int distanceParcourueY = 0 ; distanceParcourueY < Math.abs(distanceY) ; distanceParcourueY++) {
    			_simulatedVoyageur.goForward();
    			afficheEcran();
    			wait(500);
    		}
    	}
    	
    	
    	else {
    		if ((distanceY < 0 && direction == "O") || (distanceY > 0 && direction == "E") && distanceY != 0) {
        		for (int distanceParcourueY = 0 ; distanceParcourueY < Math.abs(distanceY) ; distanceParcourueY++) {
        			_simulatedVoyageur.goForward();
        			afficheEcran();
        			wait(500);
        		}
    		}
    		else {
        		for (int distanceParcourueY = 0 ; distanceParcourueY < Math.abs(distanceY) ; distanceParcourueY++) {
        			_simulatedVoyageur.goBackward();
        			afficheEcran();
        			wait(500);
        		}
    		}
    		
    		if ((distanceX < 0 && direction == "O") || (distanceX > 0 && direction == "E") && distanceX != 0) {
    			_simulatedVoyageur.turnRight();
    			afficheEcran();
    			wait(500);
    		}
    		else if (distanceX != 0) {
    			_simulatedVoyageur.turnLeft();
    			afficheEcran();
    			wait(500);
    		}
    		for (int distanceParcourueX = 0 ; distanceParcourueX < Math.abs(distanceX) ; distanceParcourueX++) {
    			_simulatedVoyageur.goForward();
    			afficheEcran();
    			wait(500);
    		}
    	}
    	System.out.println("On est arrive mon Capitaine !");
    	wait(1000);
    }



    
    
    public void prendrePhoto(Planete planeteActuelle) {
    	ArrayList<Planete> _listVisibilite = planeteActuelle.getListVisibilite();
    	AbstractVoyageur _simulatedVoyageur = this.getSimulatedvoyageur();    	
    	
		if (_listVisibilite.size() == 0) {
			System.out.println("Au secours je peux pas partir");
		}
		
		else if (listPlanetePhotographie.size() == 0) {
    		listPlanetePhotographie.add(_listVisibilite.get(0));
    	}

		for (int j = 0 ; j < listPlanetePhotographie.size() ; j++ ) {

	    	for (int i = 0; i < _listVisibilite.size(); i++) {
    			
    	    	if (!(listPlanetePhotographie.contains(_listVisibilite.get(i)))) {
    				_simulatedVoyageur.takePicture(listPlanetePhotographie.get(j));
    				listPlanetePhotographie.add(_listVisibilite.get(i));
    				System.out.println("J'ai pris une photo chef");
    			}
    		}
    	}
    }






}
