/**
 *
 */
package fr.emac.gipsi.gsi.voyage;

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
<<<<<<< HEAD
	protected ArrayList<Planete> listCulsdeSac;
=======
	protected ArrayList<Planete> listPlaneteCreusee;
	protected ArrayList<Planete> listPlanetePrelevee;
>>>>>>> 7dbd578ba8340961a8f8d32fa8df69f8a0d8fec6
	
	
    public Voyage(ArrayList<Planete> listPlanete, AbstractVoyageur simulatedVoyageur) {
        super(listPlanete, simulatedVoyageur);
        
        this.listPlanete = listPlanete;
        this.simulatedVoyageur = simulatedVoyageur;
        this.listPlanetePhotographie = new ArrayList<Planete> ();
<<<<<<< HEAD
        this.listCulsdeSac = new ArrayList<Planete> ();
=======
        this.listPlaneteCreusee = new ArrayList<Planete> ();
        this.listPlanetePrelevee = new ArrayList<Planete> ();
>>>>>>> 7dbd578ba8340961a8f8d32fa8df69f8a0d8fec6
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
<<<<<<< HEAD
        
    	this.createListDebutCulsdeSac();
    	System.out.println(this.listCulsdeSac);
    	
    	/*
=======
        // TODO Auto-generated method stub
		/*
>>>>>>> 7dbd578ba8340961a8f8d32fa8df69f8a0d8fec6
		System.out.println("Debut");
    	this.prendrePhoto(this.listPlanete.get(0));
    	wait(500);
    	System.out.println("Premier appel " + this.listPlanetePhotographie);
    	this.prendrePhoto(this.listPlanete.get(0));
    	System.out.println(" Deuxieme appel " + this.listPlanetePhotographie);
    	*/
<<<<<<< HEAD
=======

    	/*
    	System.out.println("Debut");
    	this.prendEchantillonSol(this.listPlanete.get(0));
    	wait(500);
    	System.out.println("Premier appel " + this.listPlaneteCreusee);
    	this.prendEchantillonSol(this.listPlanete.get(0));
    	System.out.println(" Deuxieme appel " + this.listPlaneteCreusee);
    	*/
    	
    	/*
    	System.out.println("Debut");
    	this.prendEchantillonRoche(this.listPlanete.get(0));
    	wait(500);
    	System.out.println("Premier appel " + this.listPlanetePrelevee);
    	this.prendEchantillonRoche(this.listPlanete.get(0));
    	System.out.println(" Deuxieme appel " + this.listPlanetePrelevee);
    	*/
    	
>>>>>>> 7dbd578ba8340961a8f8d32fa8df69f8a0d8fec6
    	
    	//this.calculDistance(this.listPlanete.get(0), this.listPlanete.get(1));
    	System.out.println("distance planete1/planete2 :"+ this.calculDistance(this.listPlanete.get(0), this.listPlanete.get(1)));
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
    
    public void createListDebutCulsdeSac() {
    	for (int i = 0; i < this.listPlanete.size(); i++) {
    		if (listPlanete.get(i).getListAccessibilite().size() == 1) {
    			Planete debutCulsdeSac = listPlanete.get(i);
    			Planete voisinProche = debutCulsdeSac.getListAccessibilite().get(0);
    			Planete planetePrecedente = new Planete();
    			
    			while(voisinProche.getListAccessibilite().size() == 2) {
    				planetePrecedente = debutCulsdeSac;
    				debutCulsdeSac = voisinProche;
    				if (debutCulsdeSac.getListAccessibilite().get(0).getPos() != planetePrecedente.getPos()) {
    					voisinProche = debutCulsdeSac.getListAccessibilite().get(0);
    				}
    				else {
    					voisinProche = debutCulsdeSac.getListAccessibilite().get(1);
    				}
    			}
    			this.listCulsdeSac.add(debutCulsdeSac);
    		}
    	}
    }
    
    public void deplacementPlanete(Planete planete) {
    	
    	int posX = planete.getPos().getX();
    	int posY = planete.getPos().getY();
    	
    	this.deplacementXY(posX, posY);
    	
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
			System.out.println("Je vois rien Chef");
		}
		
		else if (listPlanetePhotographie.size() == 0) {
    		listPlanetePhotographie.add(_listVisibilite.get(0));
			System.out.println("J'ai pris une photo Chef");
    	}

		for (int j = 0 ; j < listPlanetePhotographie.size() ; j++ ) {

	    	for (int i = 0; i < _listVisibilite.size(); i++) {
    			
    	    	if (!(listPlanetePhotographie.contains(_listVisibilite.get(i)))) {
    				_simulatedVoyageur.takePicture(listPlanetePhotographie.get(j));
    				listPlanetePhotographie.add(_listVisibilite.get(i));
    				System.out.println("J'ai pris une photo Chef");
    			}
    		}
    	}
    }

    
    
    public void prendEchantillonSol(Planete planeteActuelle) {
    	AbstractVoyageur _simulatedVoyageur = this.getSimulatedvoyageur();
    	if ((listPlaneteCreusee.size() == 0)&&(planeteActuelle.getEchantillonSol()!=null)) {
    		listPlaneteCreusee.add(planeteActuelle);
    		System.out.println("J'ai un bloc de dirt Chef");
    	}
    	for(int i=0;i<listPlaneteCreusee.size();i++) {
    		if(planeteActuelle.getEchantillonSol()!=null) {
    			if(!(listPlaneteCreusee.contains(planeteActuelle))) {
    				listPlaneteCreusee.add(planeteActuelle);
    				_simulatedVoyageur.takeEchantillonSol(listPlaneteCreusee.get(i));
    				System.out.println("J'ai un bloc de dirt Chef");
    			}
    		}
    		else {
    			System.out.println("Y a pas de sol Chef");
    		}
    	}
    }

    public void prendEchantillonRoche(Planete planeteActuelle) {
    	AbstractVoyageur _simulatedVoyageur = this.getSimulatedvoyageur();
    	if ((listPlanetePrelevee.size() == 0)&&(planeteActuelle.getEchantillonRoche()!=null)) {
    		listPlanetePrelevee.add(planeteActuelle);
    		System.out.println("J'ai un caillou Chef");
    	}
    	for(int i=0;i<listPlanetePrelevee.size();i++) {
    		if(planeteActuelle.getEchantillonRoche()!=null) {
    			if(!(listPlanetePrelevee.contains(planeteActuelle))) {
    				listPlanetePrelevee.add(planeteActuelle);
    				_simulatedVoyageur.takeEchantillonRoche(listPlanetePrelevee.get(i));
    				System.out.println("J'ai un caillou Chef");
    			}
    		}
    		else {
    			System.out.println("Y a pas de caillou Chef");
    		}
    	}
    }
    
    public double calculDistance(Planete planete1, Planete planete2) {
    	int posXplanete1 = planete1.getPos().getX();
    	int posYplanete1 = planete1.getPos().getY();
    	int posXplanete2 = planete2.getPos().getX();
    	int posYplanete2 = planete2.getPos().getY();
    	double distance = posXplanete2-posXplanete1+posYplanete2-posYplanete1;
    	return(distance);
    }
}
