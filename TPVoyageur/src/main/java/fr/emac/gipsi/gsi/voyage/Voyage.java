/**
 *
 */
package fr.emac.gipsi.gsi.voyage;

import fr.emac.gipsi.gsi.screen.Screen;
import fr.emac.gipsi.gsi.voyageur.AbstractVoyageur;

import java.util.ArrayList;
import java.util.Collections;

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
	protected ArrayList<Planete> listCulsdeSac;
	protected ArrayList<Planete> listPlaneteCreusee;
	protected ArrayList<Planete> listPlanetePrelevee;

	protected ArrayList<ArrayList<Planete>> listListAccessibilite;

	public static ArrayList<Integer> listDistance;
	public static ArrayList<ArrayList<Planete>> listChemin;
	

	
	
    public Voyage(ArrayList<Planete> listPlanete, AbstractVoyageur simulatedVoyageur) {
        super(listPlanete, simulatedVoyageur);
        
        this.listPlanete = listPlanete;
        this.simulatedVoyageur = simulatedVoyageur;
        this.listPlanetePhotographie = new ArrayList<Planete> ();
        this.listCulsdeSac = new ArrayList<Planete> ();
    	this.listPlaneteCreusee = new ArrayList<Planete> ();
    	this.listPlanetePrelevee = new ArrayList<Planete> ();
    	this.listListAccessibilite = new ArrayList<ArrayList<Planete>> ();
        this.listPlaneteCreusee = new ArrayList<Planete> ();
        this.listPlanetePrelevee = new ArrayList<Planete> ();

        this.listCulsdeSac = new ArrayList<Planete> ();

    	this.listListAccessibilite = new ArrayList<ArrayList<Planete>> ();

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
    	this.createListDebutCulsdeSac();
    	this.createListListAccessibilite();
    	
        
    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyage.AbstractVoyage#pilotageSimuler()
     */
    @Override
    public void lancementSimuler() {
    	
    	this.lancement();
    	this.trouverPlaneteSuivante(listPlanete.get(2));
    	this.parcourirPlanetes();
    	
    	
    	
    	

    }

    public void parcourirPlanetes() {

    	AbstractVoyageur _simulatedVoyageur = this.getSimulatedvoyageur();
    	ArrayList<Planete> _alreadyVisit = _simulatedVoyageur.getAlreadyVisit();
    	ArrayList<Planete> cheminLePlusCourt = trouverCheminPlusCourt();
    	
    	System.out.println("");
    	System.out.println(cheminLePlusCourt);
    	System.out.println("");
    	int cpt = cheminLePlusCourt.size();
    	if((cheminLePlusCourt.get(cheminLePlusCourt.size()-1).getEchantillonSol()==null)&&(cheminLePlusCourt.get(cheminLePlusCourt.size()-1).getEchantillonRoche()==null)) {
    		cpt -= 1;
    	}
    	for(int i=1;i<cpt;i++) {
    		System.out.println(cheminLePlusCourt.get(i));
    		deplacementPlanete(cheminLePlusCourt.get(i));
    		actionsPlanete(cheminLePlusCourt.get(i));

    	}
		_alreadyVisit.add(cheminLePlusCourt.get(cheminLePlusCourt.size()-1));
		//System.out.println(cheminLePlusCourt.get(cheminLePlusCourt.size()-1).getListAccessibilite());
    }
    
    public void actionsPlanete(Planete planeteActuelle) {
    	System.out.println("");
    	System.out.println(planeteActuelle.getListAccessibilite());
    	System.out.println("");
    	
        prendEchantillonRoche(planeteActuelle);
        prendEchantillonSol(planeteActuelle);
        prendrePhoto(planeteActuelle);

    }
    

    public ArrayList<Planete> trouverCheminPlusCourt() {
    	int distMin = listDistance.get(0);
    	for(int i=1;i<listDistance.size();i++) {
    		if(distMin>listDistance.get(i)) {
    			distMin = listDistance.get(i);
    		}
    	}
		return listChemin.get(listDistance.indexOf(distMin));
    }


    public void trouverPlaneteSuivante(Planete planeteActuelle) {
    	// Fonction qui recherche la prochaine destination du voyageur et le prochain chemin jusqu a cette destination
    	
    	ArrayList<Planete> planetesVoisines = planeteActuelle.getListAccessibilite();
    	AbstractVoyageur _simulatedVoyageur = this.getSimulatedvoyageur();
    	ArrayList<Planete> _alreadyVisit = _simulatedVoyageur.getAlreadyVisit();

    	boolean culsdeSacPasLoin = false;
		
		// Si la liste des planetes visitees est vide alors on ajoute la planete actuelle
    	if (_alreadyVisit == null) {
    		_alreadyVisit = new ArrayList<Planete> ();
    		_alreadyVisit.add(planeteActuelle);
    	}
    	
    	// Pour toutes les planetes voisines
    	for (int i = 0 ; i < planetesVoisines.size() ; i++) {
    		// S il y a des culs de sac proche dans la galaxie
    		if (listCulsdeSac != null) {
    			// S il y a un cul de sac qui commence sur la planete actuelle alors on y va (pour eviter les allers retours)
        		if ((culsdeSacPasLoin == false) &&(listCulsdeSac.contains(planetesVoisines.get(i)) && (!(_alreadyVisit.contains(planetesVoisines.get(i)))))) {
        			culsdeSacPasLoin = true;

        		}
    		}
    	}
    	
    	// S il n y a pas de culs de sac qui commence sur la planete actuelle, on commence la recherche generale
    	if (culsdeSacPasLoin == false) {
    		
    		listDistance = new ArrayList<Integer> ();
    		listChemin = new ArrayList<ArrayList<Planete>> ();
    		
			//System.out.println("e " + planeteActuelle);
    		for (int k = 0; k < planetesVoisines.size(); k++) {
    	    	ArrayList<Planete> cheminEnCours = new ArrayList<Planete> ();
    			cheminEnCours.add(planeteActuelle);
    			cheminEnCours.add(planetesVoisines.get(k));
    			trouverPlanetePlusProche(planetesVoisines.get(k), _alreadyVisit, cheminEnCours,calculDistance(planetesVoisines.get(k), planeteActuelle));
    		}

    	}
    }
    

    public void trouverPlanetePlusProche (Planete planeteActuelle, ArrayList<Planete> alreadyVisit, ArrayList<Planete> cheminEnCours, int distEnCours ) {
    	
    	ArrayList<Planete> planetesVoisines = planeteActuelle.getListAccessibilite();
    	ArrayList<Planete> _listAccessibilite;
    	
    	// Si on a jamais ete sur la planete ou on est en ce moment
    	if (!alreadyVisit.contains(planeteActuelle)) {
    		
    		// Creation de la deep copie de cheminEnCours
        	ArrayList<Planete> cheminAAjouter = new ArrayList<Planete>();
        	for (int i = 0; i < cheminEnCours.size(); i++) {
            	cheminAAjouter.add(cheminEnCours.get(i));
        	}
        	
        	// Ajout du chemin et de la distance du chemin a deux variables globales
    		listChemin.add(cheminAAjouter);
    		listDistance.add(distEnCours);
    		
    		// Le voyageur retourne a la planete precedente,
    		// il enleve a distEnCours la distance entre les deux planetes
    		// il supprime la liaison entre les deux planetes
			distEnCours-=calculDistance(planeteActuelle, cheminEnCours.get(cheminEnCours.size()-1));
			cheminEnCours.get(cheminEnCours.size()-1).getListAccessibilite().remove(planeteActuelle);
			cheminEnCours.remove(planeteActuelle);

			_listAccessibilite = planeteActuelle.getListAccessibilite() ;
			_listAccessibilite = listListAccessibilite.get(this.listPlanete.indexOf(planeteActuelle));
			
			/*
        	System.out.println("b");
    		System.out.println(cheminEnCours);
        	System.out.println("");
        	*/

    	}
    	
    	else {
    		
    		// On enleve les planetes deja sur le parcours de la liste des voisins
    		for (int i = 0; i < cheminEnCours.size(); i++) {
    			planetesVoisines.remove(cheminEnCours.get(i));
    		}
    		// S il reste des voisin a la planete actuelle
    		if (planetesVoisines != null) {
    			// On relance l algo avec un cheminEnCours et une distEnCours modifiee
    			for (int j = 0; j < planetesVoisines.size(); j++) {
    				cheminEnCours.add(planetesVoisines.get(j));
    				distEnCours += calculDistance(planeteActuelle, planetesVoisines.get(j));
    				
    				trouverPlanetePlusProche(planetesVoisines.get(j), alreadyVisit, cheminEnCours, distEnCours);
    			}
    		}
    		// Sinon le voyageur retourne a la planete precedente,
    		// il enleve a distEnCours la distance entre les deux planetes
    		// il supprime la liaison entre les deux planetes
    		// et relance l algo de recherche depuis la planete precedente
    		else {
    			distEnCours-=calculDistance(planeteActuelle, cheminEnCours.get(cheminEnCours.size()-1));
    			cheminEnCours.get(cheminEnCours.size()-1).getListAccessibilite().remove(planeteActuelle);
    			cheminEnCours.remove(planeteActuelle);
    			
    			_listAccessibilite = planeteActuelle.getListAccessibilite() ;
    			_listAccessibilite = listListAccessibilite.get(this.listPlanete.indexOf(planeteActuelle));
    			
    			trouverPlanetePlusProche(cheminEnCours.get(cheminEnCours.size()), alreadyVisit, cheminEnCours, distEnCours);
    		}
    	}
    	
    }
    
    
    public void createListListAccessibilite() {
    	// Fonction qui creer une copie des listes d accessibilite de toutes les planetes
    	
    	for (int i = 0; i < this.listPlanete.size(); i++) {
    		Planete planeteActuelle = listPlanete.get(i);
    		ArrayList<Planete> _listAccessibilite = planeteActuelle.getListAccessibilite();
    		this.listListAccessibilite.add(_listAccessibilite);
    	}
    }
    
    public void createListDebutCulsdeSac() {
    	// Fonction qui creer une liste de toute les planetes qui se trouvent dans un culs de sac
    	// cad les planetes liees a 2 autres planetes sans boucle (qui se termine par une planete solitaire
    	
    	// Pour toute les planetes de la galaxie
    	for (int i = 0; i < this.listPlanete.size(); i++) {
    		// Si la planete n est accessible que par une planete (fin de culs de sac)
    		if (listPlanete.get(i).getListAccessibilite().size() == 1) {
    			Planete debutCulsdeSac = listPlanete.get(i);
    			Planete voisinProche = debutCulsdeSac.getListAccessibilite().get(0);
    			Planete planetePrecedente = new Planete();
    			
    			// On remonte tout les voisins jusqu a ce qu on trouve une planete avec plus de 2 voisins
    			while(voisinProche.getListAccessibilite().size() == 2) {
    				this.listCulsdeSac.add(debutCulsdeSac);
    				planetePrecedente = debutCulsdeSac;
    				debutCulsdeSac = voisinProche;
    				// Selection du prochain voisin parmis les 2 voisins disponible
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
    	// Fonction qui permet de deplacer le voyageur jusqu a une planete donnee
    	
    	int posX = planete.getPos().getX();
    	int posY = planete.getPos().getY();
    	
    	this.deplacementXY(posX, posY);
    	
    }
    

    public void deplacementXY(int X, int Y) {
    	// Fonction qui permet de deplacer le voyageur jusqu a des coordonnees X et Y donnees
    	
    	AbstractVoyageur _simulatedVoyageur = this.getSimulatedvoyageur();
    	int posBodyX = _simulatedVoyageur.getPosBody().getX();
    	int posBodyY = _simulatedVoyageur.getPosBody().getY();
    	String direction = _simulatedVoyageur.getDirection();
    	
    	int distanceX = X - posBodyX;
    	int distanceY = Y - posBodyY;
    	
    	// On commence les deplacements dans le sens du voyageur pour economiser de l energie (tourner consomme 1)
    	if (direction == "S" || direction == "N") {
    		// Si le voyageur est oriente a l envers par rapport a sa destination
    		if ((direction == "S" && distanceX < 0) || (direction == "N" && distanceX > 0) && distanceX != 0) {
    			// On recule de la distance neccessaire
        		for (int distanceParcourueX = 0 ; distanceParcourueX < Math.abs(distanceX) ; distanceParcourueX++) {
        			_simulatedVoyageur.goBackward();
        			afficheEcran();
        			wait(500);
        		}
    		}
    		// Sinon on avance de la distance neccessaire
    		for (int distanceParcourueX = 0 ; distanceParcourueX < Math.abs(distanceX) ; distanceParcourueX++) {
    			_simulatedVoyageur.goForward();
    			afficheEcran();
    			wait(500);
    		}
    		// Orientation du voyageur dans la bonne direction pour le trajet horizontal
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
    		// Le voyageur avance jusqu a sa destination
    		for (int distanceParcourueY = 0 ; distanceParcourueY < Math.abs(distanceY) ; distanceParcourueY++) {
    			_simulatedVoyageur.goForward();
    			afficheEcran();
    			wait(500);
    		}
    	}
    	
    	// Meme principe mais pour un voyageur qui a une position initiale suivant E (est) ou O (ouest)
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
    	// Fonction qui permet depuis une planete de regarder et prendre en photo les planetes alentours
    	// qui ne sont pas deja dans la liste des planetes photographiees
    	
    	ArrayList<Planete> _listVisibilite = planeteActuelle.getListVisibilite();
    	AbstractVoyageur _simulatedVoyageur = this.getSimulatedvoyageur();    	
    	
    	// Le voyageur ne peut pas voir d autres planetes depuis sa position actuelle 
		if (_listVisibilite.size() == 0) {
			System.out.println("Je vois rien Chef");
		}
		
		// Si le voyageur n a pas encore pris de photo il prend en photo la planete sur laquelle il se trouve
		else if (listPlanetePhotographie.size() == 0) {
    		listPlanetePhotographie.add(_listVisibilite.get(0));
			System.out.println("J'ai pris une photo Chef");
    	}
		
		// Pour toute les planetes de la liste des planetes photographiees
		for (int j = 0 ; j < listPlanetePhotographie.size() ; j++ ) {
			// Pour toutes les planetes visibles par le voyageur
	    	for (int i = 0; i < _listVisibilite.size(); i++) {
    			// Si la planete n a jamais ete photographiee avant, le voyageur la prend en photo
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
    
    public int calculDistance(Planete planete1, Planete planete2) {
    	int posXplanete1 = planete1.getPos().getX();
    	int posYplanete1 = planete1.getPos().getY();
    	int posXplanete2 = planete2.getPos().getX();
    	int posYplanete2 = planete2.getPos().getY();
    	int distance = Math.abs(posXplanete2-posXplanete1+posYplanete2-posYplanete1);
    	return(distance);
    }


}

	
